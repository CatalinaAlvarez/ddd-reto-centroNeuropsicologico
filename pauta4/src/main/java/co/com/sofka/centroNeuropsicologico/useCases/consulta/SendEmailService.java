package co.com.sofka.centroNeuropsicologico.useCases.consulta;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;

public interface SendEmailService {

    boolean send(ConsultaId consultaId, String email, String body);
}
