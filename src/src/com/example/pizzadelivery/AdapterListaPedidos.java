package com.example.pizzadelivery;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class AdapterListaPedidos extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<ItemPedido> mItensPedido;
	
	public AdapterListaPedidos(Context context, List<ItemPedido> itens)
	{
		this.mInflater = LayoutInflater.from(context);
		this.mItensPedido = itens;
	}
	
	@Override
	public int getCount() {
		return mItensPedido.size();
	}

	@Override
	public Object getItem(int position) {
		return mItensPedido.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent)
	{
		ItemSuporte itemHolder;
		
		if (view == null)
		{
			view = mInflater.inflate(R.layout.item_pedido, null);
			itemHolder = new ItemSuporte();
			itemHolder.txtQuantidade = (TextView) view.findViewById(R.id.txtQuantidade);
			itemHolder.txtItemPedido = (TextView) view.findViewById(R.id.txtItemPedido);
			itemHolder.txtSubtotal = (TextView) view.findViewById(R.id.txtSubtotal);
			view.setTag(itemHolder);
		}
		else
		{
			itemHolder = (ItemSuporte) view.getTag();
		}
		
		ItemPedido item = mItensPedido.get(position);
		itemHolder.txtQuantidade.setText(String.format("%dx", item.getQuantidade()));
		itemHolder.txtItemPedido.setText(item.getDescricao());
		itemHolder.txtSubtotal.setText(String.format("%.2f", item.getSubtotal()));
		
		return view;
	}
	
}
