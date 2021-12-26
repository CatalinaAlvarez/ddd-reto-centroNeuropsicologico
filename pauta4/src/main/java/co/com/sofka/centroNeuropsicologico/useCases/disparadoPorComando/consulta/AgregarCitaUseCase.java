package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.consulta.Consulta;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.AgregarCita;


public class AgregarCitaUseCase extends UseCase<RequestCommand<AgregarCita>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCita> agregarCitaRequestCommand) {
        var command = agregarCitaRequestCommand.getCommand();

        Consulta consulta;

        consulta = Consulta.from(command.getConsultaId(), retrieveEvents());

        consulta.agregarCita(
                command.getTipo(),
                command.getDuracion()
        );

        emit().onResponse(new ResponseEvents(consulta.getUncommittedChanges()));
    }
}
