package com.myproj.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myproj.DTOs.LoginRegisterDTO;
@Component
public interface LoginRegisterService {
	public LoginRegisterDTO login(LoginRegisterDTO dto)throws  Exception;
	public boolean adduser(LoginRegisterDTO dto)throws  Exception;
	public LoginRegisterDTO CheckExistingUser(LoginRegisterDTO dto) throws SQLException;
	public List<LoginRegisterDTO> showRegistereduser(LoginRegisterDTO dto)throws  Exception;

}
