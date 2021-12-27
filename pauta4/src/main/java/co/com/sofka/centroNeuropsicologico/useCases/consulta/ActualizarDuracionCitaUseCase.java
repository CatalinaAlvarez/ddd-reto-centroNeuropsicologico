package co.com.sofka.centroNeuropsicologico.useCases.consulta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.consulta.Consulta;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.ActualizarDuracionCita;


public class ActualizarDuracionCitaUseCase extends UseCase<RequestCommand<ActualizarDuracionCita>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDuracionCita> actualizarDuracionCitaRequestCommand) {
        var command = actualizarDuracionCitaRequestCommand.getCommand();

        Consulta consulta;

        consulta = Consulta.from(command.getConsultaId(), retrieveEvents());
        consulta.actualizarDuracionCita(command.getCitaId(), command.getDuracion());

        emit().onResponse(new ResponseEvents(consulta.getUncommittedChanges()));
    }
}
