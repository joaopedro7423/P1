package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.unigran.domain.Abastecida;
import br.unigran.domain.AbastecidaDao;

public class CadastroAbastecid extends AppCompatActivity {

    private EditText tipo;
    private EditText qtd;
    private EditText preco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_abastecid);
        tipo= findViewById(R.id.tipo);
        qtd= findViewById(R.id.qtd);
        preco= findViewById(R.id.preco);

    }




    /**
     * Ação botao salvar veiculo
     * @param view
     */
    public  void salvarAbastecida(View view){

        Abastecida abas = new Abastecida();

        abas.setTipo(tipo.getText().toString());
        abas.setQtd(Double.parseDouble(qtd.getText().toString()));
        abas.setPreco(Double.parseDouble(preco.getText().toString()));

        AbastecidaDao.salvar(abas);



        super.onBackPressed();

    }

}