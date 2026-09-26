package co.edu.uniquindio.poo.parcial1.factory;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.ModalidadPremium;

public class CreadorModalidadPremium extends CreadorModalidad {
    @Override public ModalidadAlquiler crearModalidad(DatosModalidad datos) {
        return new ModalidadPremium(datos.codigo(), datos.nombre(), datos.descripcion(),
                datos.duracionMinimaDias(), datos.valorDiario(), datos.estado(), datos.beneficios(),
                datos.tipoCobertura(), datos.conductoresAdicionales(), datos.caracteristicasEspeciales());
    }
}
