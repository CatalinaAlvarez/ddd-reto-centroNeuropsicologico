package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final Integer value;

    public Duracion(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 10){
            throw new IllegalArgumentException("La duración no puede ser menor a 10 minutos");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion = (Duracion) o;
        return Objects.equals(value, duracion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
