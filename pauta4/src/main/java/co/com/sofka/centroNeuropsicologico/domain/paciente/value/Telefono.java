package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if(this.value.length()<7){
            throw new IllegalArgumentException("El teléfono no puede tener menos de siete caracteres");
        }
        if(this.value.length()>10){
            throw new IllegalArgumentException("El teléfono no puede tener más de diez caracteres");
        }
        if (!this.value.matches("[0-9]*")){
            throw new IllegalArgumentException("El teléfono sólo puede incluir números");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
