package co.com.sofka.centroNeuropsicologico.useCases.equipoProfesional;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.ActualizarEmailNeuropsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.EmailNeuropsicologoActualizado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.EquipoProfesionalCreado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.NeuropsicologoAgregado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TipoEquipo;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
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
class ActualizarEmailNeuropsicologoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarEmailNeuropsicologicoUseCaseTest(){

        //arrange
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("xxxx");
        NeuropsicologoId neuropsicologoId = NeuropsicologoId.of("1");

        var command = new ActualizarEmailNeuropsicologo(
            equipoProfesionalId,
                neuropsicologoId,
                new Email("clau@gmail.com")
        );

        var useCase = new ActualizarEmailNeuropsicologoUseCase();

        //act
        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (EmailNeuropsicologoActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getNeuropsicologoId().value());
        Assertions.assertEquals("clau@gmail.com", event.getEmail().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new EquipoProfesionalCreado(EquipoProfesionalId.of("xxxx"),
                new TipoEquipo(TipoEquipo.Valor.INFANCIA)
        ), new NeuropsicologoAgregado(NeuropsicologoId.of("1"),
                new Nombre("Claudia"),
                new Email("claudia@gmail.com"),
                new TarjetaProfesional("15987455"))
        );
    }
}