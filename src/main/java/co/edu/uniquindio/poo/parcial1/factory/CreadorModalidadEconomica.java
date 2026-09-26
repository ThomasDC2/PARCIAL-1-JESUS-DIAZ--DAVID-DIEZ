package co.edu.uniquindio.poo.parcial1.factory;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.ModalidadEconomica;

public class CreadorModalidadEconomica extends CreadorModalidad {
    @Override public ModalidadAlquiler crearModalidad(DatosModalidad datos) {
        return new ModalidadEconomica(datos.codigo(), datos.nombre(), datos.descripcion(),
                datos.duracionMinimaDias(), datos.valorDiario(), datos.estado(), datos.beneficios());
    }
}
