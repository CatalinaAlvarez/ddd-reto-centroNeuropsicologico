package co.com.sofka.centroNeuropsicologico.domain.consulta.command;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.domain.generic.Command;

public class CrearConsulta extends Command {

    private final ConsultaId entityId;
    private final EquipoProfesionalId equipoProfesionalId;
    private final Fecha fecha;

    public CrearConsulta(ConsultaId entityId, EquipoProfesionalId equipoProfesionalId, Fecha fecha){

        this.entityId = entityId;
        this.equipoProfesionalId = equipoProfesionalId;
        this.fecha = fecha;
    }

    public ConsultaId getEntityId() {
        return entityId;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
