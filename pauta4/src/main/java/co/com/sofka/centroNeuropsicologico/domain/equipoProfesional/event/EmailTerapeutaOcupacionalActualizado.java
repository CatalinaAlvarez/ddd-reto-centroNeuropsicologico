package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TerapeutaOcupacionalId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailTerapeutaOcupacionalActualizado extends DomainEvent {

    private final TerapeutaOcupacionalId terapeutaOcupacionalId;
    private final Email email;

    public EmailTerapeutaOcupacionalActualizado(TerapeutaOcupacionalId entityId, Email email) {
        super("sofka.equipoProfesional.emailTerapeutaOcupacionalActualizado");
        this.terapeutaOcupacionalId = entityId;
        this.email = email;
    }

    public TerapeutaOcupacionalId getTerapeutaOcupacionalId() {
        return terapeutaOcupacionalId;
    }

    public Email getEmail() {
        return email;
    }
}
