package com.winter.app.aop;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Transfer {
	//point-cut
	public void useBus(String number) throws Exception {
		log.info("버스 타기");
	}
	//point-cut
	public void useSubway(String number) throws Exception{
		
		log.info("지하철 이용");
	}
	
	
	
	
	
}
