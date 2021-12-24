package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreAcudienteActualizado extends DomainEvent {

    private final AcudienteId acudienteId;
    private final Nombre nombre;

    public NombreAcudienteActualizado(AcudienteId entityId, Nombre nombre) {
        super("sofka.paciente.nombreAcudienteActualizado");
        this.acudienteId = entityId;
        this.nombre = nombre;
    }

    public AcudienteId getAcudienteId() {
        return acudienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
