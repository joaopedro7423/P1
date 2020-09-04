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

            startActivityForResult(it,121);//inicia nova activity
        atualizaListagem();
    }


    public void Abastecimento(View view){
        //nova activity

        Intent it2 = new Intent(MainActivity.this,Abastecimento.class);//cria a intent

        startActivity(it2);//inicia nova activity
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

                Carro carro = (Carro) CarroDao.getDados().get(i);
                Toast.makeText(getApplicationContext(),
                        "clicou no item" + i + carro, Toast.LENGTH_LONG).show();


                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Você deseja excluir?");
                alerta.setMessage("Você deseja realmente excluir o veículo " + carro +"?")

                 .setCancelable(false)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        Toast.makeText(getApplicationContext(),"Cancelar Escolido", Toast.LENGTH_LONG).show();

                    }
                }) .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {


                        CarroDao.remove(i);
                        atualizaListagem();

                    }
                }) .setNeutralButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {

                        Intent it = new Intent(MainActivity.this, EditVeiculo.class);
                        it.putExtra("idLista", i);

                        startActivityForResult(it, 121);

                        atualizaListagem();


                    }
                });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                atualizaListagem();
            }

        });


    }

}