package com.jsp.bootdemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.jsp.bootdemo.Repository.ProductRepository;
import com.jsp.bootdemo.Repository.UserRepository;
import com.jsp.bootdemo.ResponseStructure.ResponseStructure;

import com.jsp.bootdemo.dto.User;
import com.jsp.bootdemo.exception.UserNotFoundException;
import com.jsp.bootdemo.helper.Login;

@RestController
public class HomeController {
	@Autowired
	ProductRepository pr;
	@Autowired
	UserRepository ur;
	@PostMapping("/saveUser")
	public ResponseStructure<User> saveProduct(@RequestBody User user) {
		User user1 = ur.save(user);
		ResponseStructure<User> response = new ResponseStructure<User>();
		response.setData(user1);
		response.setMessage("data added sussessfully");
		response.setStatuscode(HttpStatus.CREATED.value());
		return response;
	}
	@GetMapping("/loginValidtation")
	public ResponseStructure<User> login(@RequestBody Login login){
		User user1 = ur.findByEmailAndPassword(login.getEmail(), login.getPassword());
		ResponseStructure<User> response = new ResponseStructure<User>();
		if(user1!=null) {
			response.setData(user1);
			response.setMessage("Usser Logged in Sussessfully");
			response.setStatuscode(HttpStatus.FOUND.value());
			return response;
		}else {
			throw new UserNotFoundException("user did not validate properly");
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseStructure<Integer> delete(@RequestParam("id") int id){
		ur.deleteById(id);
		ResponseStructure<Integer> res = new ResponseStructure<Integer>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMessage("delted user successfully");
		res.setData(id);
		return res;
	}
	
	@PutMapping("/updateUser")
	public ResponseStructure<User> updateUser(@RequestBody User user){
		User updated = ur.save(user);
		ResponseStructure<User> response = new ResponseStructure<User>();
		response.setData(updated);
		response.setMessage("data updated sussessfully");
		response.setStatuscode(HttpStatus.ACCEPTED.value());
		return response;
	}
	@PatchMapping("/patchReq")
	public ResponseStructure<User> pathUser(@RequestParam("name") String name,@RequestParam("id") int id){
		Optional<User> opt = ur.findById(id);
		User user = opt.get();
		user.setName(name);
		User save = ur.save(user);
		ResponseStructure<User> res = new ResponseStructure<User>();
		res.setData(save);
		res.setMessage("data updated sussessfully");
		res.setStatuscode(HttpStatus.ACCEPTED.value());
		return res;
	}
	
	

}
