package com.example.todolist;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity implements OnNewItemAddedListener
{
	private ArrayAdapter<String> aa;
	private ArrayList<String> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get references to the Fragments
        FragmentManager fm = getSupportFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);
        
        // Create the array list of to do items
        todoItems = new ArrayList<String>();
        
        // Create the array adapter to bind the array to the listview
        aa = new ArrayAdapter<String>(this, R.layout.todolist_item, todoItems);
        
        // Bind the array adapter to the listview.
        todoListFragment.setListAdapter(aa);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        if (id == R.id.action_settings)
        {
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }

    public void onNewItemAdded(String newItem)
    {
    	todoItems.add(newItem);
    	aa.notifyDataSetChanged();
    }
}