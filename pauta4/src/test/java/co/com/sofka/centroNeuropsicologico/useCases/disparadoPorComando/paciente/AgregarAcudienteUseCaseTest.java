package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.AcudienteAgregado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AgregarAcudienteUseCaseTest {


    @Test
    void agregarAcudienteUseCaseTest(){

        //arrange
        PacienteId pacienteId = PacienteId.of("xxxx");
        AcudienteId acudienteId= new AcudienteId();
        Nombre nombre = new Nombre("Pedro");
        Email email = new Email("pedro@gmail.com");

        var command = new AgregarAcudiente(pacienteId, acudienteId, nombre, email);
        var useCase = new AgregarAcudienteUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (AcudienteAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Pedro", event.getNombre().value());
        Assertions.assertEquals("pedro@gmail.com", event.getEmail().value());

    }

}