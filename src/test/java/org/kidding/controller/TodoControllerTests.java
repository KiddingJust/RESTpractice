package org.kidding.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kidding.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class TodoControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;

	private MockMvc mockMvc; //가짜 mvc를 만들어내는 것. 우린 서버 없이 할거거든
	
	@Before		// 모든 테스트가 실행되기 전에 실행되는 것?
	public void setUp() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void createTest()throws Exception {
		
		//가짜 reply
		ReplyVO vo = new ReplyVO();
		vo.setBno(123);
		vo.setReply("댓글 좋아Dragon...");
		vo.setReplyer("replyer");
		
		String str = new Gson().toJson(vo);
		
		System.out.println(str);
		
		//서버 띄우지 않아도 ReplyController 동작하게끔!!! 
		mockMvc.perform(
				post("/reply/new")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(str)
				);
		
	}
	
}

