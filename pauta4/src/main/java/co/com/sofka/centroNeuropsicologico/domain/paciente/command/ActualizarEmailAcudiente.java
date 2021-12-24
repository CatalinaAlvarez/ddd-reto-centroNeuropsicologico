package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmailAcudiente extends Command {

    private final PacienteId pacienteId;
    private final AcudienteId acudienteId;
    private final Email email;

    public ActualizarEmailAcudiente(PacienteId pacienteId, AcudienteId entityId, Email email){

        this.pacienteId = pacienteId;
        this.acudienteId = entityId;
        this.email = email;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public AcudienteId getAcudienteId() {
        return acudienteId;
    }

    public Email getEmail() {
        return email;
    }
}
