package Dtos;

// MemberDto 클래스는 회원 정보를 저장하기 위한 DTO(Data Transfer Object)
public class MemberDto {		// 회원 정보를 담기 위한 멤버 변수들
    private String userid;   	// 사용자 아이디
    private String password; 	// 사용자 비밀번호
    private String rePassword; 	// 비밀번호 확인용 변수
    private String username; 	// 사용자 이름
    private String zipcode; 	// 우편번호
    private String addr1;   	// 주소 1 (기본 주소)
    private String addr2;  	 	// 주소 2 (상세 주소)
    private String phone1; 	 	// 전화번호 앞자리
    private String phone2;  	// 전화번호 중간자리
    private String phone3;  	// 전화번호 뒷자리
    private String tel1;    	// 전화번호 앞자리 (집전화)
    private String tel2;    	// 전화번호 중간자리 (집전화)
    private String tel3;    	// 전화번호 뒷자리 (집전화)
    private String email;   	// 이메일 주소
    private String year;    	// 생년
    private String month;   	// 생월
    private String day;     	// 생일

    // 디폴트 생성자
    public MemberDto() {}

    // 모든 인자를 받는 생성자, 각 멤버 변수를 초기화하기 위한 생성자
    public MemberDto(String userid, String password, String rePassword, String username, String zipcode, 
            String addr1, String addr2, String phone1, String phone2, String phone3, String tel1, 
            String tel2, String tel3, String email, String year, String month, String day) {
        super();
        this.userid = userid;     		// 사용자 아이디 초기화
        this.password = password; 		// 사용자 비밀번호 초기화
        this.rePassword = rePassword; 	// 비밀번호 확인용 초기화
        this.username = username;   	// 사용자 이름 초기화
        this.zipcode = zipcode;  		// 우편번호 초기화
        this.addr1 = addr1;      		// 주소 1 초기화
        this.addr2 = addr2;      		// 주소 2 초기화
        this.phone1 = phone1;   		// 전화번호 앞자리 초기화
        this.phone2 = phone2;   		// 전화번호 중간자리 초기화
        this.phone3 = phone3;   	  	// 전화번호 뒷자리 초기화
        this.tel1 = tel1;        		// 집전화 앞자리 초기화
        this.tel2 = tel2;       		// 집전화 중간자리 초기화
        this.tel3 = tel3;        		// 집전화 뒷자리 초기화
        this.email = email;     		// 이메일 주소 초기화
        this.year = year;       		// 생년 초기화
        this.month = month;    		    // 생월 초기화
        this.day = day;         		// 생일 초기화
    }

    // Getter and Setter 메서드들, 각 멤버 변수를 가져오거나 설정하는 메서드들

    // 사용자 아이디 반환
    public String getUserid() {
        return userid;
    }

    // 사용자 아이디 설정
    public void setUserid(String userid) {
        this.userid = userid;
    }

    // 비밀번호 반환
    public String getPassword() {
        return password;
    }

    // 비밀번호 설정
    public void setPassword(String password) {
        this.password = password;
    }

    // 비밀번호 확인용 변수 반환
    public String getRePassword() {
        return rePassword;
    }

    // 비밀번호 확인용 변수 설정
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    // 사용자 이름 반환
    public String getUsername() {
        return username;
    }

    // 사용자 이름 설정
    public void setUsername(String username) {
        this.username = username;
    }

    // 우편번호 반환
    public String getZipcode() {
        return zipcode;
    }

    // 우편번호 설정
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // 주소 1 반환
    public String getAddr1() {
        return addr1;
    }

    // 주소 1 설정
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    // 주소 2 반환
    public String getAddr2() {
        return addr2;
    }

    // 주소 2 설정
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    // 전화번호 앞자리 반환
    public String getPhone1() {
        return phone1;
    }

    // 전화번호 앞자리 설정
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    // 전화번호 중간자리 반환
    public String getPhone2() {
        return phone2;
    }

    // 전화번호 중간자리 설정
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    // 전화번호 뒷자리 반환
    public String getPhone3() {
        return phone3;
    }

    // 전화번호 뒷자리 설정
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    // 집전화 앞자리 반환
    public String getTel1() {
        return tel1;
    }

    // 집전화 앞자리 설정
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    // 집전화 중간자리 반환
    public String getTel2() {
        return tel2;
    }

    // 집전화 중간자리 설정
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    // 집전화 뒷자리 반환
    public String getTel3() {
        return tel3;
    }

    // 집전화 뒷자리 설정
    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    // 이메일 반환
    public String getEmail() {
        return email;
    }

    // 이메일 설정
    public void setEmail(String email) {
        this.email = email;
    }

    // 생년 반환
    public String getYear() {
        return year;
    }

    // 생년 설정
    public void setYear(String year) {
        this.year = year;
    }

    // 생월 반환
    public String getMonth() {
        return month;
    }

    // 생월 설정
    public void setMonth(String month) {
        this.month = month;
    }

    // 생일 반환
    public String getDay() {
        return day;
    }

    // 생일 설정
    public void setDay(String day) {
        this.day = day;
    }

    // 객체를 문자열로 표현하는 메서드 (주로 디버깅이나 로그 출력 시 사용)
    @Override
    public String toString() {
        return "MemberDto [userid=" + userid + ", password=" + password + ", rePassword=" + rePassword + ", username=" 
            + username + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1
            + ", phone2=" + phone2 + ", phone3=" + phone3 + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3
            + ", email=" + email + ", year=" + year + ", month=" + month + ", day=" + day + "]";
    }
}
