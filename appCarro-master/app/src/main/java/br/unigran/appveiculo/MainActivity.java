package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.unigran.domain.Carro;
import br.unigran.domain.CarroDao;
import  br.unigran.domain.Abastecida;
import  br.unigran.domain.AbastecidaDao;


public class MainActivity extends AppCompatActivity {

    private ListView listagemCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listagemCarro=findViewById(R.id.listagemCarro);
        atualizaListagem();
    }
    /**
     * recebe acao do botao Novo Veiculo
     * @param view
     */
    public void novoVeiculo(View view){
        //nova activity

            Intent it = new Intent(MainActivity.this, CadastroVeiculo.class);//cria a intent

            startActivityForResult(it,RESULT_OK);//inicia nova activity
    }


    public void Abastecimento(View view){
        //nova activity

        Intent it2 = new Intent(MainActivity.this,Abastecimento.class);//cria a intent

        startActivity(it2);//inicia nova activity
    }


    public void editar(View view){

      //  Carro carro=null;
        Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent
        //it.putExtra("carro",carro);
        startActivityForResult(it,RESULT_OK);//inicia nova activity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizaListagem();//executa após fechar activity chamada pelo startActivityForResult
    }

    public void atualizaListagem(){
        //crio adapter passando contexto, layout e lista
        final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, CarroDao.getDados());
        listagemCarro.setAdapter(adapter);//envio para lista
        System.out.println(CarroDao.getDados());

        listagemCarro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                Toast.makeText(getApplicationContext(),
                        "clicou no item" + i, Toast.LENGTH_LONG).show();


                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Você deseja excluir?");
                alerta.setMessage("Você deseja realmente excluir esse veículo?")
                 .setCancelable(false)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        Toast.makeText(getApplicationContext(),
                                "Cancelar Escolido", Toast.LENGTH_LONG).show();

                    }
                }) .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {


                        CarroDao.remove(i);
                        atualizaListagem();

                    }
                });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();

            }

        });

        listagemCarro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, CadastroVeiculo.class);
                it.putExtra("idLista", i);
                startActivityForResult(it, RESULT_OK);

            }
        });

    }

}