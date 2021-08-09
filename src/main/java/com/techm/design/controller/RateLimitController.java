package com.techm.design.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.design.bean.ResponseBean;
import com.techm.design.service.IService;

@SpringBootApplication
@RestController
public class RateLimitController {

	@Autowired
	IService rateLimitService;

	/**
	 * Rate limited api to get tenant info. 
	 * Response is based on configured threshold & duration.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/tenant/{id}")
	public ResponseEntity<String> getTenant(@PathVariable String id) {
		String responseBody = "";
		ResponseBean rs = rateLimitService.resolveRequestPayload(id, System.currentTimeMillis());
		if (rs.isValidRequest()) {
			responseBody = "Request allowed for the tenant:" + id;
			return new ResponseEntity<String>(responseBody, rs.getStatus());
		} else {
			responseBody = "Too many requests for the Tenant:" + id + "\t Retry after:" + rs.getRetryAfter() + "(s)";
			return new ResponseEntity<String>(responseBody, rs.getStatus());
		}
	}
}
