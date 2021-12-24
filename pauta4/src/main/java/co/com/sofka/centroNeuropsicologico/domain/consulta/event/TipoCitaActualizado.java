package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoCitaActualizado extends DomainEvent {

    private final CitaId citaId;
    private final Tipo tipo;

    public TipoCitaActualizado(CitaId entityId, Tipo tipo) {
        super("sofka.consulta.tipoCitaActualizado");
        this.citaId = entityId;
        this.tipo = tipo;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
