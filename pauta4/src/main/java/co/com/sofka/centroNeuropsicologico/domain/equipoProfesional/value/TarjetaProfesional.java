package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TarjetaProfesional implements ValueObject<String> {

    private final String value;

    public TarjetaProfesional(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La tarjeta profesional no puede estar vacía");
        }
        if(this.value.length()<2){
            throw new IllegalArgumentException("La tarjeta profesional no puede tener menos de dos caracteres");
        }
        if(this.value.length()>20){
            throw new IllegalArgumentException("La tarjeta profesional no puede tener más de veinte caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
