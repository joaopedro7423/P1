package br.unigran.appveiculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.unigran.domain.AbastecidaDao;


public class Abastecimento extends AppCompatActivity {


    private ListView ListaDeAbastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);
        ListaDeAbastecimento=findViewById(R.id.ListaDeAbastecimento);
        atualizaListagem();


    }


    public void novaAbastecida(View view){
        //nova activity

        Intent it = new Intent(Abastecimento.this, CadastroAbastecid.class);//cria a intent

        startActivity(it);//inicia nova activity

    }


    public void voltar(View view){
        //nova activity

        Intent it = new Intent(Abastecimento.this, MainActivity.class);//cria a intent

        startActivity(it);//inicia nova activity

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizaListagem();//executa após fechar activity chamada pelo startActivityForResult
    }



    public void atualizaListagem(){
        //crio adapter passando contexto, layout e lista
        final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, AbastecidaDao.getDados());
        ListaDeAbastecimento.setAdapter(adapter);//envio para lista
        System.out.println(AbastecidaDao.getDados());


    }
}