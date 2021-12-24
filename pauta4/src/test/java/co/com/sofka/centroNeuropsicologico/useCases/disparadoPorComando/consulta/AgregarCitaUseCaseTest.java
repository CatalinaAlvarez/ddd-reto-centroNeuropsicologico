package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.AgregarCita;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.CitaAgregada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarPacientePrincipal;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.PacientePrincipalAgregado;
import co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente.AgregarPacientePrincipalUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgregarCitaUseCaseTest {

    @Test
    void agregarCitaUseCaseTest(){

        //arrange
        ConsultaId consultaId = ConsultaId.of("xxxx");
        CitaId citaId = new CitaId();
        Tipo tipo = new Tipo(Tipo.Valor.REHABILITACION_COGNITIVA);
        Duracion duracion = new Duracion(45);

        var command = new AgregarCita(consultaId, citaId, tipo, duracion);
        var useCase = new AgregarCitaUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (CitaAgregada) events.getDomainEvents().get(1);
        Assertions.assertEquals(Tipo.Valor.REHABILITACION_COGNITIVA, event.getTipo().value());
        Assertions.assertEquals(45, event.getDuracion().value());
    }

}