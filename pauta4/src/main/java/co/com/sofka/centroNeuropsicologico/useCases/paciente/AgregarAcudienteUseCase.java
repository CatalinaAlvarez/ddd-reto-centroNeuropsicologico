package co.com.sofka.centroNeuropsicologico.useCases.paciente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.AgregarAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;


public class AgregarAcudienteUseCase extends UseCase<RequestCommand<AgregarAcudiente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAcudiente> agregarAcudienteRequestCommand) {

        var command = agregarAcudienteRequestCommand.getCommand();

        Paciente paciente;

        paciente = Paciente.from(
                command.getPacienteId(), retrieveEvents());

        paciente.agregarAcudiente(
                command.getNombre(),
                command.getEmail()
        );

        emit().onResponse(new ResponseEvents(paciente.getUncommittedChanges()));
    }
}
