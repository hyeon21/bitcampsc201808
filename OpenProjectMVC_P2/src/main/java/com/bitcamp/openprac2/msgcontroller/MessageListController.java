
package com.bitcamp.openprac2.msgcontroller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.model.CountLikeMessageDTO;
import com.bitcamp.openprac2.model.MessageListView;
import com.bitcamp.openprac2.msgservice.GetLikeCountAllService;
import com.bitcamp.openprac2.msgservice.MessageListService;
import com.bitcamp.openprac2.service.ServiceException;

@Controller
public class MessageListController {

	@Autowired
	private MessageListService service;
	
/*	@Autowired
	private CountLikeMessageSelectAllService likeService;
	*/
	@Autowired
	private GetLikeCountAllService getLikeCntService;
	
	@RequestMapping("/book/bookListAjax") // /guest/list?page=1 이런식으로...
	public ModelAndView getMessageList(HttpServletRequest request) throws ServiceException, SQLException {
	
		System.out.println("메세지리스트컨트롤러-북리스트아작경로-겟메세지리스트 메서드 진입");
		
	List<CountLikeMessageDTO> likeList = new ArrayList<CountLikeMessageDTO>(); 
			
	//likeList = likeService.getCountLikeMessageAll();
	
	// 181029 test
	likeList = getLikeCntService.getLikeCountAll();
	
	String pageNumberStr = request.getParameter("page");
	
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}

	MessageListView viewData = service.getMessageList(pageNumber);
	
	ModelAndView modelAndView = new ModelAndView();
	
	// 뷰 이름 설정
	modelAndView.setViewName("book/bookListAjax");
	// 뷰에 결과데이터를 전달(공유)하자
	modelAndView.addObject("viewData", viewData);
	modelAndView.addObject("likeList", likeList);
	
	System.out.println("메세지리스트컨트롤러 - likeList : " + likeList);
	
	return modelAndView;
	}
	
	/*@RequestMapping("/guestbook/list")
	public ModelAndView getList(@RequestParam(value="page", defaultValue="1") int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("guestbook/list");
		
		MessageListView listView = service.getMessageList(pageNumber);
		
		modelAndView.addObject("listView", listView);
		
		return modelAndView;
	} */
	
}
