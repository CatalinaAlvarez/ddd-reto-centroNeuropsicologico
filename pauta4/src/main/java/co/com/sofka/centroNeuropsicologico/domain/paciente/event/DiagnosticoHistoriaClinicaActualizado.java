package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Diagnostico;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.HistoriaClinicaId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.DomainEvent;

public class DiagnosticoHistoriaClinicaActualizado extends DomainEvent {

    private final HistoriaClinicaId historiaClinicaId;
    private final Diagnostico diagnostico;

    public DiagnosticoHistoriaClinicaActualizado(HistoriaClinicaId entityId, Diagnostico diagnostico) {
        super("sofka.paciente.diagnosticoHistoriaClinicaActualizada");
        this.historiaClinicaId = entityId;
        this.diagnostico = diagnostico;
    }

    public HistoriaClinicaId getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
