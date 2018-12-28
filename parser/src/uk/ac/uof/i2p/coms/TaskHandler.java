package uk.ac.uof.i2p.coms;

import java.util.*;

public class TaskHandler implements Tasks {

	public List<Task> taskList;

	@Override
	public void addTask(Task task) {
		this.taskList.add(task);
	}

	@Override
	public void addTask(String content) {

	}

	@Override
	public Task getOpenTask() {

		return null;
	}



	@Override
	public Collection<Task> getActiveTasks() {
		return null;
	}
}
