package com.techm.design.bean;

import org.springframework.http.HttpStatus;

public class ResponseBean {

	boolean isValidRequest = false;
	HttpStatus status;
	String retryAfter;
	
	/**
	 * @return the isValidRequest
	 */
	public boolean isValidRequest() {
		return isValidRequest;
	}
	/**
	 * @param isValidRequest the isValidRequest to set
	 */
	public void setValidRequest(boolean isValidRequest) {
		this.isValidRequest = isValidRequest;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the retryAfter
	 */
	public String getRetryAfter() {
		return retryAfter;
	}
	/**
	 * @param retryAfter the retryAfter to set
	 */
	public void setRetryAfter(String retryAfter) {
		this.retryAfter = retryAfter;
	}
	
}
