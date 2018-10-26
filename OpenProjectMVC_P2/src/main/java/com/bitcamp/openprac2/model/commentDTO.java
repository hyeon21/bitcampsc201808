package com.bitcamp.openprac2.model;

import java.util.Date;

public class commentDTO {

	private int commentNo; // 덧글번호
	private int messageId; // 원 게시글 번호
	private int UserNo; // 덧글 작성자 번호
	private String commentCont; // 덧글 내용
	private Date CommentDate; // 덧글 작성시간
	private int CommReportCnt; // 신고

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserNo() {
		return UserNo;
	}

	public void setUserNo(int userNo) {
		UserNo = userNo;
	}

	public String getCommentCont() {
		return commentCont;
	}

	public void setCommentCont(String commentCont) {
		this.commentCont = commentCont;
	}

	public Date getCommentDate() {
		return CommentDate;
	}

	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}

	public int getCommReportCnt() {
		return CommReportCnt;
	}

	public void setCommReportCnt(int commReportCnt) {
		CommReportCnt = commReportCnt;
	}

	@Override
	public String toString() {
		return "comment [commentNo=" + commentNo + ", messageId=" + messageId + ", UserNo=" + UserNo + ", commentCont="
				+ commentCont + ", CommentDate=" + CommentDate + ", CommReportCnt=" + CommReportCnt + "]";
	}

}
