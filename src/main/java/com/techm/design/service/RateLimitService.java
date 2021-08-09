package com.techm.design.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.techm.design.bean.RequestBean;
import com.techm.design.bean.ResponseBean;

@Component
public class RateLimitService implements IService  {

	static Map<String, RequestBean> requestMap = new HashMap<String, RequestBean>();
	
	// Configured time duration
	@Value("${app_properties_duration}")
	public int duration;

	// Configured no of api calls allowed within configured time duration
	@Value("${app_properties_threshold}")
	public int limit;

	/**
	 * Resolves the request based on configured payload.
	 * @param: String id
	 * @param: Long time
	 */
	@Override
	public ResponseBean resolveRequestPayload(String id, Long time) {		
		ResponseBean response = new ResponseBean();
		if(!requestMap.containsKey(id)) {
			requestMap.put(id, new RequestBean(id, 1, time));
			response.setStatus(HttpStatus.OK);
			response.setValidRequest(true);
			return response;
		}
		// Process for already existing req in the context
		RequestBean req = requestMap.get(id);
		if(req.getCount() < limit) {
			req.setCount(req.getCount()+1);
			response.setStatus(HttpStatus.OK);
			response.setValidRequest(true);
			return response;
		} 
	
		// Check for duration if limit is crossed.
		Long diff = time - req.getRequestTimestamp();
		if( diff > duration) {
			req.setCount(1);
			req.setRequestTimestamp(time);
			response.setStatus(HttpStatus.OK);
			response.setValidRequest(true);
			return response;
		}
		
		// Return false as request is more than the configured payload
		response.setStatus(HttpStatus.TOO_MANY_REQUESTS);
		response.setValidRequest(false);
		Long retry = TimeUnit.MILLISECONDS.toSeconds(duration-diff);
		response.setRetryAfter(retry.toString());
		return response;
	}

}
