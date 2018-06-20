package repository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Tborrowed;

@Repository
public class TBorrowedRepository {
	@Autowired
	JdbcTemplate jt;
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int saveTborrowed(String tno,String cno,String[] time,String text) throws ParseException {
	
		
		
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=dateFormat.format(date);
		
		RowMapper<Tborrowed> rowMapper = new BeanPropertyRowMapper<>(Tborrowed.class);
		//查询出改教室被租用的时间端
		String sql1="select * from tborrowed where approval=1 and cno=? and enddate>? or (tno=? and cno=?)";
		List<Tborrowed> list1=jt.query(sql1, rowMapper,cno,today,tno,cno);
		int b=0,a=0;
		for(Tborrowed s:list1) {
			System.out.println("s:"+s.getStartdate()+"e:"+s.getEnddate());
			if(dateFormat.parse(time[1]+":00").before(dateFormat.parse(dateFormat.format(s.getStartdate())))||dateFormat.parse(time[0]+":00").after(dateFormat.parse(dateFormat.format(s.getEnddate())))) {
				//
				System.out.println("时间不冲突");
			}else {
				System.out.println("时间冲突");
				b=-1;
			}
		}
		if(b==-1) {
			return b;
		}else {
			System.out.println("-现在时间-"+today);
			System.out.println("-开始-"+time[0]+":00");
			System.out.println("-结束-"+time[1]+":00");
			System.out.println(text);
			//System.out.println(x);
			String sql="insert into tborrowed(tno,cno,startdate,enddate,approval,text,applicationdate) values(?,?,?,?,?,?,?)";
			try {
				a=jt.update(sql,tno,cno,time[0]+":00",time[1]+":00",0,text,today);
			}catch (Exception e) {
				a=-1;
			}
			System.out.println(a);
		}
		return a;
	}

	public List<Tborrowed> findTborrowedByTeaId(String tno){
		System.out.println(tno);
		//	String sql="select tborrowed.tno,tname,tborrowed.cno,cname,startdate,enddate,approval,approvaldate,text"
		//+ "from tborrowed,teacher,classroom where tborrowed.tno=? and tborrowed.tno=teacher.tno and tborrowed.cno=classroom.cno "
		//+ "order by approval asc";
		String sql="select * from tborrowed where tno=? order by approval asc";
		RowMapper<Tborrowed> rowMapper = new BeanPropertyRowMapper<>(Tborrowed.class);
		List<Tborrowed> list =jt.query(sql, rowMapper,tno);
		return list;
		
	}

	public List<Tborrowed> findTborrowedByClassId(String cno) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Tborrowed> findTborrowdMoreThanToday(String cno,String tno){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=dateFormat.format(date);
		String sql="select * from tborrowed where approval=1 and cno=? and enddate>? or (tno=? and cno=?) order by startdate asc";
		RowMapper<Tborrowed> row= new BeanPropertyRowMapper<>(Tborrowed.class);
		return jt.query(sql, row,cno,today,tno,cno);
	}
}
