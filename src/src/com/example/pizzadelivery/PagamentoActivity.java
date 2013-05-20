package com.example.pizzadelivery;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.google.gson.Gson;

public class PagamentoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		
		RadioGroup radFormaPagamento = (RadioGroup) findViewById(R.id.radFormaPagamento);
		radFormaPagamento.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				AlterarFormaPagamento();
			}
		});
		
		TextView txtEdtValorTotal = (TextView) findViewById(R.id.txtEdtValorTotal);
		txtEdtValorTotal.setText(String.format("%.2f", Pedido.getValorTotal()));
		
		TextView txtEdtTrocoPara = (TextView) findViewById(R.id.txtEdtTrocoPara);
		txtEdtTrocoPara.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				CalcularTroco();
				return false;
			}
		});
		
		TextView txtEdtValorTroco = (TextView) findViewById(R.id.txtEdtValorTroco);
		txtEdtValorTroco.setText(String.format("%.2f", 0.0f));
		
		Button btnPostarPedido = (Button) findViewById(R.id.btnPostarPedido);
		btnPostarPedido.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PostarPedido();
			}
		});
	}
	
	private boolean trocoValido = false;
	
	private void AlterarFormaPagamento()
	{
		RadioButton radPagtoDinheiro = (RadioButton) findViewById(R.id.radPagtoDinheiro);
		View grpTrocoPara = findViewById(R.id.grpTrocoPara);
		View grpValorTroco = findViewById(R.id.grpValorTroco);

		grpTrocoPara.setVisibility(radPagtoDinheiro.isChecked() ? View.VISIBLE : View.GONE);
		grpValorTroco.setVisibility(radPagtoDinheiro.isChecked() ? View.VISIBLE : View.GONE);
		
		if (radPagtoDinheiro.isChecked())
		{
			CalcularTroco();
		}
		else
		{
			trocoValido = true;
		}
	}
	
	private void CalcularTroco()
	{
		try
		{
			double valorTotal = Pedido.getValorTotal(), trocoPara, valorTroco;
			TextView txtEdtTrocoPara = (TextView) findViewById(R.id.txtEdtTrocoPara);
			TextView txtEdtValorTroco = (TextView) findViewById(R.id.txtEdtValorTroco);
			
			trocoPara = Double.parseDouble(txtEdtTrocoPara.getText().toString());
			valorTroco = trocoPara - valorTotal;
			
			txtEdtValorTroco.setText(String.format("%.2f", valorTroco));
			trocoValido = (valorTroco >= 0);
		}
		catch (Exception e)
		{
			trocoValido = false;
		}
	}
	
	private void PostarPedido()
	{	
		if (trocoValido == false)
		{
			Toast.makeText(getApplicationContext(), "Valor de troco inv�lido!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		Thread t = new Thread()
		{
            public void run()
            {
                Looper.prepare();
                HttpClient client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                HttpResponse response;
        		Gson gson = new Gson();
        		String json = gson.toJson(Pedido.getMeuPedido());

                try
                {
                    HttpPost post = new HttpPost("http://www.fmoliveira.com.br/PizzaService/api/pedido");
                    StringEntity se = new StringEntity( json );
                    se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    post.setEntity(se);
                    response = client.execute(post);

                    /*Checking response */
                    if (response != null)
                    {
                        InputStream in = response.getEntity().getContent(); //Get the data in the entity
                    }
                    
                    Toast.makeText(getApplicationContext(), "Pedido realizado com sucesso!", Toast.LENGTH_SHORT).show();

                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Falha ao postar pedido!", Toast.LENGTH_SHORT).show();
                }

                Looper.loop(); //Loop in the message queue
            }
        };

        t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.pagamento, menu);
		return true;
	}

}
