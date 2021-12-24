package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailNeuropsicologoActualizado extends DomainEvent {

    private final NeuropsicologoId neuropsicologoId;
    private final Email email;

    public EmailNeuropsicologoActualizado(NeuropsicologoId entityId, Email email) {
        super("sofka.equipoProfesional.emailNeuropsicologoActualizado");

        this.neuropsicologoId = entityId;
        this.email = email;
    }

    public NeuropsicologoId getNeuropsicologoId() {
        return neuropsicologoId;
    }

    public Email getEmail() {
        return email;
    }

}
