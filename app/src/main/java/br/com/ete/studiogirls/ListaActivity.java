package br.com.ete.studiogirls;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView listView;
    AdapterServicos adp;
    Conexao conn;
    ActionBar actionBar;
    ServicosController pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Lista de Servicos");

        actionBar.setSubtitle("Lista salva em SQLITE");

        actionBar.setDisplayHomeAsUpEnabled(true);

        pc = new ServicosController(getBaseContext());

        listView = findViewById(R.id.lista);
        listView.setTextFilterEnabled (true);

        preencheLista();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();

                return true;

        }
        return true;
    }

    public void preencheLista(){

        listView.setAdapter(null);

        //qtd = listItemCliente.size();

        adp = new AdapterServicos(this,pc.retornar());
        listView.setAdapter(adp);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        Pessoa pessoa = adp.getItem(arg2);
        pessoa.getNome();

        Snackbar snackbar = Snackbar
                .make(listView,  pessoa.getNome(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
}
