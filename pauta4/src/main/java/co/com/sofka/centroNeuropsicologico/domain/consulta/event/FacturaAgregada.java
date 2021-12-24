package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.FacturaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturaAgregada extends DomainEvent {

    private final FacturaId id;
    private final Fecha fecha;
    private final Valor valor;

    public FacturaAgregada(FacturaId id, Fecha fecha, Valor valor) {
        super("sofka.consulta.facturaAgregada");
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
    }

    public FacturaId getId() {
        return id;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Valor getValor() {
        return valor;
    }
}
