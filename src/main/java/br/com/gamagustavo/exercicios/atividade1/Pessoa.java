package br.com.gamagustavo.exercicios.atividade1;

import biblioteca.genetica.*;

import java.util.Arrays;
import java.util.Objects;


public class Pessoa extends Sujeito {
    private final int[] cromossomo;

    public Pessoa(int[] cromossomo) {
        super(new Aptidao(CalculadorAptidao.fitness(cromossomo)));
        this.cromossomo = cromossomo;
    }

    public Pessoa() {
        this(Chromosome.getInstance().getCodBin(22));
    }


    public int[] getCromossomo() {
        return cromossomo;
    }


    public double getFtness() {
        return super.getAptidao().getDoubleValue();
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cromossomo=" + Arrays.toString(cromossomo) + ", aptidao=" + this.getFtness() + '}';
    }


    @Override
    public Pessoa reproduction(Individo individual) {
        Objects.requireNonNull(individual);
        Pessoa pessoa = (Pessoa) individual;
        int[] cromossomo = GeradorCromossomo.getInstance().neoCromoComb(this.cromossomo, pessoa.getCromossomo());
        return new Pessoa(cromossomo);
    }

    @Override
    public Individo getCopyWithMutation() {
        return null;
    }
}
