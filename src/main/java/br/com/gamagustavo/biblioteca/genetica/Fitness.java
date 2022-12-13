package br.com.gamagustavo.biblioteca.genetica;

public interface Fitness {

    Fitness soma(Fitness fitness);

    int compareTo(Fitness outro);

}

