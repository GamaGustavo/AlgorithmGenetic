package br.com.gamagustavo.biblioteca.utils;


import java.util.Random;

public class Aleatorio {
    private static Random aleatorio;

    private Aleatorio() {}

    public static Random getRandom() {
        if (aleatorio == null) {
            aleatorio = new Random();
        }
        return aleatorio;
    }
}
