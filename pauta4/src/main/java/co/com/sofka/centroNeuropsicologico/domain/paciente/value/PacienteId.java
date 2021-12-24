package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.Identity;

public class PacienteId extends Identity {

    public PacienteId(){

    }

    public PacienteId(String id) {
        super(id);
    }

    public static PacienteId of(String id){
        return new PacienteId(id);
    }
}
