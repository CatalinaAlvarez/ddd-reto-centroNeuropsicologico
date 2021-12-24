package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearPaciente extends Command {

    private final PacienteId pacienteId;
    private final Telefono telefono;

    public CrearPaciente(PacienteId entityId, Telefono telefono){

        this.pacienteId = entityId;
        this.telefono = telefono;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
