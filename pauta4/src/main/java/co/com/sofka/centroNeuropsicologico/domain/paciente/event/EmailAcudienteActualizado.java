package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailAcudienteActualizado extends DomainEvent {

    private final AcudienteId acudienteId;
    private final Email email;

    public EmailAcudienteActualizado(AcudienteId entityId, Email email) {
        super("sofka.paciente.emailAcudienteActualizado");
        acudienteId = entityId;
        this.email = email;
    }

    public AcudienteId getAcudienteId() {
        return acudienteId;
    }

    public Email getEmail() {
        return email;
    }
}
