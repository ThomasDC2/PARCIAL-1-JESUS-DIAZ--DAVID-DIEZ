package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    void guardar(Cliente cliente);

    Optional<Cliente> buscarPorDocumentoIdentidad(String documentoIdentidad);

    Optional<Cliente> buscarPorTelefono(String telefono);

    List<Cliente> listarTodos();

    void actualizar(Cliente cliente);

    void eliminarPorDocumentoIdentidad(String documentoIdentidad);
}
