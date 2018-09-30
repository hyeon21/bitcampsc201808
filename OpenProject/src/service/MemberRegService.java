package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.MemberInfo;

public class MemberRegService {
	MemberDao memberDao = MemberDao.getInstance();
	
	private static MemberRegService service = new MemberRegService();
	
	public static MemberRegService getInstance() {
		return service;
	}
	
	private MemberRegService() {
	}
	
	public void reg(MemberInfo memberInfo) throws ServiceException{
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			memberDao.insert(conn, memberInfo);
		}catch(SQLException se) {
			throw new ServiceException("회원가입 실패: " + se.getMessage(), se);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
