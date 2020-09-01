package br.unigran.domain;

public class Abastecida {

    private String tipo;
    private double qtd;
    private double preco;

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
        return "Abastecida " +
                "tipo='" + tipo + '\'' +
                ", qtd='" + qtd + "L"+'\'' +
                ", preco=" + preco +
                '}';
    }
}
