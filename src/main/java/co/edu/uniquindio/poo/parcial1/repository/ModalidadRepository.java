package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;

import java.util.List;
import java.util.Optional;

public interface ModalidadRepository {
    void guardar(ModalidadAlquiler modalidad);

    Optional<ModalidadAlquiler> buscarPorCodigo(String codigo);

    List<ModalidadAlquiler> listarTodas();

    void actualizar(ModalidadAlquiler modalidad);

    void eliminarPorCodigo(String codigo);
}
