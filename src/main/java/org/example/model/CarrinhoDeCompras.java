package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarrinhoDeCompras {

    private final List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto == null)
            throw new IllegalArgumentException("Produto inválido.");
        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");

        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                System.out.printf("  ✔ Quantidade de \"%s %s\" atualizada para %d.%n",
                        produto.getMarca(), produto.getModelo(), item.getQuantidade());
                return;
            }
        }

        itens.add(new ItemCarrinho(produto, quantidade));
        System.out.printf("  ✔ \"%s %s\" adicionado (qtd: %d).%n",
                produto.getMarca(), produto.getModelo(), quantidade);
    }

    public boolean removerProduto(Produto produto) {
        boolean removido = itens.removeIf(item -> item.getProduto().equals(produto));
        if (removido) {
            System.out.printf("  ✔ \"%s %s\" removido do carrinho.%n",
                    produto.getMarca(), produto.getModelo());
        } else {
            System.out.println("  ✘ Produto não encontrado no carrinho.");
        }
        return removido;
    }

    public double calcularTotal() {
        return itens.stream()
                .mapToDouble(ItemCarrinho::getSubtotal)
                .sum();
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public void limpar() {
        itens.clear();
        System.out.println("  ✔ Carrinho esvaziado.");
    }

    public void exibirResumo() {
        System.out.println("=".repeat(68));
        System.out.println("  CARRINHO DE COMPRAS");
        System.out.println("=".repeat(68));

        if (estaVazio()) {
            System.out.println("  O carrinho está vazio.");
        } else {
            for (ItemCarrinho item : itens) {
                System.out.println(item);
            }
            System.out.println("-".repeat(68));
            System.out.printf("  %-53s R$ %,10.2f%n", "TOTAL", calcularTotal());
        }

        System.out.println("=".repeat(68));
    }
}
