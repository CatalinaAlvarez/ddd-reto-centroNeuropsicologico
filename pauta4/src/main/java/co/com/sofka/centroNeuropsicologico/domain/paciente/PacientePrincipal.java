package co.com.sofka.centroNeuropsicologico.domain.paciente;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class PacientePrincipal extends Entity<PacientePrincipalId> {

    protected Nombre nombre;
    protected Edad edad;

    public PacientePrincipal(PacientePrincipalId entityId, Nombre nombre, Edad edad) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        this.edad = Objects.requireNonNull(edad);
    }

    public void actualizarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        this.nombre = nombre;
    }

    public void actualizarEdad(Edad edad){
        Objects.requireNonNull(edad);
        this.edad = edad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }
}
