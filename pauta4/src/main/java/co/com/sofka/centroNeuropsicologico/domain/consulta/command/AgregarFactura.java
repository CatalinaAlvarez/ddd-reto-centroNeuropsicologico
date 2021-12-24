package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.FacturaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Valor;
import co.com.sofka.domain.generic.Command;

public class AgregarFactura extends Command {

    private final ConsultaId consultaId;
    private final FacturaId facturaId;
    private final Fecha fecha;
    private final Valor valor;


    public AgregarFactura(ConsultaId consultaId, FacturaId facturaId, Fecha fecha, Valor valor){

        this.consultaId = consultaId;
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.valor = valor;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Valor getValor() {
        return valor;
    }
}
