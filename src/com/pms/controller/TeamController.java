package com.pms.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.form.Inbox;
import com.pms.form.Member;
import com.pms.form.Team;
import com.pms.form.User;
import com.pms.services.InboxService;
import com.pms.services.MemberService;
import com.pms.services.TeamService;
import com.pms.services.UserService;

@Controller
public class TeamController {

	@Autowired
	TeamService teamService;

	@Autowired
	UserService userService;

	@Autowired
	MemberService memberService;

	@Autowired
	InboxService inboxService;

	List<User> memberList = new ArrayList<User>();

	@RequestMapping("/teamCreate")
	public ModelAndView teamCreateView(@ModelAttribute Team team) {
		return new ModelAndView("teamCreate");
	}

	@RequestMapping("/team/Create")
	public String inserTeam(@ModelAttribute Team team, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		String creatorName = userService.getUser(userId).getUserName();
	/*	int creatorId=userService.getUserId(creatorName).getUserId();
		session.setAttribute("creatorId", creatorId);*/
		session.setAttribute("teamCreatorName", creatorName);

		if (team != null) {
			String teamName = team.getTeamName();
			session.setAttribute("teamName", teamName);

			List<Team> teamNameList = teamService.getAllTeamNames();
			if (teamNameList.isEmpty()) {
				teamService.saveTeam(teamName);
				int teamId = teamService.getTeamID(teamName);
				session.setAttribute("teamId", teamId);
				System.out.println("Teamid=" + teamId);
				memberService.saveTeamCreator(userId, teamId);
				
			} else {

				for (Team t : teamNameList) {
					String teamName1 = t.getTeamName().toLowerCase();

					if (teamName1.equals(teamName.toLowerCase())) {
						session.setAttribute("teamNameDuplicate", "Duplicate Team Name");
						System.out.println("Duplicate Team Name.");
						System.out.println(teamName1);
						return "redirect:/teamCreate";
					}
				}
				
				teamService.saveTeam(teamName);
				int teamId = teamService.getTeamID(teamName);
				session.setAttribute("teamId", teamId);
				System.out.println("Teamid=" + teamId);
				memberService.saveTeamCreator(userId, teamId);
			
			}

		}

		return "redirect:/teamusers";
	}


	@RequestMapping("/teamusers")
	public ModelAndView getUserLIst() {
		List<User> userList = userService.getAllUsers();
		for (User e : userList)
			System.out.println("Name:" + e.getUserName());
		return new ModelAndView("teamUserList", "userList", userList);
	}

	@RequestMapping(value = "/savemember/{userId}")
	public String inserMember(@PathVariable int userId, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		int teamId = (Integer) session.getAttribute("teamId");

		List<Member> members = memberService.getAllMembers();		
		List<Integer> list=new ArrayList<Integer>();
		
		for(int j=0;j<members.size();j++){
			if(list.isEmpty()){
				System.out.println("list:"+list);
				list.add(members.get(j).getUserId());
			}
			else if(!list.contains(members.get(j).getUserId())){
				list.add(members.get(j).getUserId());
			}
			else{
				break;
			}
		}
				
		
		for (int i = 0; i < list.size(); i++) {

			if (list.contains(userId)) {
				System.out.println("This user has been added to member list.");
				session.setAttribute("errorMessage", "This user has been added to member list.");
				break;
			}

			else {

				memberService.saveMember(userId);
				inboxService.saveToInbox(userId, teamId);
				User member = userService.getUser(userId);
				memberList.add(member);
				session.setAttribute("errorMessage", "");
				break;

			}

		}

		System.out.println(memberList);
		session.setAttribute("memberNameList", memberList);

		
		/* String inboxDate=((Inbox) inboxService.inboxData(userId)).getInboxDate();
		 session.setAttribute("inboxDate", inboxDate);*/
		 
		return "redirect:/teamusers";

	}

	@RequestMapping("/inbox")
	public ModelAndView inboxView(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		int userId=Integer.parseInt(session.getAttribute("userId").toString());	  	
	  	List<User> inboxData = new ArrayList<User>();
	  	int memberRole=memberService.getMemberRole(userId);
	  	session.setAttribute("memberRole", memberRole);
	  	
		//String teamCreatorId=session.getAttribute("creatorId").toString();
		
	  	if(memberRole==0){
	  			int inviteTeamId=inboxService.getInviteTeamId(userId);
	  			String teamName=teamService.getTeamName(inviteTeamId);
	  			int creator=memberService.getTeamCreator(inviteTeamId);
	  			String teamCreatorName=userService.getUser(creator).getUserName();
				User user = userService.getUser(userId);
				String date=inboxService.getDate(userId);
				
				System.out.println(date);
				inboxData.add(user);
				
				
				session.setAttribute("date", date);
				session.setAttribute("ProjectName","");
				session.setAttribute("teamId", inviteTeamId);
				session.setAttribute("teamName", teamName);
				session.setAttribute("teamCreatorName", teamCreatorName);
			
	  	}
		 
	  	/*else{
	  		
	  		List<Inbox> acceptedUser=inboxService.acceptedUser(teamId);
			User user = userService.getUser(acceptedUser.get(userId).getUserId());
			inboxData.add(user);
	  	}*/
		

		return new ModelAndView("inbox", "inboxData", inboxData);
	}

	@RequestMapping("/access/{userId}/{teamId}")
	public ModelAndView accessAsMember(@PathVariable int userId, @PathVariable int teamId) {
		memberService.accessAsMember(userId, teamId);
		inboxService.access(userId, teamId);
		return new ModelAndView("inbox");
	}

	@RequestMapping("/deny/{userId}")
	public ModelAndView denyAsMember(@PathVariable int userId) {
		memberService.denyAsMember(userId);
		inboxService.deny(userId);
		return new ModelAndView("inbox");
	}
}
