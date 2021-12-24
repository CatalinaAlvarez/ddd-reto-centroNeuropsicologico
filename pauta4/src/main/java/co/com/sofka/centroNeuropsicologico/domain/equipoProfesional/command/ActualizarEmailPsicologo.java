package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmailPsicologo extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final PsicologoId psicologoId;
    private final Email email;

    public ActualizarEmailPsicologo(EquipoProfesionalId equipoProfesionalId, PsicologoId entityId, Email email){

        this.equipoProfesionalId = equipoProfesionalId;
        this.psicologoId = entityId;
        this.email = email;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Email getEmail() {
        return email;
    }
}
