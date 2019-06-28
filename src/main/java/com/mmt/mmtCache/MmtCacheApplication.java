package com.mmt.mmtCache;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class MmtCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmtCacheApplication.class, args);
	}


	@Bean
	@Qualifier("getMap")
	Map getMap(){
		return new ConcurrentHashMap<String,String>();
	}
}
