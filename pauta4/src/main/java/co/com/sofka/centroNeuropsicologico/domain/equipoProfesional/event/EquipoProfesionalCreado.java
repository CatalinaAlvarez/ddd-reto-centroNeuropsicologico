package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event;


import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TipoEquipo;
import co.com.sofka.domain.generic.DomainEvent;

public class EquipoProfesionalCreado extends DomainEvent {

    private final EquipoProfesionalId equipoProfesionalId;
    private final TipoEquipo tipoEquipo;

    public EquipoProfesionalCreado(EquipoProfesionalId entityId, TipoEquipo tipoEquipo) {
        super("sofka.equipoProfesional.equipoProfesionalCreado");
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
