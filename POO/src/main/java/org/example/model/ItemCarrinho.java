package org.example.model;

public class ItemCarrinho {

    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null)
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("  %-50s x%-3d  R$ %,10.2f",
                produto.getMarca() + " " + produto.getModelo(),
                quantidade,
                getSubtotal());
    }
}
