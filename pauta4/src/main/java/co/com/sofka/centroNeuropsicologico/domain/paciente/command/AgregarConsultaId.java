package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class AgregarConsultaId extends Command {

    private PacienteId pacienteId;
    private ConsultaId consultaId;

    public AgregarConsultaId(PacienteId pacienteId, ConsultaId consultaId){

        this.pacienteId = pacienteId;
        this.consultaId = consultaId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }
}
