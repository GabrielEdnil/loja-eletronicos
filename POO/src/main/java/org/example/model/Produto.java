package org.example.model;

public abstract class Produto {

    private String marca;
    private String modelo;
    private double preco;

    protected Produto(String marca, String modelo, double preco) {
        if (marca == null || marca.isBlank())
            throw new IllegalArgumentException("Marca não pode ser vazia.");
        if (modelo == null || modelo.isBlank())
            throw new IllegalArgumentException("Modelo não pode ser vazio.");
        if (preco < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo.");

        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        this.preco = preco;
    }

    public abstract String getEspecificacoes();

    @Override
    public String toString() {
        return String.format("[%s] %s %s - R$ %,.2f",
                getClass().getSimpleName(), marca, modelo, preco);
    }
}
