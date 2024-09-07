package com.myproj.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproj.ConfigJava.DBConUtil;
import com.myproj.ConfigJava.HibernateSession;
import com.myproj.DAO.LoginRegisterDAO;
import com.myproj.DTOs.LoginRegisterDTO;

import com.zaxxer.hikari.HikariDataSource;

@Repository
public class LoginRegisterDaoImpl implements LoginRegisterDAO {

	@Autowired
	DBConUtil dbutil;
	@Autowired
	HibernateSession HbSession;
	// @Autowired isnot working so created object below
	JdbcTemplate templt;

	PreparedStatement st;


		
	@Override
	public LoginRegisterDTO login(LoginRegisterDTO dto) throws SQLException {
		LoginRegisterDTO dtoReturn = new LoginRegisterDTO();
		// simple JDBC
		HikariDataSource ds = dbutil.geDataSource();
		try (Connection Con = ds.getConnection()) {
			st = Con.prepareStatement("select email,password,role from  jspproject.persons  where email=? limit 1");
			st.setString(1, dto.getUsername());
			ResultSet result = st.executeQuery();
			result.next();
			if (result.getRow() != 0 && result.getString("email") != null) {
				dtoReturn.setUsername(result.getString(1));
				dtoReturn.setPassword(result.getString(2));
				dtoReturn.setRole(result.getString(3));

			}
		} catch (SQLException e) {
			throw e;
		}

		return dtoReturn;
	}

