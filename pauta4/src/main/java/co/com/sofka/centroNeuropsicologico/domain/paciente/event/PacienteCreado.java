package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.paciente.Acudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.HistoriaClinica;
import co.com.sofka.centroNeuropsicologico.domain.paciente.PacientePrincipal;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteCreado extends DomainEvent {

    private final Telefono telefono;


    public PacienteCreado(Telefono telefono) {
        super("sofka.paciente.pacienteCreado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
