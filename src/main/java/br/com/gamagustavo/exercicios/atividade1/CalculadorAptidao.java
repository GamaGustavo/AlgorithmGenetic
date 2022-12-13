package br.com.gamagustavo.exercicios.atividade1;

public class CalculadorAptidao {
    public static int convertParDeci(int[] cromossomo) {
        int x = 0;
        for (int i = 0; i < cromossomo.length; i++) {
            x += cromossomo[i] * Math.pow(2, i);
        }
        return x;
    }

    public static double intervalizar(int valor) {
        return 1 + valor * (9 / (Math.pow(2, 22) - 1));
    }

    public static double fitness(int[] cromossomo) {
        int valorDecimal = convertParDeci(cromossomo);
        double x = intervalizar(valorDecimal);
        return x * Math.sin(10 * Math.PI * x) + 1;
    }

}
