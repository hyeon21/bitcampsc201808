package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.MemberInfo;

public class EditMemberService {
	MemberDao memberDao = MemberDao.getInstance();

	private static EditMemberService editService = new EditMemberService();

	public static EditMemberService getInstance() {
		return editService;
	}

	private EditMemberService() {
	}

	public void editMember(MemberInfo memberInfo) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			memberDao.update(conn, memberInfo);
		} catch (SQLException se) {
			throw new ServiceException("수정 중 에러발생");
		} finally {
	
				JdbcUtil.close(conn);
		}
	}

}
