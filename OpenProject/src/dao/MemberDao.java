package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import model.MemberInfo;

public class MemberDao {

	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	private MemberDao() {}
	
	// 2018.09.30 회원가입 DAO패턴 구현
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
	
	
	// 2018.10.01 회원정보 선택
	public MemberInfo select(Connection conn, String userId) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return mekeMemberInfoFromResultSet(rs);
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	private MemberInfo mekeMemberInfoFromResultSet(ResultSet rs) throws SQLException{
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setUserId(rs.getString("userid"));
		memberInfo.setPassword(rs.getString("password"));
		memberInfo.setUserName(rs.getString("username"));
		memberInfo.setUserPhoto(rs.getString("userphoto"));
		
		return memberInfo;
	}

	// 2018.10.01 회원정보 삭제 DAO패턴 구현
	public int delete(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "delete from member where userid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
}
