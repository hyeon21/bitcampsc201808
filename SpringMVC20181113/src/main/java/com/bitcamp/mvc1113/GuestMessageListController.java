package com.bitcamp.mvc1113;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageListController {

	@RequestMapping(value = "/guestmessage/list") // .xml 을 굳이 안써줘도 ㅇㅋ
	@ResponseBody
	public GuestMessageList listXml() {
		return getMessageList();
	}

	private GuestMessageList getMessageList() {
		List<GuestMessage> messages = Arrays.asList(new GuestMessage(1, "메시지1", new Date()),
				new GuestMessage(2, "메시지2", new Date()));
		return new GuestMessageList(messages);
	}

	@RequestMapping(value = "/guestmessages/list.json", produces="application/json")
	@ResponseBody
	public GuestMessageList2 listJson() {
		return getMessageList2();
	}

	private GuestMessageList2 getMessageList2() {
		List<GuestMessage2> messages = Arrays.asList(
				new GuestMessage2(1, "메시지1", new Date()),
				new GuestMessage2(2, "메시지2", new Date()));
		return new GuestMessageList2(messages);
	}

}
