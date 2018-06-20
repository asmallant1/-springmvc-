package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jt;
	public boolean findUserById(String id,String password,String type) {
		String sql="select * from user where id=? and password=? and type=?";
		RowMapper<User>  rm=(RowMapper<User>) new  BeanPropertyRowMapper<>(User.class);
		List<User> list= jt.query(sql, rm,id,password,type);
		if(list.size()==0) {
			return false;
		}else 
		return true;
		
	}
}
