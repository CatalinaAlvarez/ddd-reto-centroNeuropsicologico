package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.consulta.Consulta;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.CrearConsulta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;


public class CrearConsultaUseCase extends UseCase<RequestCommand<CrearConsulta>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<CrearConsulta> crearConsultaRequestCommand) {
        var command = crearConsultaRequestCommand.getCommand();

        Consulta consulta;

        consulta = new Consulta(
                command.getEntityId(),
                command.getEquipoProfesionalId(),
                command.getFecha()
        );

        emit().onResponse(new ResponseEvents(consulta.getUncommittedChanges()));


    }
}
