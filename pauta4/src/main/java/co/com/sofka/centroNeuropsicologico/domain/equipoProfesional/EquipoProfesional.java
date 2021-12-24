package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.*;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.*;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class EquipoProfesional extends AggregateEvent<EquipoProfesionalId> {

    protected Psicologo psicologo;
    protected Neuropsicologo neuropsicologo;
    protected TerapeutaOcupacional terapeutaOcupacional;
    protected TipoEquipo tipoEquipo;

    public EquipoProfesional(EquipoProfesionalId entityId, TipoEquipo tipoEquipo) {
        super(entityId);
        appendChange(new EquipoProfesionalCreado(entityId, tipoEquipo)).apply();
    }

    private EquipoProfesional(EquipoProfesionalId equipoProfesionalId){
        super(equipoProfesionalId);
        subscribe(new EquipoProfesionalChange(this));
    }

    public static EquipoProfesional from(EquipoProfesionalId entityId, List<DomainEvent> events){
        var equipoProfesional = new EquipoProfesional(entityId);
        events.forEach(equipoProfesional::applyEvent);
        return equipoProfesional;
    }

    public void agregarPsicologo(Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional){
        var id = new PsicologoId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        Objects.requireNonNull(tarjetaProfesional);
        appendChange(new PsicologoAgregado(id, nombre, email, tarjetaProfesional)).apply();
    }

    public void agregarNeuropsicologo(Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional){
        var id = new NeuropsicologoId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        Objects.requireNonNull(tarjetaProfesional);
        appendChange(new NeuropsicologoAgregado(id, nombre, email, tarjetaProfesional)).apply();
    }

    public void agregarTerapeutaOcupacional(Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional){
        var id = new TerapeutaOcupacionalId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        Objects.requireNonNull(tarjetaProfesional);
        appendChange(new TerapeutaOcupacionalAgregado(id, nombre, email, tarjetaProfesional)).apply();
    }

    public void actualizarEmailPsicologo(PsicologoId entityId, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(email);
        appendChange(new EmailPsicologoActualizado(entityId, email)).apply();
    }

    public void agregarEstudioPsicologo(PsicologoId entityId, Estudio estudio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(estudio);
        appendChange(new EstudioPsicologoAgregado(entityId, estudio)).apply();
    }

    public void actualizarEmailNeuropsicologo(NeuropsicologoId entityId, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(email);
        appendChange(new EmailNeuropsicologoActualizado(entityId, email)).apply();
    }

    public void agregarEstudioNeuropsicologo(NeuropsicologoId entityId, Estudio estudio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(estudio);
        appendChange(new EstudioNeuropsicologoAgregado(entityId, estudio)).apply();
    }

    public void actualizarEmailTerapeutaOcupacional(TerapeutaOcupacionalId entityId, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(email);
        appendChange(new EmailTerapeutaOcupacionalActualizado(entityId, email)).apply();
    }

    public void agregarEstudioTerapeutaOcupacional(TerapeutaOcupacionalId entityId, Estudio estudio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(estudio);
        appendChange(new EstudioTerapeutaOcupacionalAgregado(entityId, estudio)).apply();
    }


    public Psicologo psicologo() {
        return psicologo;
    }

    public Neuropsicologo neuropsicologo() {
        return neuropsicologo;
    }

    public TerapeutaOcupacional terapeutaOcupacional() {
        return terapeutaOcupacional;
    }

    public TipoEquipo tipoEquipo() {
        return tipoEquipo;
    }
}
