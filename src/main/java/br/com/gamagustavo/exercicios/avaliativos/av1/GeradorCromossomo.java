package br.com.gamagustavo.exercicios.avaliativos.av1;

import biblioteca.utils.Aleatorio;


/**
 * Responsavel por gerar cromossomos.
 *
 * @author Gustavo
 */

public class GeradorCromossomo {

    private static GeradorCromossomo intance;


    public static GeradorCromossomo getInstance() {
        if (intance == null) {
            intance = new GeradorCromossomo();
        }
        return intance;
    }

    public GeradorCromossomo() {
    }

    /**
     * Gera um cromossomo aleatorio.
     *
     * @return Um vetor de inteiros preenchido com valores aleatorios de 0 e 1.
     **/

    public int[] combCromo(int[] cromoA, int[] cromoB) {
        var neoCromo = new int[cromoA.length];
        int i = 0;
        int j = neoCromo.length - 1;
        do {
            neoCromo[i] = cromoA[i];
            neoCromo[j] = cromoB[j];
        } while (++i <= --j);
        return neoCromo;
    }

    public int[] neoCromeMute(int[] chromo) {
        var neoCromo = chromo.clone();
        var index = Aleatorio.getRandom().nextInt(chromo.length);
        neoCromo[index] = neoCromo[index] == 1 ? 0 : 1;
        return neoCromo;
    }
}
