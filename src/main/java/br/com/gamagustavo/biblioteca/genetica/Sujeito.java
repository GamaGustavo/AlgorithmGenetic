package br.com.gamagustavo.biblioteca.genetica;

public abstract class Sujeito implements Individo {

    private final Aptidao aptidao;

    public Sujeito(Aptidao fitness){
        this.aptidao = fitness;
    }
    @Override
    public Aptidao fitness() {
        return aptidao;
    }

    protected Aptidao getAptidao() {
        return aptidao;
    }

    @Override
    public int compareTo(Individo outroIndivido) {

        return this.aptidao.compareTo(outroIndivido.fitness());
    }
}



















