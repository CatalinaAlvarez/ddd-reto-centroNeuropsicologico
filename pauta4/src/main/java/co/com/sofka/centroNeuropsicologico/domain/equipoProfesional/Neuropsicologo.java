package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Neuropsicologo extends Entity<NeuropsicologoId> {

    protected Nombre nombre;
    protected Email email;
    protected Set<Estudio> estudios;
    protected TarjetaProfesional tarjetaProfesional;

    public Neuropsicologo(NeuropsicologoId entityId, Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
        this.tarjetaProfesional = Objects.requireNonNull(tarjetaProfesional);
        this.estudios = new HashSet<>();
    }

    public void actualizarEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }

    public void agregarEstudio(Estudio estudio){
        Objects.requireNonNull(estudio);
        this.estudios.add(estudio);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Set<Estudio> estudios() {
        return estudios;
    }

    public TarjetaProfesional tarjetaProfesional() {
        return tarjetaProfesional;
    }
}
