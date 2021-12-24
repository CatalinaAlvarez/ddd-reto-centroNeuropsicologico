package co.com.sofka.centroNeuropsicologico.domain.equipoProfesional;

import co.com.sofka.centroNeuropsicologico.domain.equipoProfesional.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class EquipoProfesionalChange extends EventChange {
    public EquipoProfesionalChange(EquipoProfesional equipoProfesional) {

        apply((EquipoProfesionalCreado event)->{
            equipoProfesional.tipoEquipo = event.getTipoEquipo();
        });

        apply((PsicologoAgregado event)->{
            equipoProfesional.psicologo = new Psicologo(
                    event.getPsicologoId(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getTarjetaProfesional()
            );
        });

        apply((NeuropsicologoAgregado event)->{
            equipoProfesional.neuropsicologo = new Neuropsicologo(
                    event.getNeuropsicologoId(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getTarjetaProfesional()
            );
        });

        apply((TerapeutaOcupacionalAgregado event)->{
            equipoProfesional.terapeutaOcupacional = new TerapeutaOcupacional(
                    event.getTerapeutaOcupacionalId(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getTarjetaProfesional()
            );
        });

        apply((EmailPsicologoActualizado event)->{
            equipoProfesional.psicologo.email = event.getEmail();
        });

        apply((EstudioPsicologoAgregado event)->{ //REVISAR
            equipoProfesional.psicologo.estudios.add(event.getEstudio());
        });

        apply((EmailNeuropsicologoActualizado event)->{
            equipoProfesional.neuropsicologo.email = event.getEmail();
        });

        apply((EstudioNeuropsicologoAgregado event)->{ //REVISAR
            equipoProfesional.neuropsicologo.estudios.add(event.getEstudio());
        });

        apply((EmailTerapeutaOcupacionalActualizado event)->{
            equipoProfesional.terapeutaOcupacional.email = event.getEmail();
        });

        apply((EstudioTerapeutaOcupacionalAgregado event)->{ //REVISAR
            equipoProfesional.terapeutaOcupacional.estudios.add(event.getEstudio());
        });
    }
}
