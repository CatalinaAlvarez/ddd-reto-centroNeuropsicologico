package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<Tipo.Valor> {

    private final Valor value;


    public Tipo(Valor valor) {
        this.value = valor;
    }

    public enum Valor {
        REHABILITACION_COGNITIVA,
        ASESORIA_PSICOLOGICA,
        SEGUIMIENTO;
    }

    @Override
    public Valor value() {
        return value;
    }
}
