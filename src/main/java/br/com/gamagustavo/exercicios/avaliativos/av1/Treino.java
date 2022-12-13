package br.com.gamagustavo.exercicios.avaliativos.av1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Treino {
    private final int nrPop;
    private final int maxGera;
    private final int nrComp;
    private final ArrayList<Pessoa> pop;
    private final ArrayList<Pessoa> nataDaPop;
    private final Random random;

    private final double porcentagegemMute;
    private final double porcentagegemReprodus;

    Treino(int nrPop, int maxGera, int nrComp, double porcentagegemMute, double porcentagegemReprodus) {
        this.pop = new ArrayList<>();
        this.nataDaPop = new ArrayList<>();
        this.nrPop = nrPop;
        this.maxGera = maxGera;
        this.random = new Random();
        this.nrComp = nrComp;
        this.porcentagegemMute = porcentagegemMute;
        this.porcentagegemReprodus = porcentagegemReprodus;
    }

    public void startPop() {
        for (int i = 0; i < nrPop; i++) {
            var individo = new Pessoa();
            pop.add(individo);
            System.out.println(individo);
        }
    }


    private Pessoa torneio() {
        var competidores = new ArrayList<Pessoa>();
        for (int i = 0; i < nrPop; i++) {
            for (int j = 0; j < nrComp; j++) {
                var competidor = pop.get(random.nextInt(pop.size() - 1));
                competidores.add(competidor);
            }
            Collections.sort(competidores);
            var vencedor = competidores.get(0);
            nataDaPop.add(vencedor);
            competidores.clear();
        }
        Collections.sort(nataDaPop);
        return nataDaPop.get(0);
    }

    public void treinamento() throws Exception {
        startPop();
        int gera = 0;
        while (++gera <= maxGera) {
            var melhoIndivido = torneio();
            System.out.println(gera + "ª geração");
            System.out.print("Valor de A: " + melhoIndivido.getCromoADec());
            System.out.print(", Valor de B: " + melhoIndivido.getCromoBDec());
            System.out.println(", Maior apidão da população: " + melhoIndivido.getFitniss());
            if (melhoIndivido.getFitniss() == 0) break;
            pop.clear();
            reproducao();
            mutacao();
            pop.addAll(nataDaPop);
            nataDaPop.clear();
        }

    }

    public void reproducao() throws Exception {
        for (int i = 0; i++ < nrPop * porcentagegemReprodus; ) {
            Pessoa
                    indA = nataDaPop.get(random.nextInt(nataDaPop.size() - 1)),
                    indB = nataDaPop.get(random.nextInt(nataDaPop.size() - 1));

            pop.add(indA.reproduction(indB));
            pop.add(indB.reproduction(indA));
        }
    }

    public void mutacao() {
        for (int i = 0; i++ < nrPop * porcentagegemMute; ) {
            var individo = nataDaPop.get(random.nextInt(nataDaPop.size() - 1));
            pop.add(individo.getCopyWithMutation());
        }
    }
}
