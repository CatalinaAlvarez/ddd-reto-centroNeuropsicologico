package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Anamnesis implements ValueObject<String> {

    private final String value;

    public Anamnesis(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La anamnesis no puede estar vacío");
        }
        if(this.value.length()<30){
            throw new IllegalArgumentException("La anamnesis no puede tener menos de treinta caracteres");
        }
        if(this.value.length()>3000){
            throw new IllegalArgumentException("La anamnesis no puede tener más de tres mil caracteres");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anamnesis anamnesis = (Anamnesis) o;
        return Objects.equals(value, anamnesis.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
