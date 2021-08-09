package com.techm.design.bean;

public class RequestBean {

	private String tenantId;
	private Integer count = 0;
	private Long requestTimestamp;
	
	public RequestBean(String tenantId, Integer count, Long requestTimestamp) {
		super();
		this.tenantId = tenantId;
		this.count = count;
		this.requestTimestamp = requestTimestamp;
	}
	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the requestTimestamp
	 */
	public Long getRequestTimestamp() {
		return requestTimestamp;
	}
	/**
	 * @param requestTimestamp the requestTimestamp to set
	 */
	public void setRequestTimestamp(Long requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	
}
