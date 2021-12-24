package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudioPsicologoAgregado extends DomainEvent {

    private final PsicologoId psicologoId;
    private final Estudio estudio;

    public EstudioPsicologoAgregado(PsicologoId entityId, Estudio estudio) {
        super("sofka.equipoProfesional.estudioPsicologoAgregado");
        this.psicologoId = entityId;
        this.estudio = estudio;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
