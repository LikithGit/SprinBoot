package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Modelclass;

@RestController
@RequestMapping("/users")
public class Controller {

	Map<Integer,Modelclass> user = new HashMap<>();  // o/p in key-value pair
	
	
	@GetMapping(value = "/getusers")
	public Collection<Modelclass> getMethod(){
		
		return user.values();
	}
	
	@PostMapping (value = "/addusers")
	public String post(@RequestBody Modelclass model){
		Modelclass obj = new Modelclass();
		obj.setId(model.getId());
		obj.setName(model.getName());
		obj.setEmail(model.getEmail());
		user.put(model.getId(), obj);
		return "Data Added ";
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable Integer id,@RequestBody Modelclass model) {
		if(user.containsKey(id)) {
		Modelclass obj = new Modelclass();
		obj.setId(model.getId());
		obj.setName(model.getName());
		obj.setEmail(model.getEmail());
		user.put(id, obj);
		return "Data Updated ";
	}
		else {
			return "USer not Exist" ;
		}
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		if(user.containsKey(id)){
			user.remove(id);
			return "User Deleted Successfully";
		}
		else {
			return "User Not Found";
		}
	}
	
	@GetMapping(value = "/get")
	public String get1() {
		return "Get method called";
	}
	
}
