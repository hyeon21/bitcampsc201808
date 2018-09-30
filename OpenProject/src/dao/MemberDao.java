package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import model.MemberInfo;

public class MemberDao {

	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	private MemberDao() {}
	
	public int insert(Connection conn, MemberInfo memberInfo) throws SQLException{
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "insert into Member(IDX, USERID, PASSWORD, USERNAME, USERPHOTO, REGDATE) "
				+ "values(IDX.NEXTVAL,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getUserId());
			pstmt.setString(2, memberInfo.getPassword());
			pstmt.setString(3, memberInfo.getUserName());
			pstmt.setString(4, memberInfo.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate();
			
			return resultCnt;
			
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}
