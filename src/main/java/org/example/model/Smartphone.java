package org.example.model;

public class Smartphone extends Produto {

    private String sistemaOperacional;
    private int armazenamentoGB;
    private int memoriaRAMGB;
    private double tamanhoTelaPolegadas;

    public Smartphone(String marca, String modelo, double preco,
                      String sistemaOperacional, int armazenamentoGB,
                      int memoriaRAMGB, double tamanhoTelaPolegadas) {
        super(marca, modelo, preco);
        this.sistemaOperacional = sistemaOperacional;
        this.armazenamentoGB = armazenamentoGB;
        this.memoriaRAMGB = memoriaRAMGB;
        this.tamanhoTelaPolegadas = tamanhoTelaPolegadas;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public int getArmazenamentoGB() {
        return armazenamentoGB;
    }

    public int getMemoriaRAMGB() {
        return memoriaRAMGB;
    }

    public double getTamanhoTelaPolegadas() {
        return tamanhoTelaPolegadas;
    }

    @Override
    public String getEspecificacoes() {
        return String.format(
                "SO: %s | Armazenamento: %d GB | RAM: %d GB | Tela: %.1f\"",
                sistemaOperacional, armazenamentoGB, memoriaRAMGB, tamanhoTelaPolegadas
        );
    }
}
