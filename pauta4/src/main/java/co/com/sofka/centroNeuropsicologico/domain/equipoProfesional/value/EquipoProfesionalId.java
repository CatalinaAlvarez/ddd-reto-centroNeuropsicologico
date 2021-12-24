package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.CitaId;
import co.com.sofka.domain.generic.Identity;

public class EquipoProfesionalId extends Identity {

    public EquipoProfesionalId(){

    }

    public EquipoProfesionalId(String id) {
        super(id);
    }

    public static EquipoProfesionalId of(String id){
        return new EquipoProfesionalId(id);
    }
}
