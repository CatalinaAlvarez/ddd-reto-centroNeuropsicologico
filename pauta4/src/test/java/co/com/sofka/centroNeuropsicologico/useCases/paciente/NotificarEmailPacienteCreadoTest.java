package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacienteCreado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarEmailPacienteCreadoTest {

    @Mock
    SendEmailPacienteService sendEmailPacienteService;

    @Test
    void notificarEmailPacienteCreado() {
        PacienteId pacienteId = PacienteId.of("xxxx");
        Telefono telefono = new Telefono("1234567");
        var event = new PacienteCreado(telefono);
        event.setAggregateRootId(pacienteId.value());
        var usecase = new NotificarEmailPacienteCreado();

        when(sendEmailPacienteService.send(
                pacienteId,
                "facturacion@retencion-sofka.com.co",
                "Nuevo paciente creado"
        )).thenReturn(true);
        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(sendEmailPacienteService);
        usecase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(sendEmailPacienteService).send(
                pacienteId,
                "facturacion@retencion-sofka.com.co",
                "Nuevo paciente creado");
    }
}