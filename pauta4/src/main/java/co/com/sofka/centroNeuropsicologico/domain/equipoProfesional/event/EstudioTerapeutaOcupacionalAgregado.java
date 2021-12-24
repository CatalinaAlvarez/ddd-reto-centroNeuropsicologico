package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TerapeutaOcupacionalId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudioTerapeutaOcupacionalAgregado extends DomainEvent {

    private final TerapeutaOcupacionalId terapeutaOcupacionalId;
    private final Estudio estudio;

    public EstudioTerapeutaOcupacionalAgregado(TerapeutaOcupacionalId entityId, Estudio estudio) {
        super("sofka.equipoProfesional.estudioTerapeutaOcupacionalAgregado");
        terapeutaOcupacionalId = entityId;
        this.estudio = estudio;
    }

    public TerapeutaOcupacionalId getTerapeutaOcupacionalId() {
        return terapeutaOcupacionalId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
