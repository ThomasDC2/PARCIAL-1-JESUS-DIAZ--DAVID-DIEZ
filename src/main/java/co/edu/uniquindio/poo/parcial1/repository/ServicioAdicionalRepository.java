package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;

import java.util.List;
import java.util.Optional;

public interface ServicioAdicionalRepository {
    void guardar(ServicioAdicional servicio);

    Optional<ServicioAdicional> buscarPorCodigo(String codigo);

    List<ServicioAdicional> listarTodos();

    void actualizar(ServicioAdicional servicio);

    void eliminarPorCodigo(String codigo);
}
