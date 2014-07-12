package com.example.adapters;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Subcategory extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_subcategory);
		String[] clothes={"jeans","top","underwear"};
		String[] footwear={"ankle shoes","studs","spikes","running"};
		String[] electronics={"mobile","laptop","washing machine"};
		String[] jwellry={"bangles","necklace"};
		String[] assign={};
		Intent intent=getIntent();
		int value=getIntent().getIntExtra("sub", 0);
		
		switch(value)
		{
		case 0: assign=clothes;
				break;
		case 1:assign=footwear;
				break;
		case 2:assign=electronics;
				break;
		case 3:assign=jwellry;
				break;
		}
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,assign);
		
		setListAdapter(adapter1);
	
		
	
	
	
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}