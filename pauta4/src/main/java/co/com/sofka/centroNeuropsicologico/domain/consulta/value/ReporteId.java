package co.com.sofka.centroNeuropsicologico.domain.consulta.value;

import co.com.sofka.domain.generic.Identity;

public class ReporteId extends Identity {

    public ReporteId(){

    }

    public ReporteId(String id) {
        super(id);
    }

    public static ReporteId of(String id){
        return new ReporteId(id);
    }
}
