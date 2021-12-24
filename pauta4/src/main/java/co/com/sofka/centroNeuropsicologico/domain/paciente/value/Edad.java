package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {

    private final Integer value;

    public Edad(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 2){
            throw new IllegalArgumentException("La edad no puede ser menor a 2");
        }
        if(this.value > 18){
            throw new IllegalArgumentException("La edad no puede ser mayor a 18");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edad edad = (Edad) o;
        return Objects.equals(value, edad.value);
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
