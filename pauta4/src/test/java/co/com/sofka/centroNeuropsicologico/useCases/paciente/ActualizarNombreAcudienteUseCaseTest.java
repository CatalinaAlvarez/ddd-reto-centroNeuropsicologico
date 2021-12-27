package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.ActualizarNombreAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.AcudienteAgregado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.NombreAcudienteActualizado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacienteCreado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreAcudienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreAcudienteUseCaseTest(){

        //arrange
        PacienteId pacienteId = PacienteId.of("xxxx");
        AcudienteId acudienteId= AcudienteId.of("1");

        var command = new ActualizarNombreAcudiente(pacienteId,
                acudienteId,
                new Nombre("Pablo")
                );
        var useCase = new ActualizarNombreAcudienteUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (NombreAcudienteActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getAcudienteId().value());
        Assertions.assertEquals("Pablo", event.getNombre().value());

    }

    private List<DomainEvent> eventList(){
        return List.of(new PacienteCreado(new Telefono("1234567")
        ), new AcudienteAgregado(AcudienteId.of("1"),
                new Nombre("Pedro"),
                new Email("p@gmail.com"))
        );
    }

}