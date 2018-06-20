package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import model.ClassRoom;

@Repository
public class ClassRoomRepository {
	@Autowired
	JdbcTemplate jt;
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public List<ClassRoom> findByPage(int page,int allPage,String[] a){
		String sql = "select * from classroom where 1=1 #order by cno asc limit ?,? ";
		//List<ClassRoom> list = new ArrayList<ClassRoom>();
		RowMapper<ClassRoom> rm1 =new BeanPropertyRowMapper<>(ClassRoom.class);
//		for(int i=0;i<a.length;i++) {
//			if("all".equals(a[i])) {
//				
//			}
//			System.out.println("classroomrepositoty输出："+a[i]);
//		}
		//查询用的sql语句是经过函数处理的
		String result=addWordForSql(a, sql);
//		String sql="select * from classroom where 1=1 order by cno asc limit ?,? ";
		return jt.query(result, rm1,(page-1)*allPage,allPage);
	}
	public Map<String,Set<String>>  findAllClassPropertity(String[] a){
		String sql = "select * from classroom where 1=1 # ";
		String result=addWordForSql(a, sql);
		System.out.println("repository-select联动:+"+result);
		
		RowMapper<ClassRoom> rm1 =new BeanPropertyRowMapper<>(ClassRoom.class);
		//但是list里面存的信息有重复的。所以要消除重复的。因为HashSet取出是无序的，所以我用的是LinkHashSet;
		Set<String> set= new LinkedHashSet<>();
		List<ClassRoom> list=jt.query(result, rm1);
		Map<String,Set<String>> map=new HashMap<>();
		set.add("all");
		for(ClassRoom c:list) {
			set.add(c.getCno());
		}
		map.put("cno", set);
		
		set= new LinkedHashSet<>();
		set.add("all");
		for(ClassRoom c:list) {
			set.add(c.getCname());
		}
		map.put("cname", set);
		
		set= new LinkedHashSet<>();
		set.add("all");
		for(ClassRoom c:list) {
			
			set.add(c.getType());
		}
		map.put("type", set);
		
		set= new LinkedHashSet<>();
		set.add("all");
		for(ClassRoom c:list) {
			set.add(c.getSize()+"");
		}
		map.put("size", set);
		
		set= new LinkedHashSet<>();
		set.add("all");
		for(ClassRoom c:list) {
			set.add(c.getAddress());
		}
		map.put("address", set);
		
		set= new LinkedHashSet<>();
		set.add("all");
		for(ClassRoom c:list) {
			set.add(c.getInstitution());
		}
		map.put("institution", set);
		return map;
		
	}
	public int getPageNum(int allPage,String[] c) {
		String sql = addWordForGetPageNumSql(c);
		int num=jt.queryForObject(sql,Integer.class);
		if(allPage>=num) {
			num=1;
		}else
			num=num%allPage==0?num/allPage:num/allPage+1;
		return num;
		
	}
	
	public ClassRoom findClassroomById(String cno) {
		String sql="select * from classroom where cno=?";
		RowMapper<ClassRoom>  rm=(RowMapper<ClassRoom>) new  BeanPropertyRowMapper<>(ClassRoom.class);
		List<ClassRoom> list= jt.query(sql, rm,cno);
		if(list.size()==1) {
			return list.get(0);
		}else return new ClassRoom();
		
	}
	private static String addWordForSql(String[] word,String sql) {
	
		//String cno,String cname,String type,String size,String address,String institution;
		String[] a1= {"cno","cname","type","size","address","institution"};
		String sql1="";
		for(int i=0;i<a1.length;i++) {
			if("all".equals(word[i])) {
				//System.out.println("all,不插入wrod");
			}else {
				 sql1= sql1+" and "+a1[i]+" like '%"+word[i]+"%' ";
			}
		}
		String[] sql2=sql.split("#");
		String result=sql2[0]+sql1+sql2[1];
//		System.out.println(sql2[0]);
//		System.out.println(sql2[1]);
//		System.out.println(sql1);
//		System.out.println(sql);
		System.out.println(result);
		return result;
	}
	private static String addWordForGetPageNumSql(String[] word) {
		String sql = "select count(*) from classroom where 1=1";
		String[] a1= {"cno","cname","type","size","address","institution"};
		for(int i=0;i<a1.length;i++) {
			if("all".equals(word[i])) {
				//System.out.println("all,不插入wrod");
			}else {
				 sql= sql+" and "+a1[i]+" like '%"+word[i]+"%' ";
			}
		}
		System.out.println(sql);
		return sql;
	}
	public List<String> findClassName(){
		String sql="select distinct cname from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
			list.add("all");
			for(Map map:rows ) {
				list.add((String)map.get("cname"));
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}
	public List<String> findClassType(){
		String sql="select distinct type from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
		list.add("all");
			for(Map map:rows ) {
				list.add((String)map.get("type"));
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}
	
	public List<String> findClassSize(){
		String sql="select distinct size from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
		list.add("all");
			for(Map map:rows ) {
				list.add(map.get("size")+"");
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}
	
	public List<String> findClassInstitution(){
		String sql="select distinct institution from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
		list.add("all");
			for(Map map:rows ) {
				list.add((String)map.get("institution"));
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}
	public List<String> findClassCno(){
		String sql="select distinct cno from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
		list.add("all");
			for(Map map:rows ) {
				list.add((String)map.get("cno"));
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}
	public List<String> findClassAddress(){
		String sql="select distinct address from classroom where 1=1";
		List<String> list = new ArrayList<>();
		List<Map<String, Object>> rows=jt.queryForList(sql);
		list.add("all");
			for(Map map:rows ) {
				list.add((String)map.get("address"));
			}
//		for(String e:list) {
//			System.out.println(e);
//		}
		return list;
 	}

}
