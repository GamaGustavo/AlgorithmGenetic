package br.com.gamagustavo.exercicios.avaliativos.av1;

import biblioteca.genetica.Aptidao;
import biblioteca.genetica.Chromosome;
import biblioteca.genetica.Individo;
import biblioteca.genetica.Sujeito;

import java.util.Arrays;
import java.util.Objects;

import static br.com.gamagustavo.exercicios.avaliativos.av1.CalcAptidao.*;

public class Pessoa extends Sujeito {
    private final int[] cromossomoA;
    private final int[] cromossomoB;

    public Pessoa(int[] cromossomoA, int[] cromossomoB) {
        super(new Aptidao(fitness(cromossomoA, cromossomoB)));
        this.cromossomoA = cromossomoA;
        this.cromossomoB = cromossomoB;
    }

    public Pessoa() {
        this(Chromosome.getInstance().getCodBin(3), Chromosome.getInstance().getCodBin(3));
    }

    public int[] getCromossomoA() {
        return cromossomoA;
    }

    public int getCromoADec() {
        return paraDeci(cromossomoA);
    }

    public int getCromoBDec() {
        return paraDeci(cromossomoB);
    }

    public int[] getCromossomoB() {
        return cromossomoB;
    }

    public int getFitniss() {
        return super.getAptidao().getIntValue();
    }

    @Override
    public String toString() {
        return "Individo{" +
                "cromossomoA=" + Arrays.toString(cromossomoA) +
                ", cromossomoB=" + Arrays.toString(cromossomoB) +
                ", aptidao=" + this.getFitniss() +
                '}';
    }

    @Override
    public Pessoa reproduction(Individo individual) {
        Objects.requireNonNull(individual);
        Pessoa outraPessoa = (Pessoa) individual;
        return new Pessoa(
                GeradorCromossomo.getInstance()
                        .combCromo(this.cromossomoA, outraPessoa.getCromossomoA()),
                GeradorCromossomo.getInstance()
                        .combCromo(this.cromossomoB, outraPessoa.getCromossomoB()));
    }

    @Override
    public Pessoa getCopyWithMutation() {
        return new Pessoa(
                GeradorCromossomo.getInstance()
                        .neoCromeMute(this.cromossomoA),
                GeradorCromossomo.getInstance()
                        .neoCromeMute(this.cromossomoB)
        );
    }
}
