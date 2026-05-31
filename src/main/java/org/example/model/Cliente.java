package org.example.model;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private CarrinhoDeCompras carrinho;

    public Cliente(String nome, String cpf, String email) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF inválido.");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("E-mail inválido.");

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.carrinho = new CarrinhoDeCompras();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("E-mail inválido.");
        this.email = email;
    }

    public void adicionarAoCarrinho(Produto produto, int quantidade) {
        carrinho.adicionarProduto(produto, quantidade);
    }

    public void verCarrinho() {
        System.out.printf("%nCarrinho de: %s  |  CPF: %s%n", nome, cpf);
        carrinho.exibirResumo();
    }

    public void verTotalAPagar() {
        System.out.printf("  Total a pagar (%s): R$ %,.2f%n%n",
                nome, carrinho.calcularTotal());
    }

    @Override
    public String toString() {
        return String.format("Cliente{ nome='%s', cpf='%s', email='%s' }", nome, cpf, email);
    }
}
