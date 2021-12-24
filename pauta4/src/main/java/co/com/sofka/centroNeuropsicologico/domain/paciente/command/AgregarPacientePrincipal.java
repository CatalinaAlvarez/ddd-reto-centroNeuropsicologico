package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.domain.generic.Command;

public class AgregarPacientePrincipal extends Command {

    private final PacienteId pacienteId;
    private final PacientePrincipalId pacientePrincipalId;
    private final Nombre nombre;
    private final Edad edad;

    public AgregarPacientePrincipal(PacienteId pacienteId, PacientePrincipalId entityId, Nombre nombre, Edad edad){

        this.pacienteId = pacienteId;
        this.pacientePrincipalId = entityId;
        this.nombre = nombre;
        this.edad = edad;
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

    public Edad getEdad() {
        return edad;
    }
}
