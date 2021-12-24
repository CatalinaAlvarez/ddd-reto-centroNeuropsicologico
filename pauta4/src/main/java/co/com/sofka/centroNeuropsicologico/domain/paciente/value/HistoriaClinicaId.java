package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.Identity;

public class HistoriaClinicaId extends Identity {

    public HistoriaClinicaId(){

    }

    public HistoriaClinicaId(String id) {
        super(id);
    }

    public static HistoriaClinicaId of(String id){
        return new HistoriaClinicaId(id);
    }
}
