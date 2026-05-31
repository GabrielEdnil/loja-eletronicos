package org.example.model;

public class TV extends Produto {

    private double tamanhoTelaPolegadas;
    private String resolucao;
    private boolean smart;
    private String tecnologiaDisplay;

    public TV(String marca, String modelo, double preco,
              double tamanhoTelaPolegadas, String resolucao,
              boolean smart, String tecnologiaDisplay) {
        super(marca, modelo, preco);
        this.tamanhoTelaPolegadas = tamanhoTelaPolegadas;
        this.resolucao = resolucao;
        this.smart = smart;
        this.tecnologiaDisplay = tecnologiaDisplay;
    }

    public double getTamanhoTelaPolegadas() {
        return tamanhoTelaPolegadas;
    }

    public String getResolucao() {
        return resolucao;
    }

    public boolean isSmart() {
        return smart;
    }

    public String getTecnologiaDisplay() {
        return tecnologiaDisplay;
    }

    @Override
    public String getEspecificacoes() {
        return String.format(
                "Tela: %.0f\" | Resolução: %s | Smart TV: %s | Display: %s",
                tamanhoTelaPolegadas, resolucao, smart ? "Sim" : "Não", tecnologiaDisplay
        );
    }
}
