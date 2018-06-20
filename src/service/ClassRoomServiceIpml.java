package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ClassRoom;
import repository.ClassRoomRepository;
@Service
public class ClassRoomServiceIpml implements ClassRoomService{
	@Autowired
	ClassRoomRepository cr;
	@Override
	public List<ClassRoom> findRoomByPage(Integer page, Integer allPage,String[] c) {
		// TODO Auto-generated method stub
		
		List<ClassRoom> list =cr.findByPage(page,allPage,c);
		return list;
	}
	@Override
	public int getPageNum(Integer allPage,String[] c) {
		if(c==null) {
			//等于空是从其它页面传过来的给那些input或者select附上初值。
			c = new String[6];
			for(int i=0;i<6;i++) {
				c [i]="all";
			}
			System.out.println("select标签为空");
		}
		
		//allpage代表一页显示多少条信息，null代表从其他页面跳转过来。
		allPage=(allPage==null)?6:allPage;
		return cr.getPageNum(allPage, c);
	}
	@Override
	public List<String> findClassName() {
		// TODO Auto-generated method stub
		return cr.findClassName();
	}
	@Override
	public List<String> findClassNo() {
		// TODO Auto-generated method stub
		return cr.findClassCno();
	}
	@Override
	public List<String> findClassAddress() {
		// TODO Auto-generated method stub
		return cr.findClassAddress();
	}
	@Override
	public List<String> findClassSize() {
		// TODO Auto-generated method stub
		return cr.findClassSize();
	}
	@Override
	public List<String> findClassType() {
		// TODO Auto-generated method stub
		return cr.findClassType();
	}
	@Override
	public List<String> findClassInstutition() {
		// TODO Auto-generated method stub
		return cr.findClassInstitution();
	}
	@Override
	public ClassRoom findClassRoomById(String cno) {
		// TODO Auto-generated method stub
		return cr.findClassroomById(cno);
	}
	@Override
	public Map<String,Set<String>>  findAllClassPropertity(String[] c) {
		// TODO Auto-generated method stub
		
		if(c==null) {
			//等于空是从其它页面传过来的给那些input或者select附上初值。
			c = new String[6];
			for(int i=0;i<6;i++) {
				c [i]="all";
			}
			//System.out.println("select标签为空");
		}
		return cr.findAllClassPropertity(c);
	}
	

}
