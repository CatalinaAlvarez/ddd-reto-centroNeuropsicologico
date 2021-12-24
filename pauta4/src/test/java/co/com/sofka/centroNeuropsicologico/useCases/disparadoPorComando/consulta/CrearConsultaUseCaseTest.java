package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.CrearConsulta;
import co.com.sofka.centroNeuropsicologico.domain.consulta.event.ConsultaCreada;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


class CrearConsultaUseCaseTest {

    @Test
    void crearConsultaUseCaseTest() {

        //arrange
        ConsultaId consultaId = ConsultaId.of("xxxx");
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("y");
        Fecha fecha = new Fecha(new Date());

        var command = new CrearConsulta(consultaId, equipoProfesionalId, fecha);
        var useCase = new CrearConsultaUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (ConsultaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("y", event.getEquipoProfesionalId().value());
    }

}