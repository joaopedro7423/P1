package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.unigran.appveiculo.db.BancodeDados;
import br.unigran.domain.CarroBanco;
import br.unigran.domain.entidades.Carro;
import br.unigran.domain.CarroDao;

public class CadastroVeiculo extends AppCompatActivity {

    private EditText nome;
    private EditText ano;
    private EditText placa;
    private CarroBanco cb;
    private BancodeDados bancodeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bancodeDados = new BancodeDados(this);
        cb = new CarroBanco(bancodeDados.getWritableDatabase());


        setContentView(R.layout.activity_cadastro_veiculo);
        //vinculo com a tela
            nome = findViewById(R.id.nome_veiculo);
        ano = findViewById(R.id.ano);
        placa = findViewById(R.id.placa);

        }

    /**
     * Ação botao salvar veiculo
     * @param view
     */
    public  void salvarVeiculo(View view){
        //crio carro
        Carro carro = new Carro();
        //pego os dados e preencho o carro
        carro.setNome(nome.getText().toString());
        carro.setAno(Integer.parseInt(ano.getText().toString()));
        carro.setPlaca(placa.getText().toString());
        //salvo carro na lista
        cb.inserirCarro(carro);
        //verifico se foi salvo
        //System.out.println(CarroDao.getDados());
      //  finish();//fecha
        super.onBackPressed();

    }
}