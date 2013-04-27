package com.example.pizzadelivery;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
	
	private List<String> GetItensPedido()
	{
		String[] sabores = getResources().getStringArray(R.array.nomes_pizzas);
		List<Pizza> lista = Pedido.getPedido().getPizzas();
		List<String> ret = new ArrayList<String>();
		Pizza p;
		String s;
		
		for (int i = 0; i < lista.size(); i++)
		{
			p = lista.get(i);
			s = String.format("%dx %s (%s)", p.getQuantidade(), sabores[p.getId()], p.getTamanho() == 0 ? "grande" : "gigante");
			ret.add(s);
		}
		
		return ret;
	}
	
	private void ExibirPedido()
	{
		ListView lstPedidos = (ListView) findViewById(R.id.lstPedido);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.item_pedido, GetItensPedido());
		lstPedidos.setAdapter(listAdapter);
	}

}
