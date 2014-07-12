package com.example.adapters;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		String[] values={"Clothes","Footwear","Electronics","Jwellery"};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1,values);
		setListAdapter(adapter);
	}
		public void onListItemClick(ListView l, View v, int position, long id) {
			String item=(String) getListAdapter().getItem(position);
			Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(this,Subcategory.class);
			intent.putExtra("sub", position);
			startActivity(intent);
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
