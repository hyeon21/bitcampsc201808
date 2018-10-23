package com.bitcamp.openprac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.openprac2.model.MemberInfo;

public class JDBCTemplateMemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 2018.10.23 Mysql로 변경

	// 2018.09.30 회원가입 DAO패턴 구현
	// 2018.10.23 jdbcTemplate 적용
	public int insert(MemberInfo memberInfo) throws SQLException {

		int resultCnt = 0;

		String insertSql = "insert into" + " member(USERID, PASSWORD, "
				+ "USERNAME, USERPHOTO, REGDATE)"
				+ " values(?,?,?,?,sysdate())";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				
				PreparedStatement pstmt = con.prepareStatement(insertSql, new String[] {"idx"});
				pstmt.setString(1, memberInfo.getUserId());
				pstmt.setString(2, memberInfo.getPassword());
				pstmt.setString(3, memberInfo.getUserName());
				pstmt.setString(4, memberInfo.getUserPhoto());
				
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		
		memberInfo.setIdx(keyValue.intValue()); // longValue 대신 intValue... 데이터가 많지않아서
		
		// jdbcTemplate.update() == executeQuery()
		/*resultCnt = jdbcTemplate.update(insertSql, 
										memberInfo.getUserId(), 
										memberInfo.getPassword(),
										memberInfo.getUserName(), 
										memberInfo.getUserPhoto());*/

		// 1. PreparedStatement pstmt = null;

		/*
		 * String sql = "insert into" +
		 * " member(IDX, USERID, PASSWORD, USERNAME, USERPHOTO, REGDATE)" +
		 * " values(IDX.NEXTVAL,?,?,?,?,sysdate)";
		 */

		// 2. try {
		// 3. pstmt = conn.prepareStatement(sql);
		/*
		 * pstmt.setString(1, memberInfo.getUserId()); pstmt.setString(2,
		 * memberInfo.getPassword()); pstmt.setString(3, memberInfo.getUserName());
		 * pstmt.setString(4, memberInfo.getUserPhoto());
		 * 
		 * resultCnt = pstmt.executeUpdate();
		 */
		// 4. } finally {
		// JdbcUtil.close(pstmt);
		// }

		return resultCnt;
	}

	// 2018.10.22 회원정보 선택 new
	// 2018.10.23 idx int타입으로 변경
	public MemberInfo select(String userId) {
		String selectSql = "select * from member where userid = ?";
				 
		List<MemberInfo> result = 
				jdbcTemplate.query(selectSql, 
									new RowMapper<MemberInfo>() {

				@Override
				public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					MemberInfo memberInfo = new MemberInfo();
					
					memberInfo.setIdx(rs.getInt("idx"));
					memberInfo.setUserId(rs.getString("userid"));
					memberInfo.setPassword(rs.getString("password"));
					memberInfo.setUserName(rs.getString("username"));
					memberInfo.setUserPhoto(rs.getString("userphoto"));
					memberInfo.setRegdate(rs.getDate("regdate"));
					
					return memberInfo;
				}
		}, userId);
		return result.isEmpty() ? null : result.get(0);
	}

	/*
	 * // 2018.10.01 회원정보 선택 public MemberInfo select(Connection conn, String
	 * userId) throws SQLException{ PreparedStatement pstmt = null; ResultSet rs =
	 * null;
	 * 
	 * try { String sql = "select * from member where userid = ?"; pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, userId); rs =
	 * pstmt.executeQuery(); if(rs.next()) { return mekeMemberInfoFromResultSet(rs);
	 * }else { return null; } }finally { JdbcUtil.close(rs); JdbcUtil.close(pstmt);
	 * } }
	 */

	private MemberInfo mekeMemberInfoFromResultSet(ResultSet rs) throws SQLException {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setIdx(rs.getInt("idx"));
		memberInfo.setUserId(rs.getString("userid"));
		memberInfo.setPassword(rs.getString("password"));
		memberInfo.setUserName(rs.getString("username"));
		memberInfo.setUserPhoto(rs.getString("userphoto"));
		memberInfo.setRegdate(rs.getDate("regdate"));

		return memberInfo;
	}

	// 2018.10.01 회원정보 삭제 DAO패턴 구현
	public void delete(String userId) throws SQLException {
		String deleteSql = "delete from member where userid=?";

		jdbcTemplate.update(deleteSql, userId);

	}

	// 2018.10.08 회원리스트 불러오기 DAO 패턴 구현
	// 2018.10.23 jdbcTemplate 적용
	public List<MemberInfo> selectAll() {

		String selectAllSql = "select * from member";
		 
		List<MemberInfo> members = 
				jdbcTemplate.query(selectAllSql, 
									new RowMapper<MemberInfo>() {

				@Override
				public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					MemberInfo memberInfo = new MemberInfo();
					
					memberInfo.setIdx(rs.getInt("idx"));
					memberInfo.setUserId(rs.getString("userid"));
					memberInfo.setPassword(rs.getString("password"));
					memberInfo.setUserName(rs.getString("username"));
					memberInfo.setUserPhoto(rs.getString("userphoto"));
					memberInfo.setRegdate(rs.getDate("regdate"));
					
					return memberInfo;
				}
		});
		
		return members.isEmpty() ? null : members;
	}

	// 2018.10.11 회원정보수정 DAO 패턴 구현
	// 2018.10.23 jdbcTemplate 적용
	public void update(MemberInfo memberInfo) throws SQLException {

		String updateSql = "update Member set password=?, username=?,"
				+ " userphoto=? where userid=?";

		jdbcTemplate.update(updateSql,
							memberInfo.getPassword(),
							memberInfo.getUserName(), 
							memberInfo.getUserPhoto(), 
							memberInfo.getUserId());
	}
}
