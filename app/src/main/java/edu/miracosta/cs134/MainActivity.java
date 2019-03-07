package edu.miracosta.cs134;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.miracosta.cs134.model.DBHelper;
import edu.miracosta.cs134.model.Task;

/**
 * MainActivity that lets the user add tasks to the database and displays them. The user can clear
 * the tasks and/or mark them as done too
 *
 * @author Dennis La
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity
{


    private DBHelper mDb;
    private List<Task> mAllTasks;

    private EditText mTaskEditText;
    private ListView mTaskListview;

    private TaskListAdapter mTaskListAdapter;

    /**
     * inflates the layouts
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate (create) the database
        mDb = new DBHelper(this);

        //fill the list with data from the database
        mAllTasks = mDb.getAllTasks();

        mTaskEditText = findViewById(R.id.taskEditText);
        mTaskListview = findViewById(R.id.taskListView);

        //associate the TaskListAdapter with the ListView
        mTaskListAdapter = new TaskListAdapter(this, R.layout.task_item, mAllTasks);
        mTaskListview.setAdapter(mTaskListAdapter);



    }


    /**
     * method triggered when the user clicks the add task button. it will add the task to the
     * database
     * @param v the add task button
     */
    //addTask
    public void addTask(View v)
    {
        String description = mTaskEditText.getText().toString();

        if(description.length() == 0)
        {
            Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Task newTask = new Task(description);

            mAllTasks.add(newTask);

            //put the new task in the database
            mDb.addTask(newTask);

            //notify the list adapter that its changed
            mTaskListAdapter.notifyDataSetChanged();
        }


    }

    /**
     * method triggered by clear all tasks button, will remove all tasks from the list view
     * @param v the clear all button
     */
    public void clearAllTasks(View v)
    {
        mAllTasks.clear();
        mDb.clearAllTasks();

        mTaskListAdapter.notifyDataSetChanged();
    }

    /**
     * updates the isDone boolean in the model and the database
     *
     * @param v the check box
     */
    public void changeTaskStatus(View v)
    {
        int pos = mTaskListview.getPositionForView(v);

        mAllTasks.get(pos).setDone(!mAllTasks.get(pos).isDone());

        mDb.updateTask(mAllTasks.get(pos));


        mTaskListAdapter.notifyDataSetChanged();

    }


    //ctrl + o => override

    /**
     * destroys the app when it is closed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDb.close();
    }

}
