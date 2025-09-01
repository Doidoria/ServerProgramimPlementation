package Utils;

//필요한 Java SQL 패키지 import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dtos.MemberDto;	// 사용자 정보를 담는 DTO 클래스 import 받아오기

public class DbUtils {	
	//속성(DB 연결관련된 멤버)
	//DB CONN DATA
	private static String id = "root";	//DB 사용자 ID
	private static String pw = "1234"; 	//DB 사용자 PW
	private static String url = "jdbc:mysql://localhost:3306/opendatadb"; //DB 연결 URL

	//JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체
	
	//기능
	public static void conn() throws Exception
	{
		//드라이브 클래스 메모리 공간 적재
		Class.forName("com.mysql.cj.jdbc.Driver");	// JDBC 드라이버 로딩
		System.out.println("Driver Loading Success...");
		conn=DriverManager.getConnection(url,id,pw); //DriverManager를 통해 객체 -> DB 연결처리 Connection 객체를 반환
		System.out.println("DB CONNECTED...");
		//Connection conn 멤버에 Connection 객체 연결
	}
	public static void disConn() throws Exception {
		//rs / pstmt / conn close 처리
		if(rs!=null)
			rs.close();	//ResultSet 해제
		if(pstmt!=null)
			pstmt.close();	//PreparedStatement 해제
		if(conn!=null)
			conn.close();	//Connection 해제
	}
	public static int insertMember(MemberDto memberDto) throws Exception 
	{
		//tbl_member 에 dto 값 저장 후 int 반환
		pstmt=conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //회원 정보를 tbl_member 테이블에 insert
		// (?) 파라미터에 MemberDto의 값을 차례로 바인딩
		pstmt.setString(1, memberDto.getUserid());
		pstmt.setString(2, memberDto.getPassword());
		pstmt.setString(3, memberDto.getRePassword());
		pstmt.setString(4, memberDto.getUsername());
		pstmt.setString(5, memberDto.getZipcode());
		pstmt.setString(6, memberDto.getAddr1());
		pstmt.setString(7, memberDto.getAddr2());
		pstmt.setString(8, memberDto.getPhone1());
		pstmt.setString(9, memberDto.getPhone2());
		pstmt.setString(10, memberDto.getPhone3());
		pstmt.setString(11, memberDto.getTel1());
		pstmt.setString(12, memberDto.getTel2());
		pstmt.setString(13, memberDto.getTel3());
		pstmt.setString(14, memberDto.getEmail());
		pstmt.setString(15, memberDto.getYear());
		pstmt.setString(16, memberDto.getMonth());
		pstmt.setString(17, memberDto.getDay());
		int result=pstmt.executeUpdate();	// insert 수행 후 결과(삽입된 행 수)를 반환
		return result;	//result 값 반환
	}
	public static MemberDto selectMember(String userid) throws Exception{	
		//tbl_member 에 userid 와 일치하는 데이터 받아와 MemberDto로 반환
		pstmt=conn.prepareStatement("select * from tbl_member where userid=?");  //"userid"에 해당하는 회원 정보를 조회 (select)
		pstmt.setString(1, userid);	 // ?에 userid 바인딩
		rs=pstmt.executeQuery();	// 쿼리 실행
		MemberDto dto=null;
		if(rs!=null) {		// 결과가 존재하면 MemberDto 객체에 데이터 저장
			if(rs.next()) {
				dto=new MemberDto();
				dto.setUserid(rs.getString("userid"));        // 사용자 ID
				dto.setPassword(rs.getString("password"));    // 비밀번호
				dto.setRePassword(rs.getString("rePassword")); // 비밀번호 확인
				dto.setUsername(rs.getString("username"));     // 사용자 이름
				dto.setZipcode(rs.getString("zipcode"));       // 우편번호
				dto.setAddr1(rs.getString("addr1"));           // 주소1
				dto.setAddr2(rs.getString("addr2"));           // 주소2
				dto.setPhone1(rs.getString("phone1"));         // 휴대전화 앞자리
				dto.setPhone2(rs.getString("phone2"));         // 휴대전화 중간자리
				dto.setPhone3(rs.getString("phone3"));         // 휴대전화 끝자리
				dto.setTel1(rs.getString("tel1"));             // 집전화 앞자리
				dto.setTel2(rs.getString("tel2"));             // 집전화 중간자리
				dto.setTel3(rs.getString("tel3"));             // 집전화 끝자리
				dto.setEmail(rs.getString("email"));           // 이메일
				dto.setYear(rs.getString("year"));             // 생년
				dto.setMonth(rs.getString("month"));           // 생월
				dto.setDay(rs.getString("day"));               // 생일
			}
		}
		return dto;	//조회된 MemberDto 객체 반환 (없으면 null)
	}
	// 트랜잭션 시작 메서드 (자동 커밋 해제)
	public static void TxStart() throws Exception{
		if(conn!=null)
			conn.setAutoCommit(false);	// 수동 커밋모드로 전환
	}
	// 트랜잭션 커밋(끝) 메서드
	public static void TxEnd() throws Exception {
		if(conn!=null)
			conn.commit();	// 변경 사항 커밋
	}
	// 트랜잭션 롤백 메서드
	public static void RollBack() throws Exception {
		if(conn!=null)
			conn.rollback();   // 변경 사항 되돌리기
	}
	
}
