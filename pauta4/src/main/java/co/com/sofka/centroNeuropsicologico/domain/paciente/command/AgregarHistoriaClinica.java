package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Anamnesis;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Diagnostico;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.HistoriaClinicaId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class AgregarHistoriaClinica extends Command {

    private PacienteId pacienteId;
    private HistoriaClinicaId historiaClinicaId;
    private Diagnostico diagnostico;
    private Anamnesis anamnesis;

    public AgregarHistoriaClinica(PacienteId pacienteId, HistoriaClinicaId entityId, Diagnostico diagnostico, Anamnesis anamnesis){

        this.pacienteId = pacienteId;
        this.historiaClinicaId = entityId;
        this.diagnostico = diagnostico;
        this.anamnesis = anamnesis;
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

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }
}
