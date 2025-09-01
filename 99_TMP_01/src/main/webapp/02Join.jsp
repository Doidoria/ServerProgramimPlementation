<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 문제 : 선언문(적절한 클래스 import 하기) -->
<%@ page import="Dtos.MemberDto,Utils.DbUtils" %>

<%
	/* 문제 : 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");		// 클라이언트에서 보낸 요청의 인코딩을 UTF-8로 설정 (한글 처리 위해 필수)
	response.setContentType("text/html; charset=UTF-8");	// 서버에서 클라이언트로 응답할 때의 Content-Type 설정 (HTML + UTF-8)
%>

<%!
	/* 문제 : 유효성 검증함수 만들기 */
	public boolean isValid(MemberDto dto){
		//1) 각 항목 not null (message : '-' 를 입력하세요 - System.out 으로 출력후 false)
		if(dto.getUserid().isEmpty()){	//User ID가 비어있을 경우
			System.out.println("Userid를 입력하세요.");
			return false;	//false 값 반환
		}
		
		//2) userid 길이 5자 이하(message : Userid는 5자 이상 입력하셔야 합니다.- System.out 으로 출력후 false)
		if(dto.getUserid().length()<5){	//User ID가 5자 미만일 경우
			System.out.println("Userid는 5자 이상 입력하셔야 됩니다.");
			return false;	//false 값 반환
		}

		//3) 패스워드 유효성 검증(regex : ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,20}$ )
		// User PW가 최소 1개 이상 대문자, 소문자, 숫자, 특수문자 포함, 전체 길이 8~20자
		if(!dto.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,20}$")){
			//- System.out 으로 출력후 false
			System.out.println("Password는 대문자, 소문자, 숫자, 특수문자 최소 1개 포함하며 (8~20자)이내로 해야됩니다.");
			return false;	//false 값 반환
		}
		
		return true;	// 모든 검증 통과 시 true 반환
	}
%>    

<!--  
01 문제 : 파라미터 받기 (액션태그 jsp:useBean , jsp:setProperty 로 MemberDto 단위로 받기
-->
<jsp:useBean id="dto" class="Dtos.MemberDto" scope="request"/> <!-- useBean: 폼에서 전달된 파라미터를 MemberDto 객체로 자동 매핑 -->
<jsp:setProperty name="dto" property="*" /> <!-- setProperty: "form"의 input "name"과 "dto"의 property 이름이 일치하면 자동으로 값이 설정됨 -->

<%
	
	try{
		//-----------------------------
		//02 유효성 검증	
		//-----------------------------
		// 유효성 실패 시 메시지는 콘솔에 출력
		if(!isValid(dto)){
			//유효하지 않는경우에 -> 01Join.html 로 Forwarding
			request.getRequestDispatcher("./01Join.html").forward(request, response);	//회원가입 폼(01Join.html)으로 포워딩
			return;	 // 이후 코드 실행 방지
		}
		//-----------------------------
		//03 서비스 처리(회원가입->DB 저장)
		//-----------------------------
		//03-01 db연결
		DbUtils.conn();
		
		//03-02 Tx 시작
		DbUtils.TxStart();
		
		//03-03 동일 계정유무확인
		if(DbUtils.selectMember(dto.getUserid())!=null){ //Userid가 null값이 아니면 중복 여부 확인
			System.out.println("기존 계정이 존재합니다."); 	// 콘솔에 실패 메시지 출력
			request.getRequestDispatcher("./01Join.html").forward(request, response);	//회원가입 폼(01Join.html)으로 포워딩
			return; // 이후 코드 실행 방지
		}
		
		//03-04 계정정보 저장
		int result=DbUtils.insertMember(dto);	// DTO의 데이터를 DB에 저장
		
		//03-05 Tx 종료
		DbUtils.TxEnd();
		
		//03-06 연결해제
		DbUtils.disConn();
		
		//-----------------------------
		//04 로그인 페이지로 이동
		//-----------------------------
		//04-01 "회원가입을 완료했습니다" 를 system.out 으로 출력
		System.out.println("회원가입을 완료했습니다.");
		
		//04-02 Login.jsp 로 리다이렉트
		response.sendRedirect("./03Login.jsp");
		
	}
	catch(Exception e){ // 예외가 발생
		//"문제 발생 ROLLBACK" system.out 출력
		System.out.println("문제 발생 ROLLBACK");
		
		//TX ROLLBACK 처리
		DbUtils.RollBack();
	}
		
%>