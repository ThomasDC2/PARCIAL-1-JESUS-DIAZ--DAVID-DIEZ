package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ClienteRepository;
import co.edu.uniquindio.poo.parcial1.model.Cliente;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = Objects.requireNonNull(clienteRepository);
    }

    public void registrar(Cliente cliente) {
        clienteRepository.guardar(Objects.requireNonNull(cliente));
    }

    public Optional<Cliente> buscarPorDocumento(String documentoIdentidad) {
        return clienteRepository.buscarPorDocumentoIdentidad(documentoIdentidad);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    public void actualizar(Cliente cliente) {
        clienteRepository.actualizar(Objects.requireNonNull(cliente));
    }

    public void eliminar(String documentoIdentidad) {
        clienteRepository.eliminarPorDocumentoIdentidad(documentoIdentidad);
    }
}
