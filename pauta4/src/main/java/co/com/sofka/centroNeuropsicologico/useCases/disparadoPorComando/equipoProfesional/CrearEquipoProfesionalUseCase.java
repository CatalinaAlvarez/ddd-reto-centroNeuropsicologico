package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.equipoProfesional;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.EquipoProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.CrearEquipoProfesional;

public class CrearEquipoProfesionalUseCase extends UseCase<RequestCommand<CrearEquipoProfesional>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEquipoProfesional> crearEquipoProfesionalRequestCommand) {

        var command = crearEquipoProfesionalRequestCommand.getCommand();

        EquipoProfesional equipoProfesional;

        equipoProfesional = new EquipoProfesional(
                command.getEquipoProfesionalId(),
                command.getTipoEquipo()
        );

        emit().onResponse(new ResponseEvents(equipoProfesional.getUncommittedChanges()));
    }
}
