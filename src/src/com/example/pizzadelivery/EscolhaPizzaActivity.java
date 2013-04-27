package com.example.pizzadelivery;

import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class EscolhaPizzaActivity extends FragmentActivity {

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
	RadioGroup mTamanhoPizza;
	TextView mPrecoPizza;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolha_pizza);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				AtualizarInfoPizza();
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
		mTamanhoPizza = (RadioGroup) findViewById(R.id.radTamanhoPizza);
		mPrecoPizza = (TextView) findViewById(R.id.txtPrecoPizza);
		
		// Configura o listener do tamanho da pizza
		mTamanhoPizza.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				AtualizarInfoPizza();
			}
		});
		
		// Configura os botões
		Button btnAdicionarPizza = (Button) findViewById(R.id.btnAdicionarPizza);
		btnAdicionarPizza.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AdicionarPizza();
			}
		});
	}
	
	private void AtualizarInfoPizza()
	{
		int[] precos = (mTamanhoPizza.getCheckedRadioButtonId() == R.id.tam_pizza_grande) ? getResources().getIntArray(R.array.precos_pizzas_grandes) : getResources().getIntArray(R.array.precos_pizzas_gigantes);
		mPrecoPizza.setText(String.format("R$ %d,00", precos[mViewPager.getCurrentItem()]));
	}
	
	private void AdicionarPizza()
	{
		Pedido.addPizza(mViewPager.getCurrentItem(), (mTamanhoPizza.getCheckedRadioButtonId() == R.id.tam_pizza_grande) ? 0 : 1);
		Intent k = new Intent(this, PedidoActivity.class);
		startActivity(k);
		Toast.makeText(getApplicationContext(), "Pizza adicionada!", Toast.LENGTH_SHORT).show();
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
			return getResources().getStringArray(R.array.descricoes_pizzas).length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			String[] nomes = getResources().getStringArray(R.array.nomes_pizzas);
			return nomes[position].toUpperCase(l);
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
		public static final String ARG_SECTION_NUMBER = "idx_pizza_selecionada";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_escolha_pizza_dummy, container, false);
			
			ImageView imgSaborPizza = (ImageView) rootView.findViewById(R.id.imgSaborPizza);
			TextView txtDescricaoPizza = (TextView) rootView.findViewById(R.id.txtDescricaoPizza);
			
			imgSaborPizza.setImageResource(getResources().getIdentifier(String.format("pizza%d", getArguments().getInt(ARG_SECTION_NUMBER)), "drawable", "com.example.pizzadelivery"));
			
			String[] descricoes = getResources().getStringArray(R.array.descricoes_pizzas);
			txtDescricaoPizza.setText(descricoes[(getArguments().getInt(ARG_SECTION_NUMBER) - 1)]);
			
			return rootView;
		}
	}

}
