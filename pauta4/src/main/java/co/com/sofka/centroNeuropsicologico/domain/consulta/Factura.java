package co.com.sofka.centroNeuropsicologico.domain.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.FacturaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Valor;
import co.com.sofka.domain.generic.Entity;

public class Factura extends Entity<FacturaId> {

    protected Fecha fecha;
    protected Valor valor;

    public Factura(FacturaId entityId, Fecha fecha, Valor valor) {
        super(entityId);
        this.fecha = fecha;
        this.valor = valor;
    }

    public void actualizarValor(Valor valor){
        this.valor = valor;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Valor valor() {
        return valor;
    }
}
