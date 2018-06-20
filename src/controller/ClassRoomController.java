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
			//���ڿ��Ǵ�����ҳ�洫�����ĸ���Щinput����select���ϳ�ֵ��
			c = new String[6];
			for(int i=0;i<6;i++) {
				c [i]="all";
			}
			System.out.println("select��ǩΪ��");
		}
		
		//null��ʾ������ҳ����ת������pageС��1�ǷǷ�����
		page=(page==null||page<1)?1:page;

		allPage=(allPage==null)?6:allPage;
		
		//c������name����c����Щselect����input��ǩ��
		//String cno,String cname,String type,String size,String address,String institution;
		//�õ���ҳ��
		int all=cs.getPageNum(allPage,c);
		//�Ƚ������ҳ���Ƿ������ҳ����
		
		System.out.println("cc"+all);
		if(page!=null) {
			page=page>all?all:page;
		}
		List<ClassRoom> list=cs.findRoomByPage(page, allPage,c);
		//����select��ǩ�����ֵ
		
		Map<String,Set<String>>  listpropertity=cs.findAllClassPropertity(c);
		
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("all",all);
		model.addAttribute("c",c);
		model.addAttribute("listpropertity",listpropertity);
		//��reservations�����ϵ�select��Ǩ��������ݷ�װ��service,ֱ�ӵ��þͿ���
		Map<String,List<String>> map =fcs.findAllSelectTage();
		model.addAllAttributes(map);
//		for( String e:map.get("listCname")) {
//			System.out.println(e);
//		}
		return "classroom";

	}
	//ԤԼҳ��
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
