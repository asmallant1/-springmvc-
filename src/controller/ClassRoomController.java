package controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.ClassRoom;
import model.Tborrowed;
import service.ClassRoomService;
import service.TBorrowedService;
import service.findClassRoomService;

@Controller
public class ClassRoomController {
	@Autowired
	ClassRoomService cs;
	@Autowired
	findClassRoomService fcs;
	@Autowired
	TBorrowedService ts;
	@RequestMapping("/classroom")
	public String classroom(Model model,Integer page,Integer allPage,String[] c) {

		if(c==null) {
			//等于空是从其它页面传过来的给那些input或者select附上初值。
			c = new String[6];
			for(int i=0;i<6;i++) {
				c [i]="all";
			}
			System.out.println("select标签为空");
		}
		
		//null表示从其他页面跳转过来，page小于1是非法请求
		page=(page==null||page<1)?1:page;

		allPage=(allPage==null)?6:allPage;
		
		//c参数是name等于c的哪些select或者input标签。
		//String cno,String cname,String type,String size,String address,String institution;
		//得到总页数
		int all=cs.getPageNum(allPage,c);
		//比较请求的页面是否大于总页面数
		
		System.out.println("cc"+all);
		if(page!=null) {
			page=page>all?all:page;
		}
		List<ClassRoom> list=cs.findRoomByPage(page, allPage,c);
		//所有select标签里面的值
		
		Map<String,Set<String>>  listpropertity=cs.findAllClassPropertity(c);
		
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("all",all);
		model.addAttribute("c",c);
		model.addAttribute("listpropertity",listpropertity);
		//将reservations界面上的select变迁里面的内容封装在service,直接调用就可以
		Map<String,List<String>> map =fcs.findAllSelectTage();
		model.addAllAttributes(map);
//		for( String e:map.get("listCname")) {
//			System.out.println(e);
//		}
		return "classroom";

	}
	//预约页面
	@RequestMapping("/reservations")
	public String reservations(Model model,String cno,HttpSession session) {
		System.out.println("c:"+cno);
		ClassRoom cr=cs.findClassRoomById(cno);
		List<Tborrowed> list = ts.findTBorrowedByClassId(cr.getCno());
			model.addAttribute("cr",cr);
			model.addAttribute("list",list);
			String tno=(String)session.getAttribute("id");
			System.out.println(tno);
		List<Tborrowed> listTime=ts.findTborrowdMoreThanToday(cno,tno);
			model.addAttribute("listTime",listTime);
			//System.out.println(listTime.get(0).getStartdate());
		//System.out.println(cr.getAddress());
		return "reservations";
		
	}

}
