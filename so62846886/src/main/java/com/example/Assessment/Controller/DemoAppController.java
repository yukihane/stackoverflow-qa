package com.example.Assessment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Assessment.Entity.Employee;
import com.example.Assessment.Repositories.EmployeeRepository;

@Controller
public class DemoAppController {
	
	@Autowired
	private EmployeeRepository r;

	@RequestMapping("/")
	public String showHome(Model m) {
		m.addAttribute("employee", new Employee());
		return "welcome";
	}
	
	@PostMapping("/processForm")
	public String processForm() {
		return null;
	}
	
	@RequestMapping("/registration")
	public String registration(Model m) {
		m.addAttribute("candidate",new Employee());
		return "registration";
	}
	
	@PostMapping("/addCandidate")
	public String addCandidate(@ModelAttribute("candidate") Employee emp) {
		emp.setRole("candidate");
		r.save(emp);
		return "redirect:/";
	}
}

