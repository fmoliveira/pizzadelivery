package com.example.pizzadelivery;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PedidoActivity extends Activity {
	
	private static TiposPedido mUltimaTela = TiposPedido.Pizza;
	private ListView mLstPedidos = null;
	
	public static void setUltimaTela(TiposPedido p)
	{
		mUltimaTela = p;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedido);
		ExibirPedido();
		
		/* Configura as ações dos botões */
		Button btnMaisPizza = (Button) findViewById(R.id.btnMaisPizza);
		btnMaisPizza.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MaisPizza();				
			}
		});

		Button btnMaisBebida = (Button) findViewById(R.id.btnMaisBebida);
		btnMaisBebida.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MaisBebida();				
			}
		});

		Button btnCheckout = (Button) findViewById(R.id.btnCheckout);
		btnCheckout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Checkout();				
			}
		});
	}
	
	@Override
	public void onBackPressed()
	{
		Intent k = null;
		
		if (mUltimaTela == TiposPedido.Pizza)
		{
			k = new Intent(this, EscolhaPizzaActivity.class);
		}
		else if (mUltimaTela == TiposPedido.Bebida)
		{
			k = new Intent(this, EscolhaBebidaActivity.class);
		}
		
		if (k != null)
		{
			startActivity(k);
		}
		
		this.finish();
	}
	
	private void MaisPizza()
	{
		Intent k = new Intent(this, EscolhaPizzaActivity.class);
		startActivity(k);
		this.finish();
	}
	
	private void MaisBebida()
	{
		Intent k = new Intent(this, EscolhaBebidaActivity.class);
		startActivity(k);
		this.finish();
	}
	
	private void Checkout()
	{
		Intent k = new Intent(this, EnderecoActivity.class);
		startActivity(k);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.pedido, menu);
		return true;
	}
	
	private void EditarItem(int position)
	{
		final ItemPedido item = (ItemPedido) mLstPedidos.getItemAtPosition(position);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Editar Item");
		builder.setMessage(String.format("%dx %s", item.getQuantidade(), item.getDescricao()));
		
		builder.setNegativeButton("Editar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				EditarItem(item);
			}
		});
		
		builder.setNeutralButton("Remover", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				RemoverItem(item);
			}
		});

		builder.setPositiveButton("Cancelar", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	private void EditarItem(final ItemPedido item)
	{
		final EditText input = new EditText(this);
		input.setInputType(InputType.TYPE_CLASS_NUMBER);
		input.setText(String.format("%d", item.getQuantidade()));
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Editar Quantidade");
		builder.setMessage(String.format("%dx %s", item.getQuantidade(), item.getDescricao()));
		builder.setView(input);
		
		builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Pedido.alterarItem(item, Integer.parseInt(input.getText().toString()));
				ExibirPedido();
			}
		});

		builder.setNegativeButton("Cancelar", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	private void RemoverItem(ItemPedido item)
	{
		Pedido.removerItem(item);
		ExibirPedido();
	}
	
	private void ExibirPedido()
	{
		mLstPedidos = (ListView) findViewById(R.id.lstPedido);
		AdapterListaPedidos adapter = new AdapterListaPedidos(this, Pedido.getMeuPedido());
		mLstPedidos.setAdapter(adapter);
		
		mLstPedidos.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	EditarItem(position);
            }
        });
		
		TextView txtNenhumItem = (TextView) findViewById(R.id.txtNenhumItem);
		txtNenhumItem.setVisibility((mLstPedidos.getCount() != 0) ? View.GONE : View.VISIBLE);
		
		TextView txtValorTotal = (TextView) findViewById(R.id.txtValorTotal);
		txtValorTotal.setText(String.format("%.2f", Pedido.getValorTotal()));
	}

}
