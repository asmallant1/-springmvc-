package service;

import java.util.List;

import model.Teacher;

public interface TeacherService {
	Teacher findOneTeacherById(String tno);
	int updatePersonlMessage(String tno,String sex,String email,String address,String age,String institution,String personalmessage);
	void inputHeadImage(String image,String tno);
	String outputHeadImage(String tno);
	int updatePersonalPassword(String tno,String oldPassword,String newPassword);
}
