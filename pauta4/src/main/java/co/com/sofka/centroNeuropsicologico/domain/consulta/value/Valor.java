package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Double> {

    private final Double value;

    public Valor(Double value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("El valor no puede ser menor a cero");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
