package com.bitcamp.openprac2.msgservice;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMessageDao;
import com.bitcamp.openprac2.model.Message;
import com.bitcamp.openprac2.model.MessageListView;

public class MessageListService {

	// 빈 객체 자동등록하기(의존주입)
	@Autowired
	JDBCTemplateMessageDao messageDao;

	// 한 페이지에 보여줄 메세지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 10;

	@Transactional
	public MessageListView getMessageList(int pageNumber) throws SQLException {

		int currentPageNumber = pageNumber;

		// 전체 메시지 구하기
		int messageTotalCount = messageDao.selectCount();
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		if (messageTotalCount > 0) {
			firstRow = (pageNumber -1) * MESSAGE_COUNT_PER_PAGE;
			endRow = MESSAGE_COUNT_PER_PAGE;
			messageList = messageDao.selectList(firstRow, endRow);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow,
				endRow);
	}

}
