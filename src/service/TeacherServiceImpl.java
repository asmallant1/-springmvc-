package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Teacher;
import repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	TeacherRepository tr;
	@Override
	public Teacher findOneTeacherById(String tno) {
		// TODO Auto-generated method stub
		return tr.findOneTeaById(tno);
	}
	@Override
	public int updatePersonlMessage(String tno,  String sex, String email, String address,String age,String institution,String personalmessage) {
		// TODO Auto-generated method stub
		return tr.updatePersonalMessage(tno, sex, email, address,age,institution,personalmessage);
	}
	@Override
	public void inputHeadImage(String image,String tno) {
		// TODO Auto-generated method stub
		tr.inputHeadImage(image,tno);
	}
	@Override
	public String outputHeadImage(String tno) {
		// TODO Auto-generated method stub
		return tr.outputHeadImage(tno);
	}
	@Override
	public int updatePersonalPassword(String tno, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return tr.updatePersonalPassword(tno, oldPassword, newPassword);
	}
	
}
