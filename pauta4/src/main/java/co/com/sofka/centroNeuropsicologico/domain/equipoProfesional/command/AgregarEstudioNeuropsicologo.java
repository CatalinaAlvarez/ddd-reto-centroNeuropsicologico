package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.Estudio;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.NeuropsicologoId;
import co.com.sofka.domain.generic.Command;

public class AgregarEstudioNeuropsicologo extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final NeuropsicologoId neuropsicologoId;
    private final Estudio estudio;

    public AgregarEstudioNeuropsicologo(EquipoProfesionalId equipoProfesionalId, NeuropsicologoId entityId, Estudio estudio){

        this.equipoProfesionalId = equipoProfesionalId;
        this.neuropsicologoId = entityId;
        this.estudio = estudio;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public NeuropsicologoId getNeuropsicologoId() {
        return neuropsicologoId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
