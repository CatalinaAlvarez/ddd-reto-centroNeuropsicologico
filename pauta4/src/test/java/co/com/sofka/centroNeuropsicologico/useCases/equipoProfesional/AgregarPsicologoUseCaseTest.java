package co.com.sofka.centroNeuropsicologico.useCases.equipoProfesional;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.AgregarPsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.EquipoProfesionalCreado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.PsicologoAgregado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
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
class AgregarPsicologoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void psicologoAgregadoUseCaseTest(){

        //arrange
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("xxxx");
        PsicologoId psicologoId = new PsicologoId();
        Nombre nombre = new Nombre("Claudia");
        Email email = new Email("claudia@gmail.com");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("15987455");

        var command = new AgregarPsicologo(equipoProfesionalId, psicologoId, nombre, email, tarjetaProfesional);
        var useCase = new AgregarPsicologoUseCase();

        //act
        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(equipoProfesionalId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (PsicologoAgregado)events.getDomainEvents().get(0);
        Assertions.assertEquals("Claudia", event.getNombre().value());
        Assertions.assertEquals("claudia@gmail.com", event.getEmail().value());
        Assertions.assertEquals("15987455", event.getTarjetaProfesional().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }


    @Test
    void psicologoAgregadoErrorUseCaseTest(){

        //arrange
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("xxxx");
        PsicologoId psicologoId = new PsicologoId();
        Nombre nombre = new Nombre("Claudia");
        Email email = new Email("claudia@gmail.com");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("15987455");


        var command = new AgregarPsicologo(equipoProfesionalId, psicologoId, nombre, email, tarjetaProfesional);
        var useCase = new AgregarPsicologoUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventListError());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, ()->{
            UseCaseHandler.getInstance().setIdentifyExecutor(equipoProfesionalId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new EquipoProfesionalCreado(EquipoProfesionalId.of("xxxx"),
                new TipoEquipo(TipoEquipo.Valor.INFANCIA)
                ));
    }

    private List<DomainEvent> eventListError(){
        return List.of(new EquipoProfesionalCreado(EquipoProfesionalId.of("xxxx"),
                new TipoEquipo(TipoEquipo.Valor.INFANCIA)
        ),new PsicologoAgregado(PsicologoId.of("1"),
                new Nombre("Cata"),
                new Email("cata@gmail.com"),
                new TarjetaProfesional("1546846"))
        );
    }

}