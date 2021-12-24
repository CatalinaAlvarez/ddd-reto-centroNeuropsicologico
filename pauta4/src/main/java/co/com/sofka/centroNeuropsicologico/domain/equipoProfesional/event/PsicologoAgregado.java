package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class PsicologoAgregado extends DomainEvent {

    private final PsicologoId psicologoId;
    private final Nombre nombre;
    private final Email email;
    private final TarjetaProfesional tarjetaProfesional;

    public PsicologoAgregado(PsicologoId entityId, Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional) {
        super("sofka.equipoProfesional.psicologoCambiado");

        this.psicologoId = entityId;
        this.nombre = nombre;
        this.email = email;
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public TarjetaProfesional getTarjetaProfesional() {
        return tarjetaProfesional;
    }
}
