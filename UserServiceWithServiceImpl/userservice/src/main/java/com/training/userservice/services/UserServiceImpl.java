package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.exceptions.UserNotFound;
import com.training.userservice.model.User;



@Service
public class UserServiceImpl implements UserService{

	List<User> userList = new ArrayList<User>();
	
	public UserServiceImpl(){
		User u1 = new User(1, "Joe Tribiany", "NY", "joe@some.com","abc123");
		User u2 = new User(2, "Chandler", "NY", "cahndle@some.com","abc123");
		User u3 = new User(3, "Monika", "NY", "mon@some.com","abc123");
		User u4 = new User(4, "Phebe", "NY", "pheb@some.com","abc123");
		User u5 = new User(5, "Ross", "NY", "ross@some.com","abc123");
		User u6 = new User(6, "Rachel", "NY", "rach@some.com","abc123");
		
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		userList.add(u5);
		userList.add(u6);	
	}
	
	
	@Override
	public List<User> getAllUsers() {
		return userList;
	}

	@Override
	public User getUser(int id) {
		User u = userList.stream()
				.filter(user->user.getId()==id)
				.findFirst()
				.orElseThrow(()-> new UserNotFound(id+""));
		return u;
	}

	@Override
	public User saveUser(User u) {
		
		if(!userList.stream().filter(x->x.getId() == u.getId()).findFirst().isEmpty()) {
			throw new RuntimeException("User Already Exist");
		}else {
			userList.add(u);
		}
		
		return userList.stream()
				.filter(user->user.getId()==u.getId())
				.findFirst()
				.orElseThrow(()-> new RuntimeException("User Not Added"));
	}

	@Override
	public User updateUser(int id, User u) {
		User existingUser = userList.stream().filter(user->user.getId()==id).findFirst()
				.orElseThrow(()->new UserNotFound(id+""));
		if(existingUser!=null) {
			if(u.getName()!=null)
				existingUser.setName(u.getName());
			if(u.getAdress()!=null)
				existingUser.setAdress(u.getAdress());
			if(u.getEmail()!=null)
				existingUser.setEmail(u.getEmail());
		}
		return existingUser;
	}

	@Override
	public String deleteUser(int id) {
		String result = null;
		User u = userList.stream().filter(user->user.getId()==id).findFirst()
				.orElseThrow(()->new UserNotFound(id+""));
		if(u!=null) {
			userList.remove(u);
			result =  "User removed Succfully with id :: "+ id;
		}else {
		result =  " User not found with id ::: "+ id;
		}
		return result;
	}

	

}
