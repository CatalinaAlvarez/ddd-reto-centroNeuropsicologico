package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.FacturaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorFacturaActualizado extends DomainEvent {

    private final FacturaId entityId;
    private final Valor valor;

    public ValorFacturaActualizado(FacturaId entityId, Valor valor) {
        super("sofka.consulta.valorFacturaActualizado");

        this.entityId = entityId;
        this.valor = valor;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Valor getValor() {
        return valor;
    }
}
