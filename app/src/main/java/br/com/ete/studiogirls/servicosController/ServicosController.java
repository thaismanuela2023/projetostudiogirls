package br.com.ete.studiogirls.servicosController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.com.ete.studiogirls.conexao.Conexao;
import br.com.ete.studiogirls.model.Servico;

public class ServicosController {


    private SQLiteDatabase db;
    private Conexao conexao;

    public ServicosController(Context context){
        conexao = new Conexao(context);
    }

    public ArrayList<Servico> retornar() {

        Cursor c = null;
        ArrayList<Servico> servicos = new ArrayList<Servico>();

        try {
            c = conexao.getReadableDatabase().
                    rawQuery("select * from agendamento order by id desc", null);

            while (c.moveToNext()) {
                Servico p = new Servico();
                p.setServico(c.getString(c.getColumnIndexOrThrow("servicos")));
                p.setData(c.getString(c.getColumnIndexOrThrow("data")));
                p.setCliente(c.getString(c.getColumnIndexOrThrow("cliente")));
                servicos.add(p);

            }
        }catch (Exception e){

        }
        finally {
            c.close();
        }


        return servicos;
    }


    public void inserir(Servico servico) {
        try {
            ContentValues valores = new ContentValues();

            valores.put("data", servico.getData());
            valores.put("servicos", servico.getServico());
            valores.put("cliente", servico.getCliente());


            conexao.getWritableDatabase().insert("agendamento",
                    null, valores);

        } catch (SQLException ex) {
            Log.e("ERRO", ex.getMessage());

        }

    }


    public Cursor excluir(String id){

        Cursor cursor = conexao.getWritableDatabase().
                rawQuery("delete from servico where id = "+id,null);
        cursor.moveToFirst();
        return cursor;
    }




}

