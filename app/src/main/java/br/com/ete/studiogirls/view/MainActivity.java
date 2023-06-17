package br.com.ete.studiogirls.view;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ete.studiogirls.conexao.Conexao;
import br.com.ete.studiogirls.R;
import br.com.ete.studiogirls.model.Servico;

public class MainActivity extends AppCompatActivity {


    Conexao conn;
    EditText editTextPhone,getEditTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getEditTextNome = findViewById(R.id.editTextNome);
        editTextPhone = findViewById(R.id.editTextPhone);


        conn = new Conexao(this);
        SQLiteDatabase db = conn.getReadableDatabase();
    }

    public void logar(View v){

        if(getEditTextNome.getText().toString().equals("")){
            Toast.makeText(this, "Preencha seu nome", Toast.LENGTH_SHORT).show();
        }else if(editTextPhone.getText().toString().equals("")){
            Toast.makeText(this, "Preencha seu número de telefone", Toast.LENGTH_SHORT).show();
        }else{
            Servico servico = new Servico();

        }

    }

}