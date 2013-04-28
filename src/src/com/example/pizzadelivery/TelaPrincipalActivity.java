package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TelaPrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);
		
		Button btnFazerPedido = (Button) findViewById(R.id.btnFazerPedido);
		if (btnFazerPedido != null)
		{
			btnFazerPedido.setOnClickListener(
					new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							FazerPedido();
						}
					});
		}
		
		Button btnSair = (Button) findViewById(R.id.btnSair);
		if (btnSair != null)
		{
			btnSair.setOnClickListener(
					new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							finish();
						}
					});
		}
	}
	
	private void FazerPedido()
	{
		Pedido.resetarPedido();
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
