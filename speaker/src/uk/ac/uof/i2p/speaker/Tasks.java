package uk.ac.uof.i2p.speaker;

import java.util.Collection;

public interface Tasks {
    void addTask(Task task);
    void addTask(String content);
    void getTask();

    Collection <Task> getActiveTasks();

}
//todo write task handler