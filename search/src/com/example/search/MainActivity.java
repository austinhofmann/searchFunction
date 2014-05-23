package com.example.search;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        

		final String[] strArray = {"a", "ab", "abc", "abcdefghijklmn", "aa", "acb", "ad", "adb", "e", "eb", "f", "fb", "g", "gb", "h", "hb", "i", "ib", "j", "jb", "k", "kb"};
		final EditText searchBar = (EditText) findViewById(R.id.searchbar);
		Button enter = (Button) findViewById(R.id.enter);
		
		
		enter.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{

				String searchString = searchBar.getText().toString();
				int resultCounter = 0;
				int searchResultsCounter = 0;
		
		
				for(int i = 0; i < strArray.length; i++){
					
					if(searchString.equals(strArray[i])){
						searchNow(strArray[i]);
						break;
					}
					
					if(i == strArray.length - 1){
						for(int l = 0; l < strArray.length; l++){
							if(searchString.charAt(0) == strArray[l].charAt(0)){
								searchResultsCounter++;
							}
						}
						String[] searchResults = new String[searchResultsCounter];
						for(int j = 0; j < strArray.length; j++){
							if(searchString.charAt(0) == strArray[j].charAt(0)){
								searchResults[resultCounter] = strArray[j];
								resultCounter++;
							}
						}
						searchPage(searchResults);	
					}
					
				}
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void searchNow(String a){
		//go to new page with information regarding string a.
	}
	
	public void searchPage(String[] a){
		//go to new page with search results from the string array
		Intent intent = new Intent(this, SearchPage.class);
        intent.putExtra("strings", a);
        startActivity(intent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
