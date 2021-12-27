package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.Factura;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.FacturaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Valor;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorFactura extends Command {

    private ConsultaId consultaId;
    private FacturaId facturaId;
    private Valor valor;

    public void actualizarValorFactura(ConsultaId consultaId, FacturaId entityId, Valor valor){
        this.consultaId = consultaId;
        facturaId = entityId;
        this.valor = valor;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Valor getValor() {
        return valor;
    }
}
