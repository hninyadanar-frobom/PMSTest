package com.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.form.Member;
import com.pms.form.Project;
import com.pms.form.Task;
import com.pms.form.User;
import com.pms.services.MemberServiceImpl;
import com.pms.services.ProjectServiceImpl;
import com.pms.services.TaskServiceImpl;
import com.pms.services.UserServiceImpl;

@Controller
public class TaskController extends HttpServlet {
	@Autowired
	TaskServiceImpl taskService;
	@Autowired
	MemberServiceImpl memberService;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	ProjectServiceImpl projectService;

	@RequestMapping("/taskView")
	public ModelAndView viewTask() {
		return new ModelAndView("taskHomePage");
	}

	@RequestMapping("/remainingTask")
	public void getRemainingTaskList(@ModelAttribute Task task, HttpServletRequest request) {

		List<Task> taskList = taskService.getAllTasks();
		request.getSession().setAttribute("taskList", taskList);

		List<User> user1 = new ArrayList<User>();

		for (Task t1 : taskList) {
			int projectid = t1.getProjectid();
			int memberid = t1.getMemberid();

			List<Member> mlist = memberService.getUseridByProjIdAndMemid(projectid, memberid);

			for (Member m : mlist) {
				int userid = m.getUserId();

				List<User> ulist = userService.getUserNameByUserId(userid);
				user1.addAll(ulist);

			}
		}
		request.getSession().setAttribute("userList", user1);
	}

	@RequestMapping("/completeTask")
	public void getCompleteTaskList(@ModelAttribute Task task, HttpServletRequest request) {
		List<Task> taskList = taskService.getAllTasks1();
		request.getSession().setAttribute("taskList", taskList);

		List<User> user1 = new ArrayList<User>();

		for (Task t1 : taskList) {
			int projectid = t1.getProjectid();
			int memberid = t1.getMemberid();

			List<Member> mlist = memberService.getUseridByProjIdAndMemid(projectid, memberid);

			for (Member m : mlist) {
				int userid = m.getUserId();

				List<User> ulist = userService.getUserNameByUserId(userid);
				user1.addAll(ulist);

			}
		}
		request.getSession().setAttribute("userList", user1);

	}

	@RequestMapping("/allTask")
	public void getAllTaskList(@ModelAttribute Task task, HttpServletRequest request) {

		List<Task> taskList = taskService.getAllTasks();
		request.getSession().setAttribute("taskList", taskList);

		List<User> user1 = new ArrayList<User>();

		for (Task t1 : taskList) {
			int projectid = t1.getProjectid();
			int memberid = t1.getMemberid();

			List<Member> mlist = memberService.getUseridByProjIdAndMemid(projectid, memberid);

			for (Member m : mlist) {
				int userid = m.getUserId();

				List<User> ulist = userService.getUserNameByUserId(userid);
				user1.addAll(ulist);

			}
		}
		request.getSession().setAttribute("userList", user1);

	}

	@RequestMapping("/checktaskstatus/{taskid}")
	public String Check(@PathVariable int taskid) {

		taskService.UpdateTaskStatus(taskid);
		return "redirect:/allTask";
	}

	@RequestMapping("/myTask")
	public ModelAndView getMyTask(@ModelAttribute Task task1, HttpServletRequest request) {
		List<User> userList = userService.getAllUsers();
		List<Member> memberList = memberService.getAllMembers();
		List<User> uresult = new ArrayList<User>();
		List<Task> taskresult = new ArrayList<Task>();
		List<Task> taskresult1 = new ArrayList<Task>();
		int userid = 1115;
		for (Member m : memberList) {
			int uid = m.getUserId();
			if (m.getUserId() == userid) {
				int projectid = m.getProjectId();
				int memberid = m.getMemberId();
				List<Task> tresult = taskService.getTaskId(projectid, memberid);
				taskresult.addAll(tresult);
			}
		}
		for (Task t : taskresult) {
			String taskname = taskService.getTaskName(t.getTaskid());
			taskresult1.add(t);
		}
		if (taskresult1.isEmpty()) {
			request.getSession().setAttribute("error", "You have no task.");
		}
		return new ModelAndView("myTask", "taskresult1", taskresult1);
	}

	@RequestMapping("/deleteProjectList")
	public ModelAndView deleteProjectList(@ModelAttribute Project project, HttpServletRequest request) {

		List<Project> projectList = projectService.getAllProjects();
		request.getSession().setAttribute("projectList", projectList);
		return new ModelAndView("deleteProject", "projectList", projectList);

	}

	@RequestMapping("/delete/{projectid}")
	public String deleteProject(@PathVariable int projectid, HttpServletRequest request) {

		List<Member> mem = memberService.getProjectMemberRole(projectid);

		for (Member m : mem) {
			int projectmemberrole = m.getProjectMemberRole();
			if (projectmemberrole == 1) {
				projectService.deleteProject(projectid);
			} else {

				request.getSession().setAttribute("error", "You cannot delete.");

			}
		}

		return "redirect:/deleteProjectList";
	}

}