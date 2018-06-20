package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import model.ClassRoom;
import model.Tborrowed;
import repository.ClassRoomRepository;
import repository.TBorrowedRepository;
import service.ClassRoomService;
import service.ClassRoomServiceIpml;
 
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:spring-config.xml"})
//@Transactional
public class RepositoryTest {
//	@Autowired
//	ClassRoomRepository cr;
//	@Autowired
//	TBorrowedRepository tr;

	ApplicationContext context = new ClassPathXmlApplicationContext("Test/spring-config.xml");
	JdbcTemplate jt=(JdbcTemplate) context.getBean("jdbcTemplate");
	ClassRoomRepository cr= new ClassRoomRepository();
	TBorrowedRepository tr = new TBorrowedRepository();
	
	@Before
	public void RTest() {
		cr.setJt(jt);
		tr.setJt(jt);
	}
	@Test
	public void testClassRoomByPage() {
		Integer page=1;
		Integer allPage=5;
		String [] a=new String[6];
		for(int i=0;i<6;i++) {
			a[i]="all";
		}
		//测试按页查找时，模拟从其他页面调到该页面时的情况。
		List<ClassRoom> list=cr.findByPage(page, allPage, a);
		for(ClassRoom c:list) {
			System.out.print(c.getCno()+"\t");
			System.out.print(c.getCname()+"\t");
			System.out.print(c.getSize()+"\t");
			System.out.print(c.getType()+"\t");
			System.out.print(c.getAddress()+"\t");
			System.out.println(c.getInstitution());
		}
		System.out.println("-------------");
		
	}

	@Test
	public void testfindAllByClassPropertity() {
		String [] a=new String[6];
		for(int i=0;i<6;i++) {
			a[i]="all";
		}
		Map<String, Set<String>> map=cr.findAllClassPropertity(a);
	
		Iterator<String> it = map.get("cno").iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("-------------");
	}
	@Test
	public  void findClassroomById() {
		ClassRoom cr1=cr.findClassroomById("1001");
		System.out.println(cr1.getCname());
		System.out.println("-------------");
	}
	
	
	@Test
	public void  findTborrowedByTeaId() {
		String tno="151001";
		List<Tborrowed> list=tr.findTborrowedByTeaId(tno);
		System.out.println(list.get(0).getStartdate());
		System.out.println(list.get(0).getEnddate());
		System.out.println(list.get(0).getCno());
	}

	@Test
	public void find() {
		String tno="151001";
		String cno="1001";
		tr.findTborrowdMoreThanToday(cno, tno);
	}
}
