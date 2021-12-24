package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEdadPacientePrincipal extends Command {

    private PacienteId pacienteId;
    private PacientePrincipalId pacientePrincipalId;
    private Edad edad;

    public ActualizarEdadPacientePrincipal(PacienteId pacienteId, PacientePrincipalId entityId, Edad edad){

        this.pacienteId = pacienteId;
        this.pacientePrincipalId = entityId;
        this.edad = edad;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public PacientePrincipalId getPacientePrincipalId() {
        return pacientePrincipalId;
    }

    public Edad getEdad() {
        return edad;
    }
}
