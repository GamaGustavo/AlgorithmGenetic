package br.com.gamagustavo.exercicios.avaliativos.av1;

public class CalcAptidao {

    private CalcAptidao() {
    }

    public static int paraDeci(int[] cromossomo) {
        int x = 0;
        for (int i = 0; i < cromossomo.length; i++) {
            x += cromossomo[i] * Math.pow(2, i);
        }
        return x;
    }

    public static int fitness(int[] cromossomoA, int[] cromossomoB) {
        var a = paraDeci(cromossomoA);
        var b = paraDeci(cromossomoB);
        var fx = ((int) Math.pow(a, 2)) * 2 + b - 57;
        return fx < 0 ? -1 * fx : fx;
    }

}
