package co.com.sofka.centroNeuropsicologico.domain.consulta.event;

import co.com.sofka.centroNeuropsicologico.domain.consulta.value.ConsultaId;
import co.com.sofka.centroNeuropsicologico.domain.consulta.value.Fecha;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.domain.generic.DomainEvent;

public class ConsultaCreada extends DomainEvent {

    private final ConsultaId consultaId;
    private final EquipoProfesionalId equipoProfesionalId;
    private final Fecha fecha;

    public ConsultaCreada(ConsultaId entityId, EquipoProfesionalId equipoProfesionalId, Fecha fecha) {
        super("sofka.consulta.consultaCreada");

        this.consultaId = entityId;
        this.equipoProfesionalId = equipoProfesionalId;
        this.fecha = fecha;
    }

    public ConsultaId getConsultaId() {
        return consultaId;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public Fecha getFecha() {
        return fecha;
    }

}
