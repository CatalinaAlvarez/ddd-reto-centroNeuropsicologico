package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreAcudiente extends Command {

    private PacienteId pacienteId;
    private AcudienteId acudienteId;
    private Nombre nombre;

    public ActualizarNombreAcudiente(PacienteId pacienteId, AcudienteId entityId, Nombre nombre){

        this.pacienteId = pacienteId;
        this.acudienteId = entityId;
        this.nombre = nombre;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public AcudienteId getAcudienteId() {
        return acudienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
