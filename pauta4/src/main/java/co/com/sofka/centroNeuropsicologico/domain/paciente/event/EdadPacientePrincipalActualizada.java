package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.DomainEvent;

public class EdadPacientePrincipalActualizada extends DomainEvent {

    private final PacientePrincipalId pacientePrincipalId;
    private final Edad edad;

    public EdadPacientePrincipalActualizada(PacientePrincipalId entityId, Edad edad) {
        super("sofka.paciente.edadPacientePrincipalActualizada");
        this.pacientePrincipalId = entityId;
        this.edad = edad;
    }

    public PacientePrincipalId getPacientePrincipalId() {
        return pacientePrincipalId;
    }

    public Edad getEdad() {
        return edad;
    }
}
