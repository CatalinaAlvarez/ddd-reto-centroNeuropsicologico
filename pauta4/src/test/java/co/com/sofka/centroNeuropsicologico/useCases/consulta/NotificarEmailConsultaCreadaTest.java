package co.com.sofka.centroNeuropsicologico.useCases.consulta;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.ConsultaCreada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarEmailConsultaCreadaTest {

    @Mock
    SendEmailService sendEmailService;

    @Test
    void notificarEmailConsultaCreada(){
        ConsultaId consultaId = ConsultaId.of("xxxx");
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("yyy");
        Fecha fecha = new Fecha(new Date());
        var event = new ConsultaCreada(consultaId, equipoProfesionalId, fecha);
        event.setAggregateRootId(consultaId.value());
        var usecase = new NotificarEmailConsultaCreada();

        when(sendEmailService.send(
                consultaId,
                "facturacion@contabilidad-sofka.com.co",
                "Nueva consulta creada"
        )).thenReturn(true);
        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(sendEmailService);
        usecase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(sendEmailService).send(
                consultaId,
                "facturacion@contabilidad-sofka.com.co",
                "Nueva consulta creada");
    }
}