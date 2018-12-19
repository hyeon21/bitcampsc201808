package com.bitcamp.mvc1113;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") Integer id, Model model) {
		// 리소스 반환
		model.addAttribute("article", new Article(id));
		return "article/read";
	}

	@RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id, Model model) {
		// 리소스 삭제
		model.addAttribute("article", new Article(id));
		return "article/delete";
	}

	@RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") Integer id, Model model, Article article) {
		// id값의 리소스 수정 - 아티클 객체도 원래는 받아야겠죠?????????
		model.addAttribute("article", new Article(id));
		return "article/modify";
	}

	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public String write(Model model) {
		// 데이터를 받아서 리소스를 등록 - insert 
		model.addAttribute("article", new Article(25));
		return "article/write";
	}

	@RequestMapping("/form")
	public String form(Model model) {
		return "article/form";
	}

}
