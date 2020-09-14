package br.unigran.appveiculo.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BancodeDados extends SQLiteOpenHelper {


    public BancodeDados(@Nullable Context context) {
        super(context, "Abastecer", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TabelaCarro = "CREATE TABLE Carro(" +
                " id_carro INTEGER PRIMARY KEY NOT NULL," +
                " ano INTEGER NOT NULL," +
                " nome VARCHAR(50)," +
                " placa VARCHAR(30)" +
                ")";


        String TabelaAbastecida = "CREATE TABLE Abastecida(" +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " tipo VARCHAR(20) NOT NULL," +
                " qtd DOUBLE," +
                " preco DOUBLE" +
                //" FOREIGN KEY(id_carro) REFERENCES Carro(id_carro)" +
                ")";

        db.execSQL(TabelaCarro);
        db.execSQL(TabelaAbastecida);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
