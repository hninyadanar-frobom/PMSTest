package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.pms.form.User;
import com.pms.services.TeamService;

@Controller
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping("/teamCreate")
	public ModelAndView registerUser(@ModelAttribute User user) {

		return new ModelAndView("teamCreate");
	}

	
}