	@Override
	public LoginRegisterDTO CheckExistingUser(LoginRegisterDTO dto) throws SQLException {
		LoginRegisterDTO dtoReturn = new LoginRegisterDTO();
		// spring JDBC
		templt = new JdbcTemplate();

		HikariDataSource ds = dbutil.geDataSource();
		templt.setDataSource(ds);

		String query = "select email,password,role from  jspproject.persons  where email=? limit 1";
		List<LoginRegisterDTO> li = templt.query(query, new Object[] { dto.getEmail() },
				new RowMapper<LoginRegisterDTO>() {

					@Override
					public LoginRegisterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						LoginRegisterDTO dtoReturn = new LoginRegisterDTO();
						if (rs != null) {
							dtoReturn.setUsername(rs.getString(1));
						}
						return dtoReturn;
					}
				});
		/*
		 * LoginRegisterDTO queryForObject = templt.queryForObject(query,new
		 * RowMapper<LoginRegisterDTO>(){
		 * 
		 * @Override public LoginRegisterDTO mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { LoginRegisterDTO dtoReturn = new LoginRegisterDTO();
		 * if(rs!=null) { dtoReturn.setUsername(rs.getString(1));} return dtoReturn; }
		 * }, dto.getEmail());
		 */
		if (li.isEmpty()) {
			return null;
		} else {
			return li.get(0);
		}

	}

	@Override
	public boolean adduser(LoginRegisterDTO dto) throws Exception {
		long role = 1l;
		boolean flag = false;
		templt = new JdbcTemplate();

		HikariDataSource ds = dbutil.geDataSource();
		templt.setDataSource(ds);
		LocalDateTime now = LocalDateTime.now();
		int id = 0;
		DateTimeFormatter todaydate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String str = now.format(todaydate);
		String sb = "INSERT INTO `jspproject`.`persons`(`PersonID`,`LastName`,`FirstName`,`Address`,`City`,`email`,`password`,`gender`,`contact_no`,`CRT_DT`,`role`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		id = templt.update(sb, new Object[] { 0, dto.getLastName(), dto.getFname(), dto.getAddress(), dto.getCity(),
				dto.getEmail(), dto.getPassword(), dto.getGender(), dto.getContact(), str, role });

		if (id != 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<LoginRegisterDTO> showRegistereduser(LoginRegisterDTO dto) throws Exception {
		List<LoginRegisterDTO> dtoreturn = new ArrayList<LoginRegisterDTO>();
		boolean flag = false;
		templt = new JdbcTemplate();
		Object obj[] = new Object[1];
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(obj);

		HikariDataSource ds = dbutil.geDataSource();
		String sb = new String();
		sb = "select personID,FirstName,LastName,gender,Address,City,email,contact_no,role from  jspproject.persons";
		if (dto.getFname() != null) {
			sb = sb.concat("  where FirstName=?");
			obj[0] = dto.getFname();
		}
		if (dto.getContact() != null) {
			sb = sb.concat("and contact_no=?");
			obj[1] = dto.getFname();
		}

		templt.setDataSource(ds);
		List<Map<String, Object>> list = templt.queryForList(sb, obj);
		for (Map<String, Object> map : list) {
			LoginRegisterDTO Singledto = new LoginRegisterDTO();
			Singledto.setPersonid((int) map.get("personID"));
			Singledto.setFname(map.get("FirstName") != null ? map.get("FirstName").toString() : "");
			Singledto.setLastName(map.get("LastName") != null ? map.get("LastName").toString() : "");
			Singledto.setGender(map.get("gender") != null ? map.get("gender").toString() : "");
			Singledto.setAddress(map.get("Address") != null ? map.get("Address").toString() : "");
			Singledto.setCity(map.get("City") != null ? map.get("City").toString() : "");
			Singledto.setEmail(map.get("email") != null ? map.get("email").toString() : "");
			Singledto.setContact(map.get("contact_no") != null ? (Long) map.get("contact_no") : 0l);

			dtoreturn.add(Singledto);
		}
		/*
		 * templt.query(sb, new Object[] { dto.getFname()}, new
		 * RowMapper<LoginRegisterDTO>(){
		 * 
		 * @Override public LoginRegisterDTO mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { LoginRegisterDTO dtoReturn = new LoginRegisterDTO();
		 * if(rs!=null) { dtoReturn.setPersonid(rs.getInt(1));
		 * 
		 * } return dtoReturn; } });
		 */
		return dtoreturn;
	}

// this  inserted data using  hibernate 
	@Override
	public boolean adduserHB(LoginRegisterDTO dto) {
		boolean flag = false;
		Session session = HbSession.getSession();
		LocalDateTime now = LocalDateTime.now();
		int id = 0;
		DateTimeFormatter todaydate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String str = now.format(todaydate);
		dto.setDate(str);
		Transaction tx = session.beginTransaction();

		session.persist(dto);
		if (dto.getPersonid() != 0) {
			flag = true;

		}

		tx.commit();
		session.close();

		return flag;
	}

	@Override
	public List<LoginRegisterDTO> showRegistereduserHB(LoginRegisterDTO dto) {

		Session session = HbSession.getSession();
		List<LoginRegisterDTO> allUser = null;
StringBuilder str=new StringBuilder();
str.append("select * from persons");
if(dto==null) {
}
else if (dto.getFname()!=null) {
	str.append("  where FirstName='"+dto.getFname()+"' ");
	
} else if (dto.getFname()==null && dto.getOntactno()!=null) {
	str.append("  where FirstName='"+dto.getOntactno()+"'");

}
		// allUser=session.createQuery("from
		// LoginRegisterDTO",LoginRegisterDTO.class).getResultList();
		// //get(LoginRegisterDTO.class, 101);
		/*
		 * Query<LoginRegisterDTO> createQuery =
		 * session.createQuery("from LoginRegisterDTO",
		 * LoginRegisterDTO.class).setCacheable(true);
		 * createQuery.setFirstResult(0).setCacheable(true);
		 * createQuery.setMaxResults(10).setCacheable(true);
		 * System.out.println("query executted =");
		 */
		
		  //create Native sql query and use use it
		  
		  NativeQuery<LoginRegisterDTO> createNativeQuery = session
		  .createNativeQuery(str.toString(),
		  LoginRegisterDTO.class).setCacheable(true) ;
		  allUser=createNativeQuery.getResultList();
		//allUser = createQuery.getResultList();
		session.close();
		System.out.println("session closed =");

		return allUser;
	}





	//public static void main(String[] args) {}

	



	@Override
	public List<LoginRegisterDTO> updateuserDtls(LoginRegisterDTO dto) throws Exception {
		Session session = HbSession.getSession();
		Transaction tx = session.beginTransaction();

		LoginRegisterDTO merge = session.merge("LoginRegisterDTO", dto);
		tx.commit();
		session.close();
		if(merge == dto);
		return null;
	}
}
