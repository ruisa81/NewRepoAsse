package uk.ac.uof.i2p.coms;

//I dont know if this is usefull !
import java.util.Collection;

public interface Tasks {

	void addTask(Task task);

	void addTask(String content);

	Task getOpenTask();

	boolean createFileTask(Task task);

	Collection<Task> getActiveTasks();

}
