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

import com.bitcamp.openprac2.model.Message;

public class JDBCTemplateMessageDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	 스프링에서 자동으로 싱글톤패턴으로 객체를 생성해주기 때문에 필요없다.
	/*
	 * private static MessageDao dao = new MessageDao();
	 * 
	 * public static MessageDao getInstance() { return dao; }
	 * 
	 * private MessageDao() { }
	 */

	public int insert(Message message) throws SQLException {

		int resultCnt = 0;

			String message_insert_sql="insert into message_board "
					+ "(userid, message)"
					+ " values (?, ?)";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();

			resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					
					PreparedStatement pstmt = con.prepareStatement(message_insert_sql, new String[] {"messageid"});
					pstmt.setString(1, message.getUserId());
					pstmt.setString(2, message.getMessage());
					
					return pstmt;
				}
			}, keyHolder);
			
			Number keyValue = keyHolder.getKey();
			
			message.setMessageId(keyValue.intValue());

			return resultCnt;

	}

	public Message select(int messageId) throws SQLException {

		String message_select_sql = "select * from message_board where messageid = ?";
		 
		List<Message> result = 
				jdbcTemplate.query(message_select_sql, 
									new RowMapper<Message>() {

				@Override
				public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					Message message = new Message();
					
					message.setMessageId(rs.getInt("messageid"));
					message.setUserId(rs.getString("userid"));
					message.setMessage(rs.getString("message"));
					
					return message;
				}
		}, messageId);
		return result.isEmpty() ? null : result.get(0);
	}

	
	public int selectCount() throws SQLException {
		
		String count_sql = "select count(*) from message_board";
		
		int count = jdbcTemplate.queryForObject(count_sql, Integer.class);
		
		return count;
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setMessageId(rs.getInt("messageid"));
		message.setUserId(rs.getString("userid"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {
		
		String message_list_sql = "select * from message_board order by messageid desc limit ?, ?";
		
		List<Message> messageList = jdbcTemplate.query(message_list_sql,
														new RowMapper<Message>() {
					@Override
					public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Message message = new Message();
						
						message.setMessageId(rs.getInt("messageid"));
						message.setUserId(rs.getString("userid"));
						message.setMessage(rs.getString("message"));
						
						return message;
					}
		}, firstRow, endRow);
		return messageList.isEmpty() ? null : messageList;
	}

	public void delete(int messageId) throws SQLException {
	
		String message_delete_sql = "delete from message_board where messageid = ?";

		jdbcTemplate.update(message_delete_sql, messageId);
	
	}
}
