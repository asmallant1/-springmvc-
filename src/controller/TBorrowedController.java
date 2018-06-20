package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.ClassRoom;
import model.Tborrowed;
import net.sf.json.JSONArray;
import service.ClassRoomService;
import service.ClassRoomServiceIpml;
import service.TBorrowedService;

@Controller
public class TBorrowedController {
	@Autowired
	TBorrowedService tbs;
	@Autowired
	ClassRoomService cs;
	@RequestMapping("/checkApplication")
	public String checkApplication(HttpSession httpSesstion,Model model) {
		//tbs.findTBorrowedByClassId(cno, time);
		String tno=(String) httpSesstion.getAttribute("id");
//		if(cno!=null&&time!=null&&text!=null) {
//			tbs.saveTborrowed(tno, cno, time, text);
//		}
		List<Tborrowed> listtborrow =tbs.findTBorrowedByTeaId(tno);
		List<ClassRoom> listroomname = new ArrayList<>();
		if(listtborrow!=null) {
			//cs.findClassRoomById(cno);
			System.out.println(listtborrow.get(0).getText());
			for(Tborrowed e:listtborrow) {
				listroomname.add(cs.findClassRoomById(e.getCno()));
			}
		}
		model.addAttribute("listtborrow",listtborrow);
		model.addAttribute("listroomname",listroomname);
		return "checkApplication";
	}
	@RequestMapping("/saveTborrowed")
	public void checkApplication(HttpServletResponse response,HttpSession httpSesstion,Model model,String cno,String[] time,String text) throws IOException {
		//tbs.findTBorrowedByClassId(cno, time);
		String tno=(String) httpSesstion.getAttribute("id");
		if(cno!=null&&time!=null&&text!=null) {
			int a=tbs.saveTborrowed(tno, cno, time, text);
			Map<String ,Object> map = new HashMap<String ,Object>();
			if(a==1) {
				map.put("result", "ok");
			}else {
				map.put("result", "err");
			}
			//map.put("image", ");
			PrintWriter out = response.getWriter();
			String jsonReult = JSONArray.fromObject(map).toString();
			out.print(jsonReult);
			out.close();
		}
		//List<Tborrowed> list =tbs.findTBorrowedByClassId(tno);
	}
}
