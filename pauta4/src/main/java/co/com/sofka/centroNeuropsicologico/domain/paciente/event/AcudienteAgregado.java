package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class AcudienteAgregado extends DomainEvent {

    private final AcudienteId acudienteId;
    private final Nombre nombre;
    private final Email email;

    public AcudienteAgregado(AcudienteId entityId, Nombre nombre, Email email) {
        super("sofka.paciente.acudienteCambiado");
        this.acudienteId = entityId;
        this.nombre = nombre;
        this.email = email;
    }

    public AcudienteId getAcudienteId() {
        return acudienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
