package com.myproj.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myproj.DTOs.LoginRegisterDTO;
@Component
public interface LoginRegisterDAO {
	
	public LoginRegisterDTO login(LoginRegisterDTO dto) throws SQLException;
	public boolean adduser(LoginRegisterDTO dto)throws Exception;
	LoginRegisterDTO CheckExistingUser(LoginRegisterDTO dto) throws SQLException;
	public List<LoginRegisterDTO> showRegistereduser(LoginRegisterDTO dto)throws Exception;
	public boolean adduserHB(LoginRegisterDTO dto);

}
