package com.nhoanggiang.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nhoanggiang.demo.model.Employee;
import com.nhoanggiang.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		return "form";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "form";
		}
		employeeService.save(employee);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		employeeService.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String s, Model model) {
		if(s.equals("")) {
			return "redirect:/";
		}
		model.addAttribute("employees", employeeService.search(s));
		return "list";
	}

}
