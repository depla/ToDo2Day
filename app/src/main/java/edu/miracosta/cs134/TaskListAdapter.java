package edu.miracosta.cs134;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

import edu.miracosta.cs134.model.Task;

/**
 * Adapter class that will inflate the custom list view for the tasks
 *
 * @author Dennis La
 * @version 1.0
 */
public class TaskListAdapter extends ArrayAdapter<Task>
{
    private Context mContext;
    private int mResourceId;
    private List<Task> mAllTasks;


    /**
     * constructor
     * @param context where the adapter will be used
     * @param resource the layout it will use
     * @param objects the list of tasks
     */
    public TaskListAdapter( Context context, int resource, List<Task> objects) {
        super(context, resource, objects);

        mContext = context;
        mResourceId = resource;
        mAllTasks = objects;


    }


    //override the getView method

    /**
     * inflates the custom view layouts for the list view
     * @param position position of the list view item
     * @param convertView
     * @param parent parent view of the list view
     * @return the custom list view item
     */
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
