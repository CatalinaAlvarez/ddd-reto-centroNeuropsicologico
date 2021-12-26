package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.ActualizarNombreAcudiente;

public class ActualizarNombreAcudienteUseCase extends UseCase<RequestCommand<ActualizarNombreAcudiente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreAcudiente> actualizarNombreAcudienteRequestCommand) {

        var command = actualizarNombreAcudienteRequestCommand.getCommand();

        Paciente paciente;

        paciente = Paciente.from(command.getPacienteId(), retrieveEvents());

        paciente.actualizarNombreAcudiente(command.getAcudienteId(),
                command.getNombre());

        emit().onResponse(new ResponseEvents(paciente.getUncommittedChanges()));
    }
}
