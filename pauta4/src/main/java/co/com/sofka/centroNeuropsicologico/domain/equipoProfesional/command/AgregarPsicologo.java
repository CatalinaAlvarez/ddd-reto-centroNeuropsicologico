package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.command;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.EquipoProfesionalId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.PsicologoId;
import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.value.TarjetaProfesional;
import co.com.sofka.centroNeuropsicologico.domain.generics.Email;
import co.com.sofka.centroNeuropsicologico.domain.generics.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarPsicologo extends Command {

    private final EquipoProfesionalId equipoProfesionalId;
    private final PsicologoId psicologoId;
    private final Nombre nombre;
    private final Email email;
    private final TarjetaProfesional tarjetaProfesional;

    public AgregarPsicologo(EquipoProfesionalId equipoProfesionalId, PsicologoId entityId, Nombre nombre, Email email, TarjetaProfesional tarjetaProfesional){

        this.equipoProfesionalId = equipoProfesionalId;
        this.psicologoId = entityId;
        this.nombre = nombre;
        this.email = email;
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public EquipoProfesionalId getEquipoProfesionalId() {
        return equipoProfesionalId;
    }

    public PsicologoId getPsicologoId() {
        return psicologoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public TarjetaProfesional getTarjetaProfesional() {
        return tarjetaProfesional;
    }
}
