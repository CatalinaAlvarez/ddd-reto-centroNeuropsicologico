package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudioNeuropsicologoAgregado extends DomainEvent {

    private final NeuropsicologoId neuropsicologoId;
    private final Estudio estudio;

    public EstudioNeuropsicologoAgregado(NeuropsicologoId entityId, Estudio estudio) {
        super("sofka.equipoProfesional.estudioNeuropsicologoAgregado");
        this.neuropsicologoId = entityId;
        this.estudio = estudio;
    }

    public NeuropsicologoId getNeuropsicologoId() {
        return neuropsicologoId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
