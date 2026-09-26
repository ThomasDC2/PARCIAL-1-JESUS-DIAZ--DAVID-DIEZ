package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ClienteRepository;
import co.edu.uniquindio.poo.parcial1.model.Cliente;

import java.util.Objects;
import java.util.Optional;

public class ConsultaClienteService {
    private final ClienteRepository clienteRepository;
    private final VerificacionNumeroPerfectoService verificacionNumeroPerfectoService;

    public ConsultaClienteService(ClienteRepository clienteRepository,
                                  VerificacionNumeroPerfectoService verificacionNumeroPerfectoService) {
        this.clienteRepository = Objects.requireNonNull(clienteRepository);
        this.verificacionNumeroPerfectoService = Objects.requireNonNull(verificacionNumeroPerfectoService);
    }

    public Optional<Cliente> buscarPorTelefono(String telefono) {
        return clienteRepository.buscarPorTelefono(telefono);
    }

    public boolean telefonoEsNumeroPerfecto(String telefono) {
        return verificacionNumeroPerfectoService.esNumeroPerfecto(telefono);
    }
}
