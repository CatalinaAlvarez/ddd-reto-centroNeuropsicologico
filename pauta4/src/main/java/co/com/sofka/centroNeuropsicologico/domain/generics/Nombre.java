package co.com.sofka.centroNeuropsicologico.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if(this.value.length()<2){
            throw new IllegalArgumentException("El nombre no puede tener menos de dos caracteres");
        }
        if(this.value.length()>50){
            throw new IllegalArgumentException("El nombre no puede tener más de cincuenta caracteres");
        }
        if(!this.value.matches("^[\\p{L} .'-]+$")){
            throw new IllegalArgumentException("El nombre no puede tener caracteres especiales, ni números");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
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
