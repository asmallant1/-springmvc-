package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Teacher;
@Repository
public class TeacherRepository {
	@Autowired
	JdbcTemplate jt;
	public Teacher findOneTeaById(String tno){
		String sql="select * from teacher where tno=?";
		Teacher tea=jt.queryForObject(sql, new RowMapper<Teacher>() {
			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher tea = new Teacher();
				tea.setTno(rs.getString(1));
				tea.setTname(rs.getString(2));
				tea.setSex(rs.getString(3));
				tea.setEmail(rs.getString(4));
				tea.setAddress(rs.getString(5));
				tea.setInstitution(rs.getString(6));
				tea.setPersonalmessage(rs.getString(7));
				tea.setAge(rs.getString(9));
				return tea;
			}			
		},tno);
		//RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);  
		return tea;
	}
//	public Student findOne(String sno) {
//		String sql = "select * from students where sno=?";
//		return jdbcOperations.queryForObject(sql, new RowMapper<Student>() {
//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student st = new Student();
//				st.setSno(rs.getString(1));
//				st.setSname(rs.getString(2));
//				//Çë²¹³ä
//				return st;
//			}			
//		},sno);
//	}
	public int updatePersonalMessage(String tno,String sex,String email,String address,String age,String institution,String personalmessage) {
		String sql= "update teacher set sex=? , email=? , address=? , age=? , institution=? , personalmessage=? where tno=?";
		int a=jt.update(sql,sex,email,address,age,institution,personalmessage,tno);
		return a;
		
	}
	public int updatePersonalPassword(String tno,String oldPassword,String newPassword) {
		String sql= "update user set password=? where id=? and password=?";
		int a=jt.update(sql,newPassword,tno,oldPassword);
		return a;
		
	}
	public void inputHeadImage(String image,String tno) {
		String sql="update teacher set headImage=? where tno=?";
		int a =jt.update(sql,image,tno);
	}
	public String outputHeadImage(String tno) {
		String sql="select headImage from teacher  where tno=?";
		String image=(String)jt.queryForObject(sql,String.class,tno);
		return image;
	}
}
