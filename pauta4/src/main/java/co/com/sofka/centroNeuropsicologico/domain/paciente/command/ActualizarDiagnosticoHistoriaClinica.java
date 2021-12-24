package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Diagnostico;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.HistoriaClinicaId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDiagnosticoHistoriaClinica extends Command {

    private final PacienteId pacienteId;
    private final HistoriaClinicaId historiaClinicaId;
    private final Diagnostico diagnostico;

    public ActualizarDiagnosticoHistoriaClinica(PacienteId pacienteId, HistoriaClinicaId entityId, Diagnostico diagnostico){

        this.pacienteId = pacienteId;
        this.historiaClinicaId = entityId;
        this.diagnostico = diagnostico;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public HistoriaClinicaId getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
