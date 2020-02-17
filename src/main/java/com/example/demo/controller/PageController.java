package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/aloha")
	public String hello() {
		return "aloha";
	}
	
//	@RequestMapping("/hello2")
//	public String hello2(@RequestParam(value = "name", required = false, defaultValue = "Thanos")String name, Model model) {
//		model.addAttribute("name", name);
//		return "hello2";
//	}
//	
	@RequestMapping({"/hello2/{name}","/hello2"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/hitung")
	public String hitung(	@RequestParam(value="angka1",required=false)String angka1,
								@RequestParam(value="angka2",required=false)String angka2,
								Model model) {

		model.addAttribute("angka1",angka1);
		model.addAttribute("angka2",angka2);
		
		int hasil = Integer.parseInt(angka1) + Integer.parseInt(angka2);
		
		model.addAttribute("hasil",hasil);
		return "hitung";
	}
	//hello Path udah diubah.
}
