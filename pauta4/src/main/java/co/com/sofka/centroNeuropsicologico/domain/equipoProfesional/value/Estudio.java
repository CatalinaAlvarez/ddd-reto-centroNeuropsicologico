package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estudio implements ValueObject<String> {

    private final String value;

    public Estudio(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El estudio no puede estar vacío");
        }
        if(this.value.length()<5){
            throw new IllegalArgumentException("El estudio no puede tener menos de cinco caracteres");
        }
        if(this.value.length()>200){
            throw new IllegalArgumentException("El estudio no puede tener más de doscientos caracteres");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio = (Estudio) o;
        return Objects.equals(value, estudio.value);
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
