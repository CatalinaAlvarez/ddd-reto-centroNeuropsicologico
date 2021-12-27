package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarPacientePrincipal;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacienteCreado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacientePrincipalAgregado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarPacientePrincipalUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarPacientePrincipalUseCaseTest() {

        //arrange
        PacienteId pacienteId = PacienteId.of("xxxx");
        PacientePrincipalId pacientePrincipalId = new PacientePrincipalId();
        Nombre nombre = new Nombre("Juan Pérez");
        Edad edad = new Edad(15);

        var command = new AgregarPacientePrincipal(pacienteId, pacientePrincipalId, nombre, edad);
        var useCase = new AgregarPacientePrincipalUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (PacientePrincipalAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Juan Pérez", event.getNombre().value());
        Assertions.assertEquals(15, event.getEdad().value());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> eventList(){
        return List.of(new PacienteCreado(new Telefono("1234567")
        ));
    }
}