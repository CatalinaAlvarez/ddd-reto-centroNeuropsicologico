package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.domain.generic.Command;

public class AgregarEstudioPsicologo extends Command {

    private EquipoProfesionalId equipoProfesionalId;
    private PsicologoId psicologoId;
    private Estudio estudio;

    public AgregarEstudioPsicologo(EquipoProfesionalId equipoProfesionalId, PsicologoId entityId, Estudio estudio){

        this.equipoProfesionalId = equipoProfesionalId;
        this.psicologoId = entityId;
        this.estudio = estudio;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
