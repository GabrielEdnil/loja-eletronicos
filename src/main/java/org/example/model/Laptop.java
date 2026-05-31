package org.example.model;

public class Laptop extends Produto {

    private String processador;
    private int memoriaRAMGB;
    private int armazenamentoGB;
    private double tamanhoTelaPolegadas;
    private String sistemaOperacional;

    public Laptop(String marca, String modelo, double preco,
                  String processador, int memoriaRAMGB,
                  int armazenamentoGB, double tamanhoTelaPolegadas,
                  String sistemaOperacional) {
        super(marca, modelo, preco);
        this.processador = processador;
        this.memoriaRAMGB = memoriaRAMGB;
        this.armazenamentoGB = armazenamentoGB;
        this.tamanhoTelaPolegadas = tamanhoTelaPolegadas;
        this.sistemaOperacional = sistemaOperacional;
    }


    public String getProcessador() {
        return processador;
    }

    public int getMemoriaRAMGB() {
        return memoriaRAMGB;
    }

    public int getArmazenamentoGB() {
        return armazenamentoGB;
    }

    public double getTamanhoTelaPolegadas() {
        return tamanhoTelaPolegadas;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    @Override
    public String getEspecificacoes() {
        return String.format(
                "Processador: %s | RAM: %d GB | Armazenamento: %d GB | Tela: %.1f\" | SO: %s",
                processador, memoriaRAMGB, armazenamentoGB, tamanhoTelaPolegadas, sistemaOperacional
        );
    }
}
