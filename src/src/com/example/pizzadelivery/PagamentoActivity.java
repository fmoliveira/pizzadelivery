package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class PagamentoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		
		TextView txtEdtValorTotal = (TextView) findViewById(R.id.txtEdtValorTotal);
		txtEdtValorTotal.setText(String.format("%.2f", Pedido.getValorTotal()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.pagamento, menu);
		return true;
	}

}
