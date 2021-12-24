package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.domain.generic.Identity;

public class PsicologoId extends Identity {

    public PsicologoId(){

    }

    public PsicologoId(String id) {
        super(id);
    }

    public static PsicologoId of(String id){
        return new PsicologoId(id);
    }
}
