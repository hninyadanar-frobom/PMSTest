package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.TaskDao;
import com.pms.form.Task;

public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskdao;

	public List<Task> getTaskId(int projectid, int memberid) {
		return taskdao.getTaskId(projectid, memberid);

	}

	public List<Task> getTaskId(int memberid) {
		return taskdao.getTaskId(memberid);
	}

	public List<Task> getMemberId(int taskid) {
		return taskdao.getMemberId(taskid);
	}

	public void UpdateTaskStatus(int taskid) {
		taskdao.UpdateTaskStatus(taskid);
	}

	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskdao.getAllTasks();
	}

	public List<Task> getAllTasks1() {
		return taskdao.getAllTasks1();
	}

	@Override
	public String getTaskName(int taskid) {

		return taskdao.getTaskName(taskid);
	}

}
