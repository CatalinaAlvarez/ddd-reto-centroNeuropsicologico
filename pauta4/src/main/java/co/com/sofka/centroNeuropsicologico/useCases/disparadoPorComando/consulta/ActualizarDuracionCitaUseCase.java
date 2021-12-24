package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorComando.consulta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.centroNeuropsicologico.domain.consulta.Consulta;
import co.com.sofka.centroNeuropsicologico.domain.consulta.command.ActualizarDuracionCita;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Duracion;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Tipo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;

import java.util.Date;

public class ActualizarDuracionCitaUseCase extends UseCase<RequestCommand<ActualizarDuracionCita>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDuracionCita> actualizarDuracionCitaRequestCommand) {
        var command = actualizarDuracionCitaRequestCommand.getCommand();

        Consulta consulta;

        consulta = new Consulta(
                new ConsultaId(),
                new EquipoProfesionalId(),
                new Fecha(new Date())
        );

        consulta.agregarCita(new Tipo(Tipo.Valor.ASESORIA_PSICOLOGICA),
                new Duracion(20));

        consulta.actualizarDuracionCita(command.getCitaId(), command.getDuracion());

        emit().onResponse(new ResponseEvents(consulta.getUncommittedChanges()));
    }
}
