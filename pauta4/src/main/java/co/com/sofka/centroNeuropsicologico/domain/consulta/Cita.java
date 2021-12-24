package co.com.sofka.centroNeuropsicologico.domain.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cita extends Entity<CitaId> {

    protected Tipo tipo;
    protected Duracion duracion;

    public Cita(CitaId entityId, Tipo tipo, Duracion duracion) {
        super(entityId);
        this.tipo = Objects.requireNonNull(tipo);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public void actualizarTipo(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }

    public void actualizarDuracion(Duracion duracion){
        this.duracion = Objects.requireNonNull(duracion);
    }

    public Tipo tipo() {
        return tipo;
    }

    public Duracion duracion() {
        return duracion;
    }
}
