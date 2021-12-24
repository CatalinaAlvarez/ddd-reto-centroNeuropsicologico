package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.equipoProfesional;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.EquipoProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.ActualizarEmailNeuropsicologo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TipoEquipo;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;

public class ActualizarEmailNeuropsicologoUseCase extends UseCase<RequestCommand<ActualizarEmailNeuropsicologo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEmailNeuropsicologo> actualizarEmailNeuropsicologoRequestCommand) {

        var command = actualizarEmailNeuropsicologoRequestCommand.getCommand();

        EquipoProfesional equipoProfesional;

        equipoProfesional = new EquipoProfesional(
                new EquipoProfesionalId(),
                new TipoEquipo(TipoEquipo.Valor.INFANCIA)
        );

        equipoProfesional.agregarNeuropsicologo(
                new Nombre("Juan"),
                new Email("juan@gmail.com"),
                new TarjetaProfesional("14654655"));

        equipoProfesional.actualizarEmailNeuropsicologo(
                command.getNeuropsicologoId(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(equipoProfesional.getUncommittedChanges()));
    }
}
