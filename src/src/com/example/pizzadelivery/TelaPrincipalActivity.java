package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class TelaPrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);
		
		findViewById(R.id.btnFazerPedido).setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						FazerPedido();
					}
				});
		
		findViewById(R.id.btnSair).setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						finish();
					}
				});
	}
	
	private void FazerPedido()
	{
		Intent k = new Intent(this, EscolhaPizzaActivity.class);
		startActivity(k);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.tela_principal, menu);
		return true;
	}

}
