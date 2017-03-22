package com.pms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.form.Conversation;
import com.pms.services.ConversationService;
import com.pms.services.MemberService;
//import com.pms.services.UserService;

@Controller
public class ConversationController {

	@Autowired
	ConversationService convService;

	@Autowired
	MemberService memberService;

	// Team Conversation.....

	// Check whether team member and Show Conversation List

	@RequestMapping("/checkIfMember")
	public String isTeamMember(HttpServletRequest request) {

		boolean isMember;
		isMember = memberService.isMember(1, 1);
		if (isMember) {
			List<Conversation> convList = convService.getConvList(1);
			HttpSession sess = request.getSession(true);
			sess.setAttribute("convList", convList);
			return "redirect:/team_Conversations";
		}
		return null;
	}

	@RequestMapping("/team_Conversations")
	public ModelAndView ShowConvs() {
		return new ModelAndView("conversation");
	}

	// Write Team Conversation and Show Conversation List

	@RequestMapping("/postConv")
	public String insertConversation(HttpServletRequest request) {

		Date date = new Date();
		SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
		System.out.println(dt1.format(date));

		String message = request.getParameter("msg");

		if (message.isEmpty()) {
			
			return "redirect:/team_post";
		} 
		else {
			
			Conversation conv = new Conversation();
			conv.setConvPostDate(dt1.format(date));
			conv.setMessage(message);
			// conv.setPostBy(postBy);
			convService.insertConv(conv);

			return "redirect:/team_post";
		}
	}

	@RequestMapping("/team_post")
	public String postAndShowConvs(HttpServletRequest request) {

		List<Conversation> convList = convService.getConvList(1);
		HttpSession sess = request.getSession(true);
		sess.setAttribute("convList", convList);

		return "redirect:/team_post_conversations";
	}

	@RequestMapping("/team_post_conversations")
	public ModelAndView showConvs() {

		return new ModelAndView("conversation");
	}

	// Delete Team Conversation and Show Conversation List

	@RequestMapping("/deleteConversation/{conversationid}/{teamid}")
	public String deleteConversation(@PathVariable int conversationid, @PathVariable int teamid,
			HttpServletRequest request) {

		System.out.println("Test");
		System.out.println("convid = " + conversationid);
		System.out.println("teamid = " + teamid);

		String postBy = "Hsu";
		List<Conversation> convList = convService.checkWriteConvAndDelete(conversationid, postBy, teamid);
		System.out.println("conversationid " + conversationid + " is deleted.");
		HttpSession session = request.getSession(true);
		session.setAttribute("convList", convList);
		return "redirect:/team_delete_conversations";
	}

	@RequestMapping("/team_delete_conversations")
	public ModelAndView showConversation() {

		return new ModelAndView("conversation");
	}

	// Project Conversation.....

	// Check if project member and Show Conversation List

	@RequestMapping("/checkIfProjMember")
	public String isProjMember(HttpServletRequest request) {

		boolean isProjMember;
		isProjMember = memberService.isProjMember(1, 1);

		if (isProjMember) {
			List<Conversation> convList = convService.getProjConvList(1);
			HttpSession sess = request.getSession(true);
			sess.setAttribute("convList", convList);
			return "redirect:/ProjConversations";
		}
		return null;
	}

	@RequestMapping("/ProjConversations")
	public ModelAndView ShowProjectConvs() {
		return new ModelAndView("projectConversation");
	}

	// Write Project Conversation and Show Conversation List

	@RequestMapping("/postProjConv")
	public String insertProjConversation(HttpServletRequest request) {

		Date date = new Date();
		SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
		System.out.println(dt1.format(date));
		String message = request.getParameter("msg");

		if (message.isEmpty()) {

			return "redirect:/project_post";
		}

		else {
			Conversation conv = new Conversation();
			conv.setConvPostDate(dt1.format(date));
			conv.setMessage(message);
			// conv.setPostBy(postBy);
			convService.insertConv(conv);

			return "redirect:/project_post";
		}
	}

	@RequestMapping("/project_post")
	public String postAndShowConv(HttpServletRequest request) {

		List<Conversation> convList = convService.getProjConvList(1);
		HttpSession sess = request.getSession(true);
		sess.setAttribute("convList", convList);

		return "redirect:/project_post_conversations";
	}

	@RequestMapping("/project_post_conversations")
	public ModelAndView showProjConvs() {

		return new ModelAndView("projectConversation");
	}

	// Delete Project Conversation and Show Conversation List

	@RequestMapping("/deleteProjConversation/{conversationid}/{projectid}")
	public String deleteProjConversation(@PathVariable int conversationid, @PathVariable int projectid,
			HttpServletRequest request) {

		System.out.println("Test");
		System.out.println("convid = " + conversationid);
		System.out.println("projID = " + projectid);
		String postBy = "Hsu";

		List<Conversation> convList = convService.checkWriteAndDeleteProjConvs(conversationid, postBy, projectid);
		System.out.println("conversationid " + conversationid + " is deleted.");
		HttpSession session = request.getSession(true);
		session.setAttribute("convList", convList);
		return "redirect:/project_delete_conversations";
	}

	@RequestMapping("/project_delete_conversations")
	public ModelAndView showProjConversation() {

		return new ModelAndView("projectConversation");
	}

}