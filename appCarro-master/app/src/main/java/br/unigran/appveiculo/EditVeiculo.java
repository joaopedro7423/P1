package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.unigran.domain.Carro;
import br.unigran.domain.CarroDao;

public class EditVeiculo extends AppCompatActivity {
    private EditText nome;
    private EditText ano;
    private EditText placa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_veiculo);
        nome = findViewById(R.id.nome_veiculo);
        ano = findViewById(R.id.ano);
        placa = findViewById(R.id.placa);

        Intent it = getIntent();
        int idLista = it.getIntExtra("idLista", 0);


       Carro carro = (Carro) CarroDao.getDados().get(idLista);

        nome.setText(carro.getNome()+"");
        ano.setText(carro.getAno()+"");
        placa.setText(carro.getPlaca());



            Toast.makeText(getApplicationContext(),
                    "clicou no item"  + carro, Toast.LENGTH_LONG).show();



    }


    public  void salvarVeiculo(View view){
        Intent it = getIntent();
        int idLista = it.getIntExtra("idLista", 0);
        Carro carro = (Carro) CarroDao.getDados().get(idLista);

        carro.setNome(nome.getText().toString());
        carro.setAno(Integer.parseInt(ano.getText().toString()));
        carro.setPlaca(placa.getText().toString());

        System.out.println(CarroDao.getDados());

        super.onBackPressed();

    }




}