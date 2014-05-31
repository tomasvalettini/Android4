package com.example.todolist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment
{
	private OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.new_item_fragment, container, false);
		final EditText myEditText = (EditText) view.findViewById(R.id.myEditText);
		
		myEditText.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				// TODO Auto-generated method stub
			}
			
			@Override
			public void afterTextChanged(Editable s)
			{
				String newItem = s.toString();
				Pattern p = Pattern.compile(".+\n");
				Matcher m = p.matcher(newItem);
				
				if (m.find())
				{
					onNewItemAddedListener.onNewItemAdded(newItem);
					myEditText.setText("");
				}
			}
		});
		
		return view;
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		
		try
		{
			onNewItemAddedListener = (OnNewItemAddedListener)activity;
		}
		catch (ClassCastException e)
		{
			throw new ClassCastException(activity.toString() + " must implement OnNewItemAddedListener");
		}
	}
}