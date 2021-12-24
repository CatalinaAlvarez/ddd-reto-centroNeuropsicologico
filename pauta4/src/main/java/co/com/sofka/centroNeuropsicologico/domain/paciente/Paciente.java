package co.com.sofka.centroNeuropsicologico.domain.paciente;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.*;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.*;

public class Paciente extends AggregateEvent<PacienteId> {

    protected Set<ConsultaId> consultas;
    protected Acudiente acudiente;
    protected PacientePrincipal pacientePrincipal;
    protected HistoriaClinica historiaClinica;
    protected Telefono telefono;


    public Paciente(PacienteId entityId, Telefono telefono) {
        super(entityId);
        this.telefono = Objects.requireNonNull(telefono);
        appendChange(new PacienteCreado(telefono)).apply();
    }

    private Paciente(PacienteId pacienteId){
        super(pacienteId);
        subscribe(new PacienteChange(this));

    }

    public static Paciente from(PacienteId entityId, List<DomainEvent> events){
        var paciente = new Paciente(entityId);
        events.forEach(paciente::applyEvent);
        return paciente;
    }

    public void agregarAcudiente(Nombre nombre, Email email){
        var id = new AcudienteId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        appendChange(new AcudienteAgregado(id, nombre, email)).apply();
    }

    public void agregarPacientePrincipal(Nombre nombre, Edad edad){
        var id = new PacientePrincipalId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        appendChange(new PacientePrincipalAgregado(id, nombre, edad)).apply();
    }

    public void agregarHistoriaClinica(Diagnostico diagnostico, Anamnesis anamnesis){
        var id = new HistoriaClinicaId();
        Objects.requireNonNull(diagnostico);
        Objects.requireNonNull(anamnesis);
        appendChange(new HistoriaClinicaAgregada(id, diagnostico, anamnesis)).apply();
    }

    public void agregarConsultaId(ConsultaId consultaId){
        Objects.requireNonNull(consultaId);
        appendChange(new ConsultaAgregada(consultaId)).apply();
    }

    public void actualizarNombreAcudiente(AcudienteId entityId, Nombre nombre){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        appendChange(new NombreAcudienteActualizado(entityId, nombre)).apply();
    }

    public void actualizarEmailAcudiente(AcudienteId entityId, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(email);
        appendChange(new EmailAcudienteActualizado(entityId, email)).apply();
    }

    public void actualizarNombrePacientePrincipal(PacientePrincipalId entityId, Nombre nombre){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        appendChange(new NombrePacientePrincipalActualizado(entityId, nombre)).apply();
    }

    public void actualizarEdadPacientePrincipal(PacientePrincipalId entityId, Edad edad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(edad);
        appendChange(new EdadPacientePrincipalActualizada(entityId, edad)).apply();
    }

    public void actualizarDiagnosticoHistoriaClinica(HistoriaClinicaId entityId, Diagnostico diagnostico){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(diagnostico);
        appendChange(new DiagnosticoHistoriaClinicaActualizado(entityId, diagnostico)).apply();
    }

    public Optional<ConsultaId> getConsulta(ConsultaId entityId){
        return consultas
                .stream()
                .filter(consulta -> consulta.equals(entityId))
                .findFirst();
    }

    public Set<ConsultaId> getConsultas() {
        return consultas;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public PacientePrincipal getPacientePrincipal() {
        return pacientePrincipal;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }
}
