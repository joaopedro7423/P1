package br.unigran.domain;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.unigran.domain.entidades.Abastecida;
import br.unigran.domain.entidades.Carro;


public class AbastecidaBanco  {
    private SQLiteDatabase conn;

    public AbastecidaBanco(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserirAbastecida(Abastecida abas){
        ContentValues values =new ContentValues();
        values.put("tipo",abas.getTipo());
        values.put("qtd",abas.getQtd());
        values.put("preco",abas.getPreco());
        //values.put("id_carro",abas.getId_carro());

        conn.insert("Abastecida",null,values);
    }

    public void atualizarAbas(Abastecida abas){
        ContentValues values =new ContentValues();
        values.put("tipo",abas.getTipo());
        values.put("qtd",abas.getQtd());
        values.put("preco",abas.getPreco());
        values.put("id_carro",abas.getId_carro());
        conn.update("Abastecida",values,"id=?", new String[]{abas.getId().toString()});

    }

    public void excluirAbastecida(Integer id){
        conn.delete("Abastecida","id=?", new String[]{id.toString()});
    }


    public List<Abastecida> getAbastecidas(){
        List<Abastecida> abast = new LinkedList<>();
        Cursor cursor;
        Abastecida abas;
        cursor =conn.rawQuery("SELECT * FROM Abastecida", null);

        cursor.moveToFirst();

        for (int i=0;i<cursor.getCount();i++){
            abas = new Abastecida();

          //  abas.setId(cursor.getInt(cursor.getColumnIndex("id_carro")));
            abas.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            abas.setTipo(cursor.getString(cursor.getColumnIndexOrThrow("tipo")));
            abas.setQtd(cursor.getDouble(cursor.getColumnIndex("qtd")));
            abas.setPreco(cursor.getDouble(cursor.getColumnIndex("preco")));

            abast.add(abas);

            cursor.moveToNext();
        }


        return abast;

    }


    public Abastecida getAbastecida(Integer id){

        Cursor cursor;
        Abastecida abas;
        String sqlSelect = "SELECT * FROM Abastecida where ID = '"+ id +"'";
        cursor =conn.rawQuery(sqlSelect, null);

        cursor.moveToFirst();

        abas = new Abastecida();

        abas.setId(cursor.getInt(cursor.getColumnIndex("ID")));
        abas.setTipo(cursor.getString(cursor.getColumnIndexOrThrow("tipo")));
        abas.setQtd(cursor.getDouble(cursor.getColumnIndex("qtd")));
        abas.setPreco(cursor.getDouble(cursor.getColumnIndex("preco")));


        //cursor.moveToNext();


        return abas;

    }




}
