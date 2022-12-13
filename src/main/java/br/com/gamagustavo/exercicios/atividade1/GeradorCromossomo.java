package br.com.gamagustavo.exercicios.atividade1;

import java.util.Random;

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

    private GeradorCromossomo(){}

    /**
     * Combina dois cromossomos para gerar um novo.
     *
     * @param cromossomoPai lista de inteiro, não pode ser nulo.
     * @param cromossomoMae lista de inteiro, não pode ser nulo.
     * @return Um vetor de inteiro contendo a combinação dos cromossomoPai e cromossomoMae.
     */
    public int[] neoCromoComb(int[] cromossomoPai, int[] cromossomoMae){
        int[] cromossomo = new int[22];
        int indP = 0, indM = 21;
        while (indP <= indM) {
            cromossomo[indM] = cromossomoMae[indM--];
            cromossomo[indP] = cromossomoPai[indP++];
        }
        return cromossomo;
    }


}
