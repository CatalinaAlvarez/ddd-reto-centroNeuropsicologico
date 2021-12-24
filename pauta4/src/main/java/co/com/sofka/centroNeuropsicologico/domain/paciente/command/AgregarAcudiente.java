package co.com.sofka.centroNeuropsicologico.domain.paciente.command;

import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.domain.generic.Command;

public class AgregarAcudiente extends Command {

    private final PacienteId pacienteId;
    private final AcudienteId acudienteId;
    private final Nombre nombre;
    private final Email email;

    public AgregarAcudiente(PacienteId pacienteId, AcudienteId entityId, Nombre nombre, Email email){

        this.pacienteId = pacienteId;
        this.acudienteId = entityId;
        this.nombre = nombre;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }
}
