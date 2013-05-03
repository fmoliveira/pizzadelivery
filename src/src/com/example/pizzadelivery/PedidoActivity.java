package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class PedidoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedido);
		ExibirPedido();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.pedido, menu);
		return true;
	}
	
	private void ExibirPedido()
	{
		ListView lstPedidos = (ListView) findViewById(R.id.lstPedido);
		AdapterListaPedidos adapter = new AdapterListaPedidos(this, Pedido.getMeuPedido());
		lstPedidos.setAdapter(adapter);
		
		TextView txtValorTotal = (TextView) findViewById(R.id.txtValorTotal);
		txtValorTotal.setText(String.format("%.2f", Pedido.getValorTotal()));
	}

}
