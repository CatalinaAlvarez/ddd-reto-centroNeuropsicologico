package co.com.sofka.centroNeuropsicologico.domain.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Comentario;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ReporteId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Reporte extends Entity<ReporteId> {

    protected Comentario comentario;

    public Reporte(ReporteId entityId, Comentario comentario) {
        super(entityId);
        this.comentario = Objects.requireNonNull(comentario);
    }

    public void actualizarComentario(Comentario comentario){
        this.comentario = Objects.requireNonNull(comentario);
    }


    public Comentario comentario() {
        return comentario;
    }

}
