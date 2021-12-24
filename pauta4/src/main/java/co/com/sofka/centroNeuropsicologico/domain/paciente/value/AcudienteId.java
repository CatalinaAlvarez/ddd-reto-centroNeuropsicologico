package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.domain.generic.Identity;

public class AcudienteId extends Identity {

    public AcudienteId(){

    }

    public AcudienteId(String id) {
        super(id);
    }

    public static AcudienteId of(String id){
        return new AcudienteId(id);
    }
}
