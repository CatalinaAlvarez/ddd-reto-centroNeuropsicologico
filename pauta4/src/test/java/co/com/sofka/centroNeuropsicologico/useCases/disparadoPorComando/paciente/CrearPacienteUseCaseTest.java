package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.CrearPaciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacienteCreado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPacienteUseCaseTest {

    @Test
    void crearPacienteUseCaseTest(){

        //arrange
        PacienteId pacienteId = PacienteId.of("xxxx");
        Telefono telefono = new Telefono("123456789");

        var command = new CrearPaciente(pacienteId, telefono);
        var useCase = new CrearPacienteUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        PacienteCreado event = (PacienteCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("123456789", event.getTelefono().value());


    }


}