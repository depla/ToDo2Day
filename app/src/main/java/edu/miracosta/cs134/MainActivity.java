package edu.miracosta.cs134;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import edu.miracosta.cs134.model.DBHelper;
import edu.miracosta.cs134.model.Task;

public class MainActivity extends AppCompatActivity {


    private DBHelper mDb;
    private List<Task> mAllTasks;

    private EditText mTaskEditText;
    private ListView mTaskListview;
    private TaskListAdapter mTaskListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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


    //addTask
    public void addTask(View v)
    {
        String description = mTaskEditText.getText().toString();
        Task newTask = new Task(description);

        //put the new task in the database
        mDb.addTask(newTask);

        //notify the list adapter that its changed
        mTaskListAdapter.notifyDataSetChanged();
    }


    //ctrl + o => override
    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDb.close();
    }
}
