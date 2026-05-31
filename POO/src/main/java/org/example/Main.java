package org.example;

import org.example.model.Cliente;
import org.example.model.Laptop;
import org.example.model.Produto;
import org.example.model.Smartphone;
import org.example.model.TV;

public class Main {

    public static void main(String[] args) {

        Smartphone s1 = new Smartphone(
                "Samsung", "Galaxy S24 Ultra", 6_999.00,
                "Android 14", 256, 12, 6.8
        );
        Smartphone s2 = new Smartphone(
                "Apple", "iPhone 15 Pro", 8_499.00,
                "iOS 17", 128, 8, 6.1
        );

        Laptop l1 = new Laptop(
                "Dell", "XPS 15", 9_500.00,
                "Intel Core i7-13700H", 16, 512, 15.6, "Windows 11"
        );
        Laptop l2 = new Laptop(
                "Apple", "MacBook Air M3", 11_299.00,
                "Apple M3", 16, 256, 13.6, "macOS Sonoma"
        );

        TV tv1 = new TV(
                "LG", "OLED C3 55\"", 5_299.00,
                55, "4K UHD", true, "OLED"
        );
        TV tv2 = new TV(
                "Samsung", "Neo QLED 65\"", 7_199.00,
                65, "4K UHD", true, "Neo QLED"
        );

        Produto[] catalogo = {s1, s2, l1, l2, tv1, tv2};

        System.out.println("\n" + "=".repeat(68));
        System.out.println("  CATÁLOGO DA LOJA DE ELETRÔNICOS");
        System.out.println("=".repeat(68));

        for (Produto p : catalogo) {
            System.out.println(p);
            System.out.println("  Specs: " + p.getEspecificacoes());
            System.out.println();
        }

        Cliente ana = new Cliente("Ana Paula", "111.222.333-44", "ana@email.com");
        Cliente bruno = new Cliente("Bruno Souza", "555.666.777-88", "bruno@email.com");

        System.out.println("--- Compras de " + ana.getNome() + " ---");
        ana.adicionarAoCarrinho(s1, 1);
        ana.adicionarAoCarrinho(tv1, 1);
        ana.adicionarAoCarrinho(l1, 1);
        ana.adicionarAoCarrinho(s1, 1);

        ana.verCarrinho();
        ana.verTotalAPagar();

        System.out.println("--- Compras de " + bruno.getNome() + " ---");
        bruno.adicionarAoCarrinho(l2, 2);
        bruno.adicionarAoCarrinho(tv2, 1);

        bruno.verCarrinho();
        bruno.verTotalAPagar();

        System.out.println("--- Removendo TV do carrinho de " + bruno.getNome() + " ---");
        bruno.getCarrinho().removerProduto(tv2);
        bruno.verCarrinho();

        System.out.println("\n--- Tipos dos produtos identificados via instanceof ---");
        for (Produto p : catalogo) {
            String tipo;
            if (p instanceof Smartphone) tipo = "Smartphone";
            else if (p instanceof Laptop) tipo = "Laptop";
            else if (p instanceof TV) tipo = "TV";
            else tipo = "Produto genérico";

            System.out.printf("  %-30s → %s%n",
                    p.getMarca() + " " + p.getModelo(), tipo);
        }
    }
}
