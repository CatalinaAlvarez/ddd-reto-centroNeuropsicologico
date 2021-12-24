package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoCita extends Command {

    private final ConsultaId consultaId;
    private final CitaId citaId;
    private final Tipo tipo;

    public ActualizarTipoCita(ConsultaId consultaId, CitaId entityId, Tipo tipo) {

        this.consultaId = consultaId;
        this.citaId = entityId;
        this.tipo = tipo;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
