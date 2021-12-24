package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.domain.generic.Command;

public class ActualizarDuracionCita extends Command {

    private final ConsultaId consultaId;
    private final CitaId citaId;
    private final Duracion duracion;

    public ActualizarDuracionCita(ConsultaId consultaId, CitaId entityId, Duracion duracion) {

        this.consultaId = consultaId;
        this.citaId = entityId;
        this.duracion = duracion;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
