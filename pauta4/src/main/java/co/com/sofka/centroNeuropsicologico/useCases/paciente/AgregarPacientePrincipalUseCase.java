package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarPacientePrincipal;

public class AgregarPacientePrincipalUseCase extends UseCase<RequestCommand<AgregarPacientePrincipal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPacientePrincipal> agregarPacientePrincipalRequestCommand) {

        var command = agregarPacientePrincipalRequestCommand.getCommand();

        Paciente paciente;

        paciente = Paciente.from(command.getPacienteId(), retrieveEvents());

        paciente.agregarPacientePrincipal(
                command.getNombre(),
                command.getEdad());

        emit().onResponse(new ResponseEvents(paciente.getUncommittedChanges()));
    }
}
