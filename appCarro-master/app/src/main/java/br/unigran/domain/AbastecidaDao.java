package br.unigran.domain;

import java.util.ArrayList;
import java.util.List;

import br.unigran.domain.entidades.Abastecida;

public class AbastecidaDao {

    private static List<Abastecida> dados = new ArrayList<>();
    private AbastecidaDao(){
    }
    public static  void salvar(Abastecida abastecida){ dados.add(abastecida); }
    public static  void remove(Abastecida abastecida){dados.remove(abastecida); }
    public static List getDados(){return dados; }
}
