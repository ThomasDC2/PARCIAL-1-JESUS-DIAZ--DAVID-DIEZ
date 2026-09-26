package co.edu.uniquindio.poo.parcial1.factory;

import co.edu.uniquindio.poo.parcial1.model.TipoModalidad;

public final class CreadorModalidades {
    private CreadorModalidades() {
    }

    public static CreadorModalidad para(TipoModalidad tipo) {
        return switch (tipo) {
            case ECONOMICA -> new CreadorModalidadEconomica();
            case EJECUTIVA -> new CreadorModalidadEjecutiva();
            case PREMIUM -> new CreadorModalidadPremium();
        };
    }
}
