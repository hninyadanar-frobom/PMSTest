package com.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.pms.dao.UserDaoImpl;
import com.pms.form.User;
import com.pms.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public ModelAndView show(@ModelAttribute User user) {
		return new ModelAndView("login");
	}

	@RequestMapping("/loginUser")
	public String checkLogin(@ModelAttribute User user, HttpServletRequest req) {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession(true);
		boolean flag = userService.getUser(email, password);

		if (flag) {
			int userid = Integer.parseInt(userService.getUserIdByEmail(email));

			session.setAttribute("userId", userid);
			return "redirect:/homePage";
		} else {
			session.setAttribute("loginError", "Email or Password Do Not Correct");
			return "redirect:/login";
		}

	}

	@RequestMapping("/homePage")
	public ModelAndView home(@ModelAttribute User user) {
		return new ModelAndView("homePage");
	}

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user) {

		return new ModelAndView("register");

	}

	@RequestMapping("/insert")
	public String inserData(@ModelAttribute User user, HttpServletRequest req) {

		String email = user.getUserEmail();
		
		
		List<User> userList = userService.getAllUser();
		
		System.out.println("User List"+userList);
		HttpSession session = req.getSession(true);
		for (User u : userList) {
			if (u.getUserEmail().equals(email)) {

				session.setAttribute("DuplicateEmail", "Email already exist.");
				return "redirect:/register";
			}

			else {

				userService.insertData(user);
				return "redirect:/homePage";
			}
		}
		return null;

		
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/login";
	}

}
