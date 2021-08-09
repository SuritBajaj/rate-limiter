package com.techm.design.service;

import com.techm.design.bean.ResponseBean;

public interface IService {

	public ResponseBean resolveRequestPayload(String id, Long time);
}
