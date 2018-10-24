package com.bitcamp.openprac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.openprac2.model.MemberInfo;

public class MybatisMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String mapperPath = "com.bitcamp.openprac2.mapper.mybatis.MemberMapper";
	
	// 2018.09.30 회원가입 DAO패턴 구현
	// 2018.10.24 mybatis템플릿 적용
	public int insert(MemberInfo memberInfo) throws SQLException {

		return sqlSessionTemplate.update(mapperPath+".insertMember", memberInfo);
	}

	// 2018.10.22 회원정보 선택 new
	// 2018.10.24 mybatis템플릿 적용
	public MemberInfo select(String userId) {
		
		return sqlSessionTemplate.selectOne(mapperPath+".selectById", userId);
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

	// 2018.10.01 회원정보 삭제 DAO패턴 구현
	/*public void delete(String userId) throws SQLException {
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
	}*/
}
