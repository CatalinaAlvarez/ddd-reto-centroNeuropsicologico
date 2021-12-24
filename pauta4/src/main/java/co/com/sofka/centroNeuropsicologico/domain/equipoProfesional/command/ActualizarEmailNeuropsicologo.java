package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmailNeuropsicologo extends Command {

    private EquipoProfesionalId equipoProfesionalId;
    private NeuropsicologoId neuropsicologoId;
    private Email email;

    public ActualizarEmailNeuropsicologo(EquipoProfesionalId equipoProfesionalId, NeuropsicologoId entityId, Email email){

        this.equipoProfesionalId = equipoProfesionalId;
        this.neuropsicologoId = entityId;
        this.email = email;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public NeuropsicologoId getNeuropsicologoId() {
        return neuropsicologoId;
    }

    public Email getEmail() {
        return email;
    }
}
