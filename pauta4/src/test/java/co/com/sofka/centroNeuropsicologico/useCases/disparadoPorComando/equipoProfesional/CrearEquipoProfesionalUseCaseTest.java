package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.equipoProfesional;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.CrearEquipoProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.EquipoProfesionalCreado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TipoEquipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CrearEquipoProfesionalUseCaseTest {

    @Test
    void crearEquipoProfesionalUseCaseTest(){

        //arrange
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("xxxx");
        TipoEquipo tipoEquipo = new TipoEquipo(TipoEquipo.Valor.INFANCIA);

        var command = new CrearEquipoProfesional(equipoProfesionalId, tipoEquipo);
        var useCase = new CrearEquipoProfesionalUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (EquipoProfesionalCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(TipoEquipo.Valor.INFANCIA, event.getTipoEquipo().value());
    }

}