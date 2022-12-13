package br.com.gamagustavo.exercicios.atividade1;

import biblioteca.utils.Aleatorio;

import java.util.ArrayList;

public class Treinamento {

    private static Treinamento instance;

    public static Treinamento getInstance() {
        if (instance == null)
            instance = new Treinamento();
        return instance;
    }

    private final int nrPop;
    private final int nrCompetidores;

    public Treinamento() {
        this.nrPop = 1000;
        this.nrCompetidores = 50;
    }

    public void inincializarPop(ArrayList<Pessoa> populacao) {
        for (int i = 0; i < nrPop; i++) {
            populacao.add(new Pessoa());
        }
    }

    public void reproducao(ArrayList<Pessoa> populacao) {
        int size = populacao.size();
        for (int j = 0; j < size / 2; j++) {
            Pessoa p1 = populacao.get(Aleatorio.getRandom().nextInt(size));
            Pessoa p2 = populacao.get(Aleatorio.getRandom().nextInt(size));
            Pessoa novaPessoa = p1.reproduction(p2);
            populacao.add(novaPessoa);
        }
    }

    public Pessoa torneio(ArrayList<Pessoa> competidores) {
        Pessoa vencedor = competidores.get(competidores.size() - 1);
        for (int i = 1; i < nrCompetidores; i++) {
            Pessoa ind = competidores.get(Aleatorio.getRandom().nextInt(competidores.size() - 1));
            if (vencedor.getFtness() < ind.getFtness()) {
                vencedor = ind;
            }
        }
        return vencedor;
    }

    public int getNrPop() {
        return nrPop;
    }
}
