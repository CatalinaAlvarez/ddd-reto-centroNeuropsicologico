package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NeuropsicologoAgregado extends DomainEvent {

    private final NeuropsicologoId neuropsicologoId;
    private final Nombre nombre;
    private final Email email;
    private final TarjetaProfesional tarjetaProfesional;

    public NeuropsicologoAgregado(NeuropsicologoId entityId, Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional) {
        super("sofka.equipoProfesional.neuropsicologoCambiado");
        this.neuropsicologoId = entityId;
        this.nombre = nombre;
        this.email = email;
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public NeuropsicologoId getNeuropsicologoId() {
        return neuropsicologoId;
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
