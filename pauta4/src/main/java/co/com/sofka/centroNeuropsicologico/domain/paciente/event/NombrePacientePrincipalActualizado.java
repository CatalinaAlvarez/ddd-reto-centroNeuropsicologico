package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.DomainEvent;

public class NombrePacientePrincipalActualizado extends DomainEvent {

    private final PacientePrincipalId pacientePrincipalId;
    private final Nombre nombre;

    public NombrePacientePrincipalActualizado(PacientePrincipalId entityId, Nombre nombre) {
        super("sofka.paciente.nombrePacientePrincipalActualizado");
        this.pacientePrincipalId = entityId;
        this.nombre = nombre;
    }

    public PacientePrincipalId getPacientePrincipalId() {
        return pacientePrincipalId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
