package co.com.sofka.centroNeuropsicologico.domain.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.event.*;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.*;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Consulta extends AggregateEvent<ConsultaId> {

    protected EquipoProfesionalId equipoProfesionalId;
    protected Cita cita;
    protected Factura factura;
    protected Reporte reporte;
    protected Fecha fecha;

    public Consulta(ConsultaId entityId, EquipoProfesionalId equipoProfesionalId, Fecha fecha) {
        super(entityId);
        this.fecha = fecha;
        appendChange(new ConsultaCreada(entityId, equipoProfesionalId, fecha)).apply();
    }

    private Consulta(ConsultaId consultaId){
        super(consultaId);
        subscribe(new ConsultaChange(this));

    }

    public static Consulta from(ConsultaId consultaId, List<DomainEvent> events){
        var consulta = new Consulta(consultaId);
        events.forEach(consulta::applyEvent);
        return consulta;
    }

    public void agregarFactura(Fecha fecha, Valor valor){
        var id = new FacturaId();
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(valor);
        appendChange(new FacturaAgregada(id, fecha, valor)).apply();
    }

    public void agregarCita(Tipo tipo, Duracion duracion){
        var id = new CitaId();
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(duracion);
        appendChange(new CitaAgregada(id, tipo, duracion)).apply();
    }

    public void agregarReporte(Comentario comentario){
        var id = new ReporteId();
        Objects.requireNonNull(comentario);
        appendChange(new ReporteAgregado(id, comentario)).apply();
    }

    public void actualizarTipoCita(CitaId entityId, Tipo tipo){
        appendChange(new TipoCitaActualizado(entityId, tipo)).apply();
    }

    public void actualizarDuracionCita(CitaId entityId, Duracion duracion){
        appendChange(new DuracionCitaActualizada(entityId, duracion)).apply();
    }

    public void actualizarValorFactura(FacturaId entityId, Valor valor){
        appendChange(new ValorFacturaActualizado(entityId, valor)).apply();
    }

    public void actualizarComentarioReporte(ReporteId entityId, Comentario comentario){
        appendChange(new ComentarioReporteActualizado(entityId, comentario)).apply();
    }

    public EquipoProfesionalId equipoProfesionalId() {
        return equipoProfesionalId;
    }

    public Cita cita() {
        return cita;
    }

    public Factura factura() {
        return factura;
    }

    public Reporte reporte() {
        return reporte;
    }

    public Fecha fecha() {
        return fecha;
    }

}
