package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.domain.generic.DomainEvent;

public class DuracionCitaActualizada extends DomainEvent {

    private final CitaId citaId;
    private final Duracion duracion;

    public DuracionCitaActualizada(CitaId entityId, Duracion duracion) {
        super("sofka.consulta.duracionCitaActualizada");
        this.citaId = entityId;
        this.duracion = duracion;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
