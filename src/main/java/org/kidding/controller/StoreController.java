package org.kidding.controller;

import org.kidding.domain.StoreVO;
import org.kidding.service.StoreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController	//spring 4버전에 추가된 것. 
@RequestMapping("/store/*")
@Log4j
@CrossOrigin(origins="*")
@AllArgsConstructor
public class StoreController {

	
	private StoreService service;
	
	@GetMapping("/{idx}")	//꺽쇠를 이용하면 파라미터로 수집 가능
	public StoreVO get(@PathVariable("idx") int idx) {
		
		return service.get(idx);
	}
	
	@DeleteMapping("/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		
		log.info("remove............" + idx);
		service.remove(idx);
		
		return "success";
	}
	
	@PostMapping("/new")		// /store/new 가 경로가 된다.
	public String add(@RequestBody StoreVO vo) {
		//RequestBody는 json 데이터를 java의 Object로 변환해주는 작업을 수행함. 
		
		log.info("======================================");
		log.info(vo);
		
		return "success";
	}
	
	@GetMapping("/sample")
	public StoreVO get() {
		
		StoreVO vo = new StoreVO();
		vo.setSno(1);
		vo.setSname("중앙해장");
		vo.setLat(37.123);
		vo.setLng(123.4567);
		
		return vo;
		
	}
}
