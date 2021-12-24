package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TerapeutaOcupacionalId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmailTerapeutaOcupacional extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final TerapeutaOcupacionalId terapeutaOcupacionalId;
    private final Email email;

    public ActualizarEmailTerapeutaOcupacional(EquipoProfesionalId equipoProfesionalId, TerapeutaOcupacionalId entityId, Email email){

        this.equipoProfesionalId = equipoProfesionalId;
        this.terapeutaOcupacionalId = entityId;
        this.email = email;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public TerapeutaOcupacionalId getTerapeutaOcupacionalId() {
        return terapeutaOcupacionalId;
    }

    public Email getEmail() {
        return email;
    }
}
