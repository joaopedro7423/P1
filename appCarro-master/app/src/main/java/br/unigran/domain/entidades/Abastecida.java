package br.unigran.domain.entidades;

public class Abastecida {



    private String tipo;
    private double qtd;
    private double preco;
    private Integer id;

    public Integer getId_carro() {return id_carro;}

    public void setId_carro(Integer id_carro) {this.id_carro = id_carro;}

    private Integer id_carro;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  "tipo='" + tipo + '\'' +
                ", qtd='" + qtd + "L"+'\'' +
                ", preco=" + preco +
                '}';
    }
}
