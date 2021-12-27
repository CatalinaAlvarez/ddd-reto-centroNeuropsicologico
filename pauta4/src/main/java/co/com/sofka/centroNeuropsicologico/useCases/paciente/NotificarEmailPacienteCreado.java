package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacienteCreado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;

import java.util.List;

public class NotificarEmailPacienteCreado extends UseCase<TriggeredEvent<PacienteCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PacienteCreado> pacienteCreadoTriggeredEvent) {
        var event = pacienteCreadoTriggeredEvent.getDomainEvent();

        var service = getService(SendEmailPacienteService.class).orElseThrow();

        boolean isValid = service.send(
                PacienteId.of(event.aggregateRootId()),
                "facturacion@retencion-sofka.com.co",
                "Nuevo paciente creado"
        );

        if(!isValid){
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar el correo");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
