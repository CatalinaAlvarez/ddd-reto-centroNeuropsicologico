package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Comentario;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ReporteId;
import co.com.sofka.domain.generic.Command;

public class AgregarReporte extends Command {

    private ConsultaId consultaId;
    private ReporteId reporteId;
    private Comentario comentario;

    public AgregarReporte(ConsultaId consultaId, ReporteId entityId, Comentario comentario){

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
