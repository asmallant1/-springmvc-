package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.ClassRoom;
import model.Teacher;
import service.ClassRoomService;
import service.TeacherService;

@Controller
public class HomeController {
	@Autowired
	TeacherService ts;
	@Autowired
	ClassRoomService cs;
	@RequestMapping("/")
	public String login() {
		
		return "login";
	}

}
