package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombrePacientePrincipal extends Command {

    private final PacienteId pacienteId;
    private final PacientePrincipalId pacientePrincipalId;
    private final Nombre nombre;

    public ActualizarNombrePacientePrincipal(PacienteId pacienteId, PacientePrincipalId entityId, Nombre nombre){

        this.pacienteId = pacienteId;
        this.pacientePrincipalId = entityId;
        this.nombre = nombre;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public PacientePrincipalId getPacientePrincipalId() {
        return pacientePrincipalId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
