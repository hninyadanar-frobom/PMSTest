package com.pms.services;

import java.util.List;

import com.pms.form.Task;

public interface TaskService {
	public List<Task> getTaskId(int memberid);

	public List<Task> getMemberId(int taskid);

	public void UpdateTaskStatus(int taskid);

	public List<Task> getTaskId(int projectid, int memberid);

	public List<Task> getAllTasks();

	public List<Task> getAllTasks1();

	public String getTaskName(int taskid);
}
