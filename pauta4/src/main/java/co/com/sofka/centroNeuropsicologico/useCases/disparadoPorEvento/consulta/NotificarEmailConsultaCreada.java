package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorEvento.consulta;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.ConsultaCreada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;

import java.util.List;

public class NotificarEmailConsultaCreada extends UseCase<TriggeredEvent<ConsultaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ConsultaCreada> consultaCreadaTriggeredEvent) {
        var event = consultaCreadaTriggeredEvent.getDomainEvent();

        var service = getService(SendEmailService.class).orElseThrow();

        boolean isValid = service.send(
                ConsultaId.of(event.aggregateRootId()),
                "facturacion@contabilidad-sofka.com.co",
                "Nueva consulta creada"
        );

        if(!isValid){
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar el correo");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
