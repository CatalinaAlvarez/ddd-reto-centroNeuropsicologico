package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TerapeutaOcupacionalId;
import co.com.sofka.domain.generic.Command;

public class AgregarEstudioTerapeutaOcupacional extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final TerapeutaOcupacionalId terapeutaOcupacionalId;
    private final Estudio estudio;

    public AgregarEstudioTerapeutaOcupacional(EquipoProfesionalId equipoProfesionalId, TerapeutaOcupacionalId entityId, Estudio estudio){

        this.equipoProfesionalId = equipoProfesionalId;
        this.terapeutaOcupacionalId = entityId;
        this.estudio = estudio;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public TerapeutaOcupacionalId getTerapeutaOcupacionalId() {
        return terapeutaOcupacionalId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
