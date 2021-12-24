package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Anamnesis;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Diagnostico;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.HistoriaClinicaId;
import co.com.sofka.domain.generic.DomainEvent;

public class HistoriaClinicaAgregada extends DomainEvent {

    private final HistoriaClinicaId historiaClinicaId;
    private final Diagnostico diagnostico;
    private final Anamnesis anamnesis;

    public HistoriaClinicaAgregada(HistoriaClinicaId entityId, Diagnostico diagnostico, Anamnesis anamnesis) {
        super("sofka.paciente.historiaClinicaAgregada");
        this.historiaClinicaId = entityId;
        this.diagnostico = diagnostico;
        this.anamnesis = anamnesis;
    }

    public HistoriaClinicaId getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

}
