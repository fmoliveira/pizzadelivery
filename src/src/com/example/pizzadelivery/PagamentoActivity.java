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

import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;

public class PagamentoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		
		TextView txtEdtValorTotal = (TextView) findViewById(R.id.txtEdtValorTotal);
		txtEdtValorTotal.setText(String.format("%.2f", Pedido.getValorTotal()));
		
		Button btnPostarPedido = (Button) findViewById(R.id.btnPostarPedido);
		btnPostarPedido.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PostarPedido();
			}
		});
	}
	
	private void PostarPedido()
	{	
		Thread t = new Thread() {

            public void run() {
                Looper.prepare(); //For Preparing Message Pool for the child Thread
                HttpClient client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                HttpResponse response;
        		Gson gson = new Gson();
        		String json = gson.toJson(Pedido.getMeuPedido());

                try {
                    HttpPost post = new HttpPost("http://www.fmoliveira.com.br/PizzaService/api/pedido");
                    StringEntity se = new StringEntity( json );
                    se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    post.setEntity(se);
                    response = client.execute(post);

                    /*Checking response */
                    if(response!=null){
                        InputStream in = response.getEntity().getContent(); //Get the data in the entity
                    }
                    
                    Toast.makeText(getApplicationContext(), "Pedido enviado com sucesso!", Toast.LENGTH_SHORT);

                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
//                    Toast.makeText(getApplicationContext(), "Erro ao postar pedido!", Toast.LENGTH_SHORT);
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
