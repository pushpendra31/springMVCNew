package com.myproj.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproj.ConfigJava.ServiceLocator;
import com.myproj.DAO.LoginRegisterDAO;
import com.myproj.DTOs.LoginRegisterDTO;
import com.myproj.DTOs.ProductDto;
import com.myproj.DTOs.SubcatDto;
import com.myproj.DaoImpl.LoginRegisterDaoImpl;
import com.myproj.service.LoginRegisterService;
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

	@Autowired
	LoginRegisterDAO dao;  // = (LoginRegisterDAO) ServiceLocator.getXMLBean("LoginRegisterDaoIpl");



	@Override
	public LoginRegisterDTO login(LoginRegisterDTO dto) throws Exception {
	LoginRegisterDTO logindto = null;
	logindto=dao.login(dto);
	
		if(logindto!=null && dto.getUsername().equalsIgnoreCase(logindto.getUsername())) {
			logindto.setFlag(true);
		}
		return logindto;
	}

	@Override
	public boolean adduser(LoginRegisterDTO dto) throws Exception {
		boolean flag=dao.adduser(dto);
		return flag;
	}

	@Override
	public LoginRegisterDTO CheckExistingUser(LoginRegisterDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return dao.CheckExistingUser(dto);
	}

	@Override
	public List<LoginRegisterDTO> showRegistereduser(LoginRegisterDTO dto) throws Exception {
		
		return dao.showRegistereduser(dto);
	}

	@Override
	public boolean adduserHB(LoginRegisterDTO dto) {
		boolean flag=dao.adduserHB(dto);
		return flag;
	}

	@Override
	public List<LoginRegisterDTO> showRegistereduserHB(LoginRegisterDTO dto) {
		return dao.showRegistereduserHB(dto);
	}



	@Override
	public ProductDto getHibernetdata() {
		return dao.getHibernetdata();
	}

	@Override
	public List<LoginRegisterDTO> updateuserDtls(LoginRegisterDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateuserDtls(dto);
	}

}
