package co.com.sofka.centroNeuropsicologico.domain.paciente.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ConsultaAgregada extends DomainEvent {

    private final ConsultaId consultaId;

    public ConsultaAgregada(ConsultaId consultaId) {
        super("sofka.paciente.consultaAgregada");
        this.consultaId = consultaId;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }
}
