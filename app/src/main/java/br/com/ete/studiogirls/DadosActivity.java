package br.com.ete.studiogirls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import br.com.ete.studiogirls.model.Servico;

public class DadosActivity extends AppCompatActivity {

    Conexao conn;
    EditText editTextTime, editTextName;
    CalendarView calendarView;
    TextView tvServico;
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        conn = new Conexao(this);
        SQLiteDatabase db = conn.getReadableDatabase();

        Intent i = getIntent();


        tvServico = findViewById(R.id.textViewServico);
        editTextName = findViewById(R.id.editTextName);
        editTextTime = findViewById(R.id.editTextTime);
        calendarView = findViewById(R.id.calendarView);

        tvServico.setText(i.getStringExtra("servico"));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                //String curDate = String.valueOf(dayOfMonth)+'/'+String.valueOf(month)+'/'+String.valueOf(year);

                Calendar  calendar = Calendar.getInstance();
                calendar.set( year,month,dayOfMonth);
                Date sDate = calendar.getTime();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                data = dateFormat.format(sDate);


            }
        });

    }



        public void servicos(View v) {

        if(data.equals("")){
            Toast.makeText(this, "Escolha uma data", Toast.LENGTH_SHORT).show();
        }else if (editTextTime.getText().toString().equals("")) {
            Toast.makeText(this, "Preencha a hora", Toast.LENGTH_SHORT).show();
        } else  if (editTextName.getText().toString().equals("")) {
                Toast.makeText(this, "Preencha seu nome", Toast.LENGTH_SHORT).show();
            } else {

            Servico servico = new Servico();
            servico.setServico(tvServico.getText().toString());
            servico.setCliente(editTextName.getText().toString());
            servico.setData(data+' '+editTextTime.getText().toString());


            conn.inserirServicos(servico);

            Toast.makeText(this, "Agendado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}