package org.kidding.controller;

import org.kidding.domain.ReplyVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply/*")
@Log4j
public class ReplyController {

	
	@PostMapping("/new")
	public void register(@RequestBody ReplyVO vo) {
		//json으로 받을 땐 RequestBody
		log.info("new : " + vo);
		
		
	}
	
}
