/*package com.bitcamp.openprac2.jdbc;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.openprac2.model.MemberInfo;

public class MemberRowMapper implements RowMapper<MemberInfo> {
	@Override
	public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberInfo memberInfo = new MemberInfo(rs.getLong("idx"),
				rs.getString("userId"),
	rs.getString("password"),
	rs.getString("username"),
	rs.getString("userPhoto"),
	rs.getDate("regdate"));
	memberInfo.setUserId(rs.getString("userId"));
	return memberInfo;
	}
}*/
