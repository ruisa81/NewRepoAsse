package uk.ac.uof.i2p.coms;

//I dont know if this is usefull !
import java.util.ArrayList;
import java.util.List;

public interface Tasks {

	void addTask(Task task);

	void addTask(String content);

	Task getOpenTask();

	List <Task> tasks = new ArrayList<>();


}
