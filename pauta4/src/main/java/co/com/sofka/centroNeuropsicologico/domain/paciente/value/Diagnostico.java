package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnostico implements ValueObject<String> {

    private final String value;

    public Diagnostico(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El diagnóstico no puede estar vacío");
        }
        if(this.value.length()<5){
            throw new IllegalArgumentException("El diagnóstico no puede tener menos de cinco caracteres");
        }
        if(this.value.length()>100){
            throw new IllegalArgumentException("El diagnóstico no puede tener más de cien caracteres");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostico that = (Diagnostico) o;
        return Objects.equals(value, that.value);
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
