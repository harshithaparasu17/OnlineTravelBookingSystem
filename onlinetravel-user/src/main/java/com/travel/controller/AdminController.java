package com.travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.dto.UserDTO;
import com.travel.dto.UserDefaultResponseDTO;
import com.travel.entity.User;
import com.travel.service.UserService;
import com.travel.util.UserDTOConvertor;

@RestController
@RequestMapping("/travel/admin")
@Validated
public class AdminController {

	@Autowired
	UserService userService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/addadmin")
	public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
		try {
			User savedUser = userService.insertUser(user);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getUserId();
			mylogs.info(" ---->> Inside Admin Controller Post mapping , user created "+responseMsg);
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			mylogs.error(errorMsg);
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		try {
			List<User> allExtractedUsers = userService.getAllUsers();

			return allExtractedUsers;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;
	}
	@GetMapping("/user/{searchUserName}")
	public ResponseEntity<UserDTO> getUserByUserName(@PathVariable String searchUserName)throws Exception
	{
		User user=userService.getUserByUserName(searchUserName);
		UserDefaultResponseDTO dto=UserDTOConvertor.getUserDefaultDTO(user);
		return new ResponseEntity<UserDTO>(dto,HttpStatus.OK);
	}
	@GetMapping("/role/{searchRole}")
	public List<User>getUserByRole(@PathVariable String searchRole)throws Exception
	{
		System.out.println("----->> 1 Inside Controller"+searchRole);
		return userService.getUserByRole(searchRole);
	}
	@GetMapping("userid/{searchUserId}")
	public User getUserByUserId(@PathVariable int searchUserId) throws Exception {
		return userService.getUserByUserId(searchUserId);
	}
	@GetMapping("/usersbyId")
	public List<User> usersById(@RequestParam int r1 , @RequestParam int r2)throws Exception
	{
		
		return userService.getUsersBetweenIds(r1, r2);
	}	
	@GetMapping("/filterbyrole/{role}")
	public List<User> filterByRole(@PathVariable String role) throws Exception
	{
		List<User> filtered = userService.FilterByRole(role);
		return filtered;
	}

	
}
