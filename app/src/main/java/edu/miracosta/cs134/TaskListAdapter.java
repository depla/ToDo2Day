package edu.miracosta.cs134;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;

import edu.miracosta.cs134.model.Task;

public class TaskListAdapter extends ArrayAdapter<Task>
{
    private Context mContext;
    private int mResourceId;
    private List<Task> mAllTasks;


    public TaskListAdapter( Context context, int resource, List<Task> objects) {
        super(context, resource, objects);

        mContext = context;
        mResourceId = resource;
        mAllTasks = objects;


    }


    //override the getView method

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        // for each task in the list, inflate its view
        Task focusedTask = mAllTasks.get(position);

        //create a layout inflator
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(mResourceId, null);

        CheckBox isDoneCheckBox = view.findViewById(R.id.isDoneCheckBox);
        isDoneCheckBox.setChecked(focusedTask.isDone());
        isDoneCheckBox.setText(focusedTask.getDescription());

        return view;


    }
}
