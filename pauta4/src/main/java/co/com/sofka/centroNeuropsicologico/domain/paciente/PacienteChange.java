package co.com.sofka.centroNeuropsicologico.domain.paciente;

import co.com.sofka.centroNeuropsicologico.domain.paciente.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class PacienteChange extends EventChange {
    public PacienteChange(Paciente paciente) {

        apply((PacienteCreado event)->{
            paciente.telefono = event.getTelefono();
            paciente.consultas = new HashSet<>();
        });

        apply((AcudienteAgregado event)->{
            paciente.acudiente = new Acudiente(
                    event.getAcudienteId(),
                    event.getNombre(),
                    event.getEmail()
            );
        });

        apply((PacientePrincipalAgregado event)->{
            paciente.pacientePrincipal = new PacientePrincipal(
                    event.getPacientePrincipalId(),
                    event.getNombre(),
                    event.getEdad()
            );
        });

        apply((HistoriaClinicaAgregada event)->{
            paciente.historiaClinica = new HistoriaClinica(
                    event.getHistoriaClinicaId(),
                    event.getDiagnostico(),
                    event.getAnamnesis()
            );
        });

        apply((ConsultaAgregada event)->{
            paciente.consultas.add(event.getConsultaId()); //REVISAR. ENVIAR ARGUMENTO

        });

        apply((NombreAcudienteActualizado event)->{
            paciente.acudiente.nombre = event.getNombre();

        });

        apply((EmailAcudienteActualizado event)->{
            paciente.acudiente.email = event.getEmail();
        });

        apply((NombrePacientePrincipalActualizado event)->{
            paciente.pacientePrincipal.nombre = event.getNombre();
        });

        apply((EdadPacientePrincipalActualizada event)->{
            paciente.pacientePrincipal.edad = event.getEdad();
        });

        apply((DiagnosticoHistoriaClinicaActualizado event)->{
            paciente.historiaClinica.diagnostico = event.getDiagnostico();
        });
    }
}
