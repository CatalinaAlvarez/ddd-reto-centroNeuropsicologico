package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Comentario;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ReporteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ComentarioReporteActualizado extends DomainEvent {

    private final ReporteId reporteId;
    private final Comentario comentario;

    public ComentarioReporteActualizado(ReporteId entityId, Comentario comentario) {
        super("sofka.consulta.comentarioReporteActualizado");
        this.reporteId = entityId;
        this.comentario = comentario;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
