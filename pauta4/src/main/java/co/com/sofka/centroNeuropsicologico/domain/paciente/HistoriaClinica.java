package co.com.sofka.centroNeuropsicologico.domain.paciente;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Anamnesis;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Diagnostico;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.HistoriaClinicaId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class HistoriaClinica extends Entity<HistoriaClinicaId> {

    protected Diagnostico diagnostico;
    protected Anamnesis anamnesis;

    public HistoriaClinica(HistoriaClinicaId entityId, Diagnostico diagnostico, Anamnesis anamnesis) {
        super(entityId);
        this.diagnostico = Objects.requireNonNull(diagnostico);
        this.anamnesis = Objects.requireNonNull(anamnesis);
    }

    public void actualizarDiagnostico(Diagnostico diagnostico){
        this.diagnostico = Objects.requireNonNull(diagnostico);
    }

    public Diagnostico diagnostico() {
        return diagnostico;
    }

    public Anamnesis anamnesis() {
        return anamnesis;
    }
}
