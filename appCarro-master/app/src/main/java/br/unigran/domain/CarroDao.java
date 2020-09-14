package br.unigran.domain;

import java.util.ArrayList;
import java.util.List;

import br.unigran.domain.entidades.Carro;

public class CarroDao {

    private static List<Carro>dados = new ArrayList<>();
    private CarroDao(){
    }
    public static  void salvar(Carro carro){
        dados.add(carro);
    }

    public static  void remove(int i){
        dados.remove(i);
    }
    public static List getDados(){
        return dados;
    }


}
