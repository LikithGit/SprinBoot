package com.example.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Modelclass;

@RestController
@RequestMapping("/users")
public class Controller {

	Map<Integer,Modelclass> user = new HashMap<>();  // o/p in key-value pair
	
	
	@GetMapping
	public Collection<Modelclass> getMethod(){
		
		return user.values();
	}
	
	@PostMapping
	public String post(@RequestBody Modelclass model){
		Modelclass obj = new Modelclass();
		obj.setId(model.getId());
		obj.setName(model.getName());
		obj.setEmail(model.getEmail());
		user.put(model.getId(), obj);
		return "Data Added ";
	}
	
}
