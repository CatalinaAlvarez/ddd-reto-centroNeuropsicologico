package co.com.sofka.centroNeuropsicologico.domain.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.event.*;
import co.com.sofka.domain.generic.EventChange;

public class ConsultaChange extends EventChange {
    public ConsultaChange(Consulta consulta) {

        apply((ConsultaCreada event)->{
            consulta.equipoProfesionalId = event.getEquipoProfesionalId();
            consulta.fecha = event.getFecha();

        });

        apply((FacturaAgregada event)->{
            consulta.factura = new Factura(event.getId(),
                    event.getFecha(),
                    event.getValor());
        });

        apply((CitaAgregada event)->{
            consulta.cita = new Cita(event.getCitaId(),
                    event.getTipo(),
                    event.getDuracion());
        });

        apply((ReporteAgregado event)->{
            consulta.reporte = new Reporte(event.getReporteId(),
                    event.getComentario());
        });

        apply((TipoCitaActualizado event)->{
            consulta.cita.tipo = event.getTipo();
        });

        apply((DuracionCitaActualizada event)->{
            consulta.cita.duracion = event.getDuracion();
        });

        apply((ValorFacturaActualizado event)->{
            consulta.factura.valor = event.getValor();
        });

        apply((ComentarioReporteActualizado event)->{
            consulta.reporte.comentario = event.getComentario();
        });


    }
}
