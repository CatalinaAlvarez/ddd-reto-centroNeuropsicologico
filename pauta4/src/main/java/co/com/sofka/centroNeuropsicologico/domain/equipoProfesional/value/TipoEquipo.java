package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoEquipo implements ValueObject<TipoEquipo.Valor> {

    private final Valor value;


    public TipoEquipo(Valor valor) {
        this.value = valor;
    }

    public enum Valor {
        INFANCIA,
        ADOLESCENCIA;
    }

    @Override
    public Valor value() {
        return value;
    }

}
