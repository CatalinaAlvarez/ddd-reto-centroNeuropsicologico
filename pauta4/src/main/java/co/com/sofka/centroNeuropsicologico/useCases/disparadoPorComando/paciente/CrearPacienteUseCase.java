package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.CrearPaciente;

public class CrearPacienteUseCase extends UseCase<RequestCommand<CrearPaciente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPaciente> crearPacienteRequestCommand) {
        var command = crearPacienteRequestCommand.getCommand();

        Paciente paciente;

        paciente = new Paciente(
                command.getPacienteId(),
                command.getTelefono()
        );

        emit().onResponse(new ResponseEvents(paciente.getUncommittedChanges()));

    }
}
