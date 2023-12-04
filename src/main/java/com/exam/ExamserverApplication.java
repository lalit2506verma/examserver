package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started Code");

		User user = new User();
		user.setFirstName("Lalit");
		user.setLastName("Verma");
		user.setUsername("Lalit_verma");
		user.setEmail("abc@gmail.com");
		user.setGender("Male");
		user.setPassword("abc");
		user.setProfile_photo("default.png");

		Role role = new Role();
		role.setRoleName("ADMIN");
		role.setRole_Description("Administrative rights");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole =  new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);

		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
	}
}
