package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.Identity;

public class ConsultaId extends Identity {

    public ConsultaId(){

    }

    public ConsultaId(String id) {
        super(id);
    }

    public static ConsultaId of(String id){
        return new ConsultaId(id);
    }
}
