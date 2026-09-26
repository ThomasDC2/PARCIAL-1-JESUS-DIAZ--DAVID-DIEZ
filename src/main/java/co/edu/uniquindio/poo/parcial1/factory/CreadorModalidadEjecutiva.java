package co.edu.uniquindio.poo.parcial1.factory;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.ModalidadEjecutiva;

public class CreadorModalidadEjecutiva extends CreadorModalidad {
    @Override public ModalidadAlquiler crearModalidad(DatosModalidad datos) {
        return new ModalidadEjecutiva(datos.codigo(), datos.nombre(), datos.descripcion(),
                datos.duracionMinimaDias(), datos.valorDiario(), datos.estado(), datos.beneficios());
    }
}
