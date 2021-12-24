package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarPacientePrincipal;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacientePrincipalAgregado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Edad;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacientePrincipalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AgregarPacientePrincipalUseCaseTest {

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

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (PacientePrincipalAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Juan Pérez", event.getNombre().value());
        Assertions.assertEquals(15, event.getEdad().value());

    }


}