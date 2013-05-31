package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PedidoRealizadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedido_realizado);
		
		Button btnOkPedido = (Button) findViewById(R.id.btnOkPedido);
		btnOkPedido.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				OkPedido();
			}
		});
	}
	
	private void OkPedido()
	{
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
