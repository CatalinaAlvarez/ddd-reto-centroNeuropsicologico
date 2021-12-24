package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.ActualizarDuracionCita;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.AgregarCita;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.DuracionCitaActualizada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.ActualizarNombreAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.event.NombreAcudienteActualizado;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.AcudienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente.ActualizarNombreAcudienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActualizarDuracionCitaUseCaseTest {

    @Test
    void actualizarDuracionCitaUseCaseTest(){

        //arrange

        ConsultaId consultaId = ConsultaId.of("xxxx");
        CitaId citaId = new CitaId();
        Tipo tipo = new Tipo(Tipo.Valor.REHABILITACION_COGNITIVA);
        Duracion duracion = new Duracion(45);


        var cita = new AgregarCita(consultaId, citaId, tipo, duracion);

        var command = new ActualizarDuracionCita(consultaId, citaId, new Duracion(30));
        var useCase = new ActualizarDuracionCitaUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (DuracionCitaActualizada) events.getDomainEvents().get(2);
        Assertions.assertEquals(30, event.getDuracion().value());
    }

}