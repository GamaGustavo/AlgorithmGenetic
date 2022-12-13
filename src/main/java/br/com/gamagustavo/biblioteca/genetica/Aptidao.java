package br.com.gamagustavo.biblioteca.genetica;

import java.util.Objects;

public class Aptidao implements Fitness {
    private Integer intValue;
    private Double doubleValue;

    public Aptidao(Integer intValue) {
        this.intValue = intValue;
    }

    public Aptidao(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    @Override
    public Aptidao soma(Fitness fitness) {
        if (intValue != null) {
            return new Aptidao(this.intValue + ((Aptidao) fitness).getIntValue());
        }
        if (doubleValue != null) {
            return new Aptidao(this.doubleValue + ((Aptidao) fitness).getDoubleValue());
        }
        return null;
    }

    @Override
    public int compareTo(Fitness outro) {
        Objects.requireNonNull(outro);
        Aptidao outraApitidao = (Aptidao) outro;
        if (Objects.nonNull(this.intValue)) {
            return this.intValue.compareTo(outraApitidao.getIntValue());
        }
        if (Objects.nonNull(this.doubleValue)) {
            return this.doubleValue.compareTo(outraApitidao.getDoubleValue());
        }

        return 0;
    }
}
