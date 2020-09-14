package br.unigran.domain.entidades;

public class Carro {
    private Integer id;
    private String nome;
    private String placa;
    private Integer ano;

    public Integer getId() { return id;}

    public void setId(Integer id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return
                "Carro='" + nome + '\'' +
                ",Placa='" + placa + '\'' +
                ",Ano=" + ano ;

    }



}
