package spring;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		
		// 생성
		memberDao = new MemberDao();
		//		 생성, 						주입
		regSvc = new MemberRegisterService();
		pwdSvc = new ChangePasswordService();
	}

	// 객체 반환
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
