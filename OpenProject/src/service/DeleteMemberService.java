package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.MemberInfo;

// 2018.10.01 회원정보 삭제 서비스패턴 구현
public class DeleteMemberService {
	private static DeleteMemberService instance = new DeleteMemberService();
	
	public static DeleteMemberService getInstance() {
		return instance;
	}
	
	private DeleteMemberService() {
	}
	
	public void deleteMember(String userId) throws ServiceException, MemberNotFoundException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			MemberDao memberDao = MemberDao.getInstance();
			MemberInfo memberInfo = memberDao.select(conn, userId);
			
			if(memberInfo == null) {
				throw new MemberNotFoundException(userId + "님은 이미 탈퇴한 회원입니다.");
			}
			memberDao.delete(conn, userId);
			conn.commit();
		}catch(SQLException se) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("탈퇴 처리 중 에러가 발생했습니다." + se.getMessage(), se);
		}catch(MemberNotFoundException me) {
			JdbcUtil.rollback(conn);
			throw me;
		}finally {
			if(conn != null) {
				try {
					conn.setAutoCommit(false);
				}catch(SQLException se) {
				}
				JdbcUtil.close(conn);
			}
		}
	}
}
