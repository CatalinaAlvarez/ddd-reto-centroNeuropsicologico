package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.domain.generic.Identity;

public class TerapeutaOcupacionalId extends Identity {

    public TerapeutaOcupacionalId(){

    }

    public TerapeutaOcupacionalId(String id) {
        super(id);
    }

    public static TerapeutaOcupacionalId of(String id){
        return new TerapeutaOcupacionalId(id);
    }
}
