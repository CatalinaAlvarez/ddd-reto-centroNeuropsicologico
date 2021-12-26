package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.ActualizarDuracionCita;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.CitaAgregada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.ConsultaCreada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.DuracionCitaActualizada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.*;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDuracionCitaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDuracionCitaUseCaseTest(){

        //arrange

        ConsultaId consultaId = ConsultaId.of("xxxx");
        CitaId citaId = CitaId.of("1");

        var command = new ActualizarDuracionCita(consultaId, citaId, new Duracion(30));
        var useCase = new ActualizarDuracionCitaUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (DuracionCitaActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getCitaId().value());
        Assertions.assertEquals(30, event.getDuracion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new ConsultaCreada(
                        ConsultaId.of("xxxx"),
                        EquipoProfesionalId.of("yyyy"),
                        new Fecha(new Date())
                ),new CitaAgregada(
                        CitaId.of("1"),
                        new Tipo(Tipo.Valor.REHABILITACION_COGNITIVA),
                        new Duracion(45))
        );
    }

}