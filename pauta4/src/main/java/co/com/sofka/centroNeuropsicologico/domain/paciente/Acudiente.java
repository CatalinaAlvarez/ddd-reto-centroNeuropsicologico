package co.com.sofka.centroNeuropsicologico.domain.paciente;

import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Acudiente extends Entity<AcudienteId> {

    protected Nombre nombre;
    protected Email email;

    public Acudiente(AcudienteId entityId, Nombre nombre, Email email) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
    }

    public void actualizarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        this.nombre = nombre;
    }

    public void actualizarEmail(Email email){
        Objects.requireNonNull(email);
        this.email = email;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }
}
