package com.guoshuai.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.guoshuai.domain.User;

@WebService
public interface UserService {

	@WebMethod
	String getName(@WebParam(name = "userId") String userId);

	@WebMethod
	User getUser(@WebParam(name = "userId") String userId);

}
