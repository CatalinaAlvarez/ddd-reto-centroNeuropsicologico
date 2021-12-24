package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.equipoProfesional;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.ActualizarEmailNeuropsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.AgregarNeuropsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.AgregarPsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.EmailNeuropsicologoActualizado;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
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

class ActualizarEmailNeuropsicologoUseCaseTest {

    @Test
    void actualizarEmailNeuropsicologicoUseCaseTest(){
        //arrange
        EquipoProfesionalId equipoProfesionalId = EquipoProfesionalId.of("xxxx");
        NeuropsicologoId neuropsicologoId = new NeuropsicologoId();
        Nombre nombre = new Nombre("Claudia");
        Email email = new Email("claudia@gmail.com");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("15987455");

        var neuropsicologo = new AgregarNeuropsicologo(equipoProfesionalId,
                neuropsicologoId, nombre, email, tarjetaProfesional);

        var command = new ActualizarEmailNeuropsicologo(
            equipoProfesionalId,
                neuropsicologoId,
                new Email("clau@gmail.com")
        );

        var useCase = new ActualizarEmailNeuropsicologoUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (EmailNeuropsicologoActualizado) events.getDomainEvents().get(2);
        Assertions.assertEquals("clau@gmail.com", event.getEmail().value());

    }

}