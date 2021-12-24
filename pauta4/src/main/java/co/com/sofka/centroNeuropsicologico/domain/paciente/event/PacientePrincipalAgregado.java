package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.DomainEvent;

public class PacientePrincipalAgregado extends DomainEvent {

    private final PacientePrincipalId pacientePrincipalId;
    private final Nombre nombre;
    private final Edad edad;

    public PacientePrincipalAgregado(PacientePrincipalId entityId, Nombre nombre, Edad edad) {
        super("sofka.paciente.pacientePrincipalAgregado");
        this.pacientePrincipalId = entityId;
        this.nombre = nombre;
        this.edad = edad;
    }

    public PacientePrincipalId getPacientePrincipalId() {
        return pacientePrincipalId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
