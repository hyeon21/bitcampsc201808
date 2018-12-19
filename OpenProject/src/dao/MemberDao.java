package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	// 2018.10.08 회원리스트 불러오기 DAO 패턴 구현
	public List<MemberInfo> selectAll(Connection conn){
		List<MemberInfo> members = new ArrayList<>();
		
		String sql = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				members.add(this.mekeMemberInfoFromResultSet(rs));
			}
			
		} catch(SQLException se){
			System.out.println("DB연결 실패");
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		return members;
	}
	
	// 2018.10.11 회원정보수정 DAO 패턴 구현
	public void update(Connection conn, MemberInfo memberInfo) throws SQLException{
		String sql = "update Member set password=?, username=?, userphoto=? where userid=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getPassword());
			pstmt.setString(2, memberInfo.getUserName());
			pstmt.setString(3, memberInfo.getUserPhoto());
			pstmt.setString(4, memberInfo.getUserId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException se){
			System.out.println("회원정보 수정 실패. DB연결을 확인하세요.");
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
	}
	
}
