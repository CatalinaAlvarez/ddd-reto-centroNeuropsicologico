package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TipoEquipo;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.domain.generic.Command;

public class CrearEquipoProfesional extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final TipoEquipo tipoEquipo;

    public CrearEquipoProfesional(EquipoProfesionalId entityId, TipoEquipo tipoEquipo){

        this.equipoProfesionalId = entityId;
        this.tipoEquipo = tipoEquipo;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }
}
