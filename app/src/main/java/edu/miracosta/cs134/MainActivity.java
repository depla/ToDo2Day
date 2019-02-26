package edu.miracosta.cs134;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.miracosta.cs134.model.DBHelper;

public class MainActivity extends AppCompatActivity {


    private DBHelper mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate (create) the database
        mDb = new DBHelper(this);





    }


    //ctrl + o => override
    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDb.close();
    }
}
