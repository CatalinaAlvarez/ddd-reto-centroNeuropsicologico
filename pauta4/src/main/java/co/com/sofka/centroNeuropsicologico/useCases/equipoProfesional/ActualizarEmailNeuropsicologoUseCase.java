package co.com.sofka.centroNeuropsicologico.useCases.equipoProfesional;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.EquipoProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.ActualizarEmailNeuropsicologo;

public class ActualizarEmailNeuropsicologoUseCase extends UseCase<RequestCommand<ActualizarEmailNeuropsicologo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEmailNeuropsicologo> actualizarEmailNeuropsicologoRequestCommand) {

        var command = actualizarEmailNeuropsicologoRequestCommand.getCommand();

        EquipoProfesional equipoProfesional;

        equipoProfesional = EquipoProfesional.from(
                command.getEquipoProfesionalId(),
                retrieveEvents());

        equipoProfesional.actualizarEmailNeuropsicologo(
                command.getNeuropsicologoId(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(equipoProfesional.getUncommittedChanges()));
    }
}
