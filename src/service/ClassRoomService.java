package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ClassRoom;

public interface ClassRoomService {
	List<ClassRoom> findRoomByPage(Integer page,Integer allPage,String[] a);
	int getPageNum(Integer allPage,String[] c);
	List<String> findClassName();
	List<String> findClassNo();
	List<String> findClassAddress();
	
	List<String> findClassSize();
	List<String> findClassType();
	List<String> findClassInstutition();
	
	ClassRoom findClassRoomById(String cno);
	Map<String,Set<String>>  findAllClassPropertity(String[] a);	
}
