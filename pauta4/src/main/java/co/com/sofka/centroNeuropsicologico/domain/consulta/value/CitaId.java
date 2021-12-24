package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.Identity;

public class CitaId extends Identity {

    public CitaId(){

    }

    public CitaId(String id) {
        super(id);
    }

    public static CitaId of(String id){
        return new CitaId(id);
    }
}
