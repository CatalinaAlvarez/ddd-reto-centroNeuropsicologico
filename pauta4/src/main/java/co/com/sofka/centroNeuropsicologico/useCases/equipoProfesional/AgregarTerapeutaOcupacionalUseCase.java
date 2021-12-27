package co.com.sofka.centroNeuropsicologico.useCases.equipoProfesional;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.EquipoProfesional;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command.AgregarTerapeutaOcupacional;

public class AgregarTerapeutaOcupacionalUseCase extends UseCase<RequestCommand<AgregarTerapeutaOcupacional>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarTerapeutaOcupacional> agregarTerapeutaOcupacionalRequestCommand) {
        var command = agregarTerapeutaOcupacionalRequestCommand.getCommand();

        EquipoProfesional equipoProfesional;

        equipoProfesional = EquipoProfesional.from(command.getEquipoProfesionalId(),
                retrieveEvents());

        equipoProfesional.agregarTerapeutaOcupacional(
                command.getNombre(),
                command.getEmail(),
                command.getTarjetaProfesional());

        emit().onResponse(new ResponseEvents(equipoProfesional.getUncommittedChanges()));
    }
}
