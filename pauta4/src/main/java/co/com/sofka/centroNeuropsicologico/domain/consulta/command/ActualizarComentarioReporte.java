package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Comentario;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ReporteId;
import co.com.sofka.domain.generic.Command;

public class ActualizarComentarioReporte extends Command {

    private final ConsultaId consultaId;
    private final ReporteId reporteId;
    private final Comentario comentario;

    public ActualizarComentarioReporte(ConsultaId consultaId, ReporteId entityId, Comentario comentario){

        this.consultaId = consultaId;
        this.reporteId = entityId;
        this.comentario = comentario;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
