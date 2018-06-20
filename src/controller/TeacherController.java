package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import service.TeacherService;
import service.UserService;

@Controller
public class TeacherController {
	@Autowired
	TeacherService ts;
	
	@Autowired
	UserService us;
	@RequestMapping("/home")
	public String home(Model model, String id,String password,String type,HttpSession httpSession) {
		System.out.println(id+"--"+password+"--"+type);
		if(us.findPersonalMessage(id, password, type)) {
			httpSession.setAttribute("id",id);
			return "home";
		}else 
			return "/login";
	}
	@RequestMapping("/index")
	public String index(Model model,HttpSession httpSession) {
		String tno=(String) httpSession.getAttribute("id");
		Teacher tea = ts.findOneTeacherById(tno);
		model.addAttribute("tea",tea);
		model.addAttribute("image",ts.outputHeadImage(tno));
		return "index";
	}
	@RequestMapping("/changeTeaPersonalMessage")
	public String changeTeaPresonalMessage(String sex,String email,String address,String institution,String age,String personalmessage,Model model,HttpSession httpSession) {
		String tno=(String) httpSession.getAttribute("id");
		//System.out.println(aa);
		//先更新数据在查询；
//		System.out.println(sex);
//		System.out.println(age);
//		System.out.println(email);
//		System.out.println(address);
//		System.out.println(institution);
		//personalmeassage
		//System.out.println(personalmessage);
		//System.out.println(institution);
		if(sex!=null||age!=null||email!=null||address!=null||institution!=null||personalmessage!=null) {
			ts.updatePersonlMessage(tno, sex, email, address, age, institution,personalmessage);
		//String sex,String email,String address,String institution,String age,
		//System.out.println(sex);
		}
		//String sql="";
		
		Teacher tea = ts.findOneTeacherById(tno);
		model.addAttribute("image",ts.outputHeadImage(tno));
		model.addAttribute("tea",tea);
		
		return "changeTeaPersonalMessage";
	}

	@RequestMapping("/changeTeaPassword")
	public String changeTeaPassword(HttpServletResponse response,HttpSession httpSession,String old,String password1,String password2) {
		if(old!=null&&password1!=null&&password2!=null) {
			System.out.println(httpSession.getAttribute("id"));
			System.out.println("rwerwr"+old+"--"+password1+"--"+password2);
			int a=ts.updatePersonalPassword((String) httpSession.getAttribute("id"), old, password1);
			if(a!=0) {
				try {
					response.sendRedirect("springHomeWork/home");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "login";
			}
		}else {
			System.out.println("空的修改密码");
		}
		return "changeTeaPassword";
		
	}
	@RequestMapping("/changeHeadImage")
	public String changeHeadImage(String image,HttpSession httpSession,HttpServletResponse response) throws IOException {
		//System.out.println(image);
		response.setCharacterEncoding("UTF-8");
		if(image!=null) {
			
			//ajax回调
			List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
			ts.inputHeadImage(image,(String)httpSession.getAttribute("id"));
			Map<String ,Object> map = new HashMap<String ,Object>();
			map.put("image", image);
			map.put("result", "ok");
			datas.add(map);
			PrintWriter out = response.getWriter();
			String jsonReult = JSONArray.fromObject(datas).toString();
			out.print(jsonReult);
			out.close();
		}else {
			
		}

		
		return "index";
		
	}
}
