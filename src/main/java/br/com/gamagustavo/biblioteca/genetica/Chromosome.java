package br.com.gamagustavo.biblioteca.genetica;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static biblioteca.utils.Aleatorio.getRandom;

public class Chromosome {

    private static Chromosome instance;

    public static Chromosome getInstance() {
        if (instance == null) {
            instance = new Chromosome();
        }
        return instance;
    }

    private Chromosome() {
    }

    public int[] getCodBin(int QuantidadeDeBits) {
        int[] chromossomo = new int[QuantidadeDeBits];
        Arrays.setAll(chromossomo, value -> getRandom().nextInt(2));
        return chromossomo;
    }

    public int[] getCodOctal(int tamanhoDoOctal) {
        int[] chromossomo = new int[tamanhoDoOctal];
        Arrays.setAll(chromossomo, value -> getRandom().nextInt(8));
        return chromossomo;
    }

    public char[] getCodHexadecimal(int tamanhoDoHexadecimal) {
        char[] chromossomo = new char[tamanhoDoHexadecimal];
        for (int i = 0; i < chromossomo.length; i++) {
            int valor = getRandom().nextInt(16);
            chromossomo[i] = switch (valor) {
                case 10 -> 'A';
                case 11 -> 'B';
                case 12 -> 'C';
                case 13 -> 'D';
                case 14 -> 'E';
                case 15 -> 'F';
                default -> String.valueOf(valor).charAt(0);
            };
        }
        return chromossomo;
    }

    public Integer[] getCodPermuta(int tamanhoDaSequencia) {
        List<Integer> integers =
                IntStream
                        .range(0, tamanhoDaSequencia)                      // <-- creates a stream of ints
                        .boxed()                                          // <-- converts them to Integers
                        .collect(Collectors.toList());                   // <-- collects the values to a list

        Collections.shuffle(integers);
        return integers.toArray(Integer[]::new);
    }

    public Integer[] getCodValorInt(int quantidadeDeValores) {
        Integer[] chromossomo = new Integer[quantidadeDeValores];
        Arrays.setAll(chromossomo, value -> getRandom().nextInt());
        return chromossomo;
    }

    public Integer[] getCodValorInt(int quantidadeDeValores, boolean ehPositivo) {
        Integer[] chromossomo = new Integer[quantidadeDeValores];
        Arrays.setAll(chromossomo, value -> {
            value = getRandom().nextInt();
            if (ehPositivo)
                return value < 0 ? value * -1 : value;
            else
                return value > 0 ? value * -1 : value;

        });
        return chromossomo;
    }

    public Double[] getCodValorDouble(int quantidadeDeValores, int rengeMax) {
        Double[] chromossomo = new Double[quantidadeDeValores];
        Arrays.setAll(chromossomo, value -> getRandom().nextDouble() * rengeMax);
        return chromossomo;
    }

    public Double[] getCodValorDouble(int quantidadeDeValores, int rengeMax, boolean ehPositivo) {
        Double[] chromossomo = new Double[quantidadeDeValores];
        Arrays.setAll(chromossomo, v -> {
            double value;
            value = getRandom().nextDouble() * rengeMax;
            if (ehPositivo)
                return value < 0 ? value * -1 : value;
            else
                return value > 0 ? value * -1 : value;

        });
        return chromossomo;
    }
}
