package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailPsicologoActualizado extends DomainEvent {

    private final PsicologoId psicologoId;
    private final Email email;

    public EmailPsicologoActualizado(PsicologoId entityId, Email email) {
        super("sofka.equipoProfesional.emailPsicologoActualizado");
        this.psicologoId = entityId;
        this.email = email;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Email getEmail() {
        return email;
    }
}
