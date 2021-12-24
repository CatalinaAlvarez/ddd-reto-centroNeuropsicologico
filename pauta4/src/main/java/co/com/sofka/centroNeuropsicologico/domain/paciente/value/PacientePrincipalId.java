package co.com.sofka.centroNeuropsicologico.domain.paciente.value;

import co.com.sofka.domain.generic.Identity;

public class PacientePrincipalId extends Identity {

    public PacientePrincipalId(){

    }

    public PacientePrincipalId(String id) {
        super(id);
    }

    public static PacientePrincipalId of(String id){
        return new PacientePrincipalId(id);
    }
}
