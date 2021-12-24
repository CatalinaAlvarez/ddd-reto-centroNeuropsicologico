package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.paciente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.centroNeuropsicologico.domain.paciente.Paciente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.command.ActualizarNombreAcudiente;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;
import co.com.sofka.centroNeuropsicologico.domain.paciente.value.Telefono;

public class ActualizarNombreAcudienteUseCase extends UseCase<RequestCommand<ActualizarNombreAcudiente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreAcudiente> actualizarNombreAcudienteRequestCommand) {

        var command = actualizarNombreAcudienteRequestCommand.getCommand();

        Paciente paciente;

        paciente = new Paciente(
                new PacienteId(),
                new Telefono("123456789")
        );

        paciente.agregarAcudiente(
                new Nombre("Juan"),
                new Email("pedro@gmail.com")
        );

        paciente.actualizarNombreAcudiente(command.getAcudienteId(), command.getNombre());

        emit().onResponse(new ResponseEvents(paciente.getUncommittedChanges()));
    }
}
