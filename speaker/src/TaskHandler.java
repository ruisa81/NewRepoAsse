import uk.ac.uof.i2p.speaker.Task;
import uk.ac.uof.i2p.speaker.Tasks;

import java.util.*;

public class TaskHandler implements Tasks {

    public List <Task> taskList;

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
    public boolean createFileTask(Task task) {
        return false;
    }

    @Override
    public Collection<Task> getActiveTasks() {
        return null;
    }
}
