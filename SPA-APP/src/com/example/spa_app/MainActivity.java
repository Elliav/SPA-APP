package com.example.spa_app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
<<<<<<< HEAD
		int i = 0 ;
		return true;
		//sisisisisisisisisi
=======
		return true;
>>>>>>> refs/remotes/origin/test
	}

}
