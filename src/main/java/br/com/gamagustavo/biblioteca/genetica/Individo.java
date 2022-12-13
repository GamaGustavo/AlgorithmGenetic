package br.com.gamagustavo.biblioteca.genetica;


import java.util.List;

public interface Individo extends Comparable<Individo>{
    Fitness fitness();
    Individo reproduction(Individo individual);

    Individo getCopyWithMutation();

}
