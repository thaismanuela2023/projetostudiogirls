package br.com.ete.studiogirls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ete.studiogirls.model.Servico;

public class ServicosActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);


    }

    public void cabelos(View v){
        registraServico("CABELO");
    }

    public void manicure(View v){
        registraServico("MANICURE");
    }

    public void ds(View v){
        registraServico("SOBRANCELHA");
    }
    public void pe(View v){
        registraServico("PEDICURE");
    }

    public void registraServico(String servico){

        Intent i = new Intent(getBaseContext(),DadosActivity.class);
        i.putExtra("servico",servico);
        startActivity(i);
    }



    }


