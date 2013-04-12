package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EscolhaPizza extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolha_pizza);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.escolha_pizza, menu);
		return true;
	}

}
