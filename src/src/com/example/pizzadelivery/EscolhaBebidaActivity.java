package com.example.pizzadelivery;

import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class EscolhaBebidaActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	TextView mPrecoBebida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolha_bebida);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pagerBebidas);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				AtualizarInfoBebida();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// nada a ser feito
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// nada a ser feito
			}
		});
		
		// Configura os demais componentes
		mPrecoBebida = (TextView) findViewById(R.id.txtPrecoBebida);
		
		// Configura os botões
		Button btnAdicionarBebida = (Button) findViewById(R.id.btnAdicionarBebida);
		btnAdicionarBebida.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AdicionarBebida();
			}
		});
		
		Button btnFecharPedido = (Button) findViewById(R.id.btnFecharPedido);
		btnFecharPedido.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FecharPedido();
			}
		});

	}
	
	private void AtualizarInfoBebida()
	{
		int id = mViewPager.getCurrentItem();
		double valor = TabelaPrecos.getValorUnitario(TiposPedido.Bebida.getTipoPedido(), id, 0);
		mPrecoBebida.setText(String.format("R$ %.2f", valor));
	}
	
	private void AdicionarBebida()
	{
		Pedido.addItem(TiposPedido.Bebida.getTipoPedido(), mViewPager.getCurrentItem(), 0);
		Toast.makeText(getApplicationContext(), "Bebida adicionada!", Toast.LENGTH_SHORT).show();
	}
	
	private void FecharPedido()
	{
		Intent k = new Intent(this, PedidoActivity.class);
		startActivity(k);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_pedido, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
			case R.id.mnMeuPedido:
				Intent k = new Intent(this, PedidoActivity.class);
				startActivity(k);
				break;
				
			default:
				break;
		}
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return TiposBebidas.getQtdeTipos();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TiposBebidas.values()[position].getNome();
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "idx_bebida_selecionada";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.fragment_escolha_bebida_dummy, container, false);
			
			ImageView imgTipoBebida = (ImageView) rootView.findViewById(R.id.imgTipoBebida);
			TextView txtDescricaoBebida = (TextView) rootView.findViewById(R.id.txtDescricaoBebida);
			imgTipoBebida.setImageResource(getResources().getIdentifier(String.format("bebida%d", getArguments().getInt(ARG_SECTION_NUMBER)), "drawable", "com.example.pizzadelivery"));
			txtDescricaoBebida.setText(TiposBebidas.values()[getArguments().getInt(ARG_SECTION_NUMBER) - 1].getDescricao());
			
			return rootView;
		}
	}

}
