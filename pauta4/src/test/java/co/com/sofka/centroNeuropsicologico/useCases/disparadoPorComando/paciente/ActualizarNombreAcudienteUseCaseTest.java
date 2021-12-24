package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.ActualizarNombreAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.NombreAcudienteActualizado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActualizarNombreAcudienteUseCaseTest {

    @Test
    void actualizarNombreAcudienteUseCaseTest(){

        //arrange
        PacienteId pacienteId = PacienteId.of("xxxx");
        AcudienteId acudienteId= new AcudienteId();
        Nombre nombre = new Nombre("Pedro");
        Email email = new Email("pedro@gmail.com");

        var acudiente = new AgregarAcudiente(pacienteId, acudienteId, nombre, email);

        var command = new ActualizarNombreAcudiente(pacienteId,
                acudienteId,
                new Nombre("Pablo")
                );
        var useCase = new ActualizarNombreAcudienteUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (NombreAcudienteActualizado) events.getDomainEvents().get(2);
        Assertions.assertEquals("Pablo", event.getNombre().value());

    }

}