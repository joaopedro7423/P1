package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.unigran.appveiculo.db.BancodeDados;
import br.unigran.domain.CarroBanco;
import br.unigran.domain.entidades.Carro;
import br.unigran.domain.CarroDao;

public class EditVeiculo extends AppCompatActivity {
    private EditText nome;
    private EditText ano;
    private EditText placa;
    private CarroBanco cb;
    private BancodeDados bancodeDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bancodeDados = new BancodeDados(this);
        cb = new CarroBanco(bancodeDados.getReadableDatabase());

        setContentView(R.layout.activity_edit_veiculo);
        nome = findViewById(R.id.nome_veiculo);
        ano = findViewById(R.id.ano);
        placa = findViewById(R.id.placa);

        Carro carro = new Carro();

        Intent it = getIntent();

        Integer idLista = it.getIntExtra("idLista", 0);

        Carro editCar =  cb.getCarro(idLista);
  

        nome.setText(editCar.getNome()+"");
        ano.setText(editCar.getAno()+"");
        placa.setText(editCar.getPlaca());



    }


    public  void salvarVeiculo(View view){
        Intent it = getIntent();
        int idLista = it.getIntExtra("idLista", 0);

        Carro carro;
        carro =  cb.getCarro(idLista);

        carro.setNome(nome.getText().toString());
        carro.setAno(Integer.parseInt(ano.getText().toString()));
        carro.setPlaca(placa.getText().toString());

        System.out.println(CarroDao.getDados());
        cb.atualizarCarro(carro);
        super.onBackPressed();

    }




}