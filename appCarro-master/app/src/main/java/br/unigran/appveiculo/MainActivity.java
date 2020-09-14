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

import br.unigran.appveiculo.db.BancodeDados;
import br.unigran.domain.CarroBanco;
import br.unigran.domain.entidades.Carro;
import br.unigran.domain.CarroDao;


public class MainActivity extends AppCompatActivity {

    private ListView listagemCarro;
    private  CarroBanco cb;
    private BancodeDados bancodeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bancodeDados = new BancodeDados(this);
        cb = new CarroBanco(bancodeDados.getReadableDatabase());

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
        final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, cb.getCarros());
        listagemCarro.setAdapter(adapter);//envio para lista
        System.out.println(CarroDao.getDados());

        listagemCarro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long id) {

                //Carro carro = (Carro) ;


                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Você deseja excluir?");
                alerta.setMessage("Você deseja realmente excluir o veículo "  +"?")

                 .setCancelable(false)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {


                    }
                }) .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {
                            Carro car = (Carro) adapterView.getItemAtPosition(i);
                            Integer j = car.getId();
                        cb.excluirCarro(j);
                        atualizaListagem();

                    }
                }) .setNeutralButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {
                        Carro car = (Carro) adapterView.getItemAtPosition(i);
                        Intent it = new Intent(MainActivity.this, EditVeiculo.class);
                        Integer j = car.getId();
                        it.putExtra("idLista", j);

                        startActivityForResult(it, 121);

                        //atualizaListagem();


                    }
                });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                atualizaListagem();
            }

        });


    }

}