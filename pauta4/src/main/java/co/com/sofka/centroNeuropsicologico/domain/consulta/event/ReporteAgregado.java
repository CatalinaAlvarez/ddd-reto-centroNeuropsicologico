package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ReporteAgregado extends DomainEvent {

    private final ReporteId reporteId;
    private final Comentario comentario;

    public ReporteAgregado(ReporteId entityId, Comentario comentario) {
        super("sofka.consulta.reporteAgregado");
        reporteId = entityId;
        this.comentario = comentario;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
