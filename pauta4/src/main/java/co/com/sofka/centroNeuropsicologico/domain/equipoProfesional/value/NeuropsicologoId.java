package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.domain.generic.Identity;

public class NeuropsicologoId extends Identity {

    public NeuropsicologoId(){

    }

    public NeuropsicologoId(String id) {
        super(id);
    }

    public static NeuropsicologoId of(String id){
        return new NeuropsicologoId(id);
    }
}
