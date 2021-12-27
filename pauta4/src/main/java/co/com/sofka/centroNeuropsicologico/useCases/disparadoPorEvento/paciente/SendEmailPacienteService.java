package co.com.sofka.centroNeuropsicologico.useCases.disparadoPorEvento.paciente;

import co.com.sofka.centroNeuropsicologico.domain.paciente.value.PacienteId;

public interface SendEmailPacienteService {
    boolean send(PacienteId pacienteId, String email, String body);
}
