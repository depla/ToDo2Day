package edu.miracosta.cs134.model;

/**
 * Task class to represent a task which has an id, description and is done boolean
 *
 * @author Dennis La
 * @version 1.0
 */
public class Task
{
    //declare the instance variables

    private long mId;
    private String mDescription;
    private boolean mIsDone;

    /**
     * full constructor
     * @param id id of task
     * @param description what the task is
     * @param isDone if the task is done
     */
    public Task(long id, String description, boolean isDone) {
        mId = id;
        mDescription = description;
        mIsDone = isDone;
    }

    /**
     * what the user creates using just the description
     * @param description what the task is
     */
    public Task(String description) {

        this(-1, description, false);
    }

    /**
     * returns the id of the task
     * @return the id
     */
    public long getId() {
        return mId;
    }

    /**
     * sets the id of the task
     * @param id the id
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * returns the description of the task
     * @return the string description
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * sets the description of the task
     * @param description what the task is
     */
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * returns the boolean flag of whether or not the task is done
     * @return
     */
    public boolean isDone() {
        return mIsDone;
    }

    /**
     * set the boolean flag of whether or not the task is done
     * @param done
     */
    public void setDone(boolean done) {
        mIsDone = done;
    }

    /**
     * gives the user the information about the instance variables about a task
     * @return the string of the instance variables
     */
    @Override
    public String toString() {
        return "Task{" +
                "Id=" + mId +
                ", Description='" + mDescription + '\'' +
                ", IsDone=" + mIsDone +
                '}';
    }
}
