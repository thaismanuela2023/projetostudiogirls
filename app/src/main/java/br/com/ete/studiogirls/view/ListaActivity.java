package br.com.ete.studiogirls.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import br.com.ete.studiogirls.adapter.AdapterServicos;
import br.com.ete.studiogirls.conexao.Conexao;
import br.com.ete.studiogirls.R;
import br.com.ete.studiogirls.servicosController.ServicosController;
import br.com.ete.studiogirls.model.Servico;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView listView;

    AdapterServicos adp;
    ServicosController sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.lista);
        Intent intent = getIntent();
        sc = new ServicosController(getBaseContext());
        preencheLista();
    }



    public void preencheLista(){

        listView.setAdapter(null);

        //qtd = listItemCliente.size();

        adp = new AdapterServicos(this,sc.retornar());
        listView.setAdapter(adp);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        Servico servico = adp.getItem(arg2);
        servico.getCliente();

        Snackbar snackbar = Snackbar
                .make(listView,  servico.getCliente(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }



}

