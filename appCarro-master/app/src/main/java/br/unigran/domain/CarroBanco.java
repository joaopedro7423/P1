package br.unigran.domain;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.unigran.domain.entidades.Carro;

public class CarroBanco {

private SQLiteDatabase conn;

public CarroBanco(SQLiteDatabase conn){
    this.conn = conn;
}
    public void inserirCarro(Carro veiculo){
        ContentValues values =new ContentValues();
        values.put("nome",veiculo.getNome());
        values.put("placa",veiculo.getPlaca());
        values.put("ano",veiculo.getAno());
        conn.insert("Carro",null,values);
    }

    public void atualizarCarro(Carro veiculo){
        ContentValues values =new ContentValues();
        values.put("nome",veiculo.getNome());
        values.put("placa",veiculo.getPlaca());
        values.put("ano",veiculo.getAno());
        conn.update("Carro",values,"id_carro=?", new String[]{veiculo.getId().toString()});

}

    public void excluirCarro(Integer id){
        conn.delete("Carro","id_carro=?", new String[]{id.toString()});
    }


    public List<Carro> getCarros(){
        List<Carro> carros = new LinkedList<>();
        Cursor cursor;
        Carro carro;
        cursor =conn.rawQuery("SELECT * FROM Carro", null);

     cursor.moveToFirst();

     for (int i=0;i<cursor.getCount();i++){
         carro = new Carro();
         carro.setId(cursor.getInt(cursor.getColumnIndex("id_carro")));
         carro.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
         carro.setPlaca(cursor.getString(cursor.getColumnIndexOrThrow("placa")));
         carro.setAno(cursor.getInt(cursor.getColumnIndex("ano")));

         carros.add(carro);

         cursor.moveToNext();
     }


        return carros;

    }


    public Carro getCarro(Integer id){

        Cursor cursor;
        Carro carro;
        String sqlSelect = "SELECT * FROM Carro where id_carro = '"+ id +"'";
        cursor =conn.rawQuery(sqlSelect, null);

        cursor.moveToFirst();

            carro = new Carro();
            carro.setId(cursor.getInt(cursor.getColumnIndex("id_carro")));
            carro.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
            carro.setPlaca(cursor.getString(cursor.getColumnIndexOrThrow("placa")));
            carro.setAno(cursor.getInt(cursor.getColumnIndex("ano")));

            //cursor.moveToNext();


        return carro;

    }


}
