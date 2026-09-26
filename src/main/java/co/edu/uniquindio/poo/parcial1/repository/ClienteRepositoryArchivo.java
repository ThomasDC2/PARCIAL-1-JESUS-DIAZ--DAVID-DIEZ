package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Cliente;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryArchivo extends ArchivoRepository<Cliente> implements ClienteRepository {
    public ClienteRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("clientes.dat"),
                Cliente::getDocumentoIdentidad);
    }

    @Override public void guardar(Cliente cliente) { guardarRegistro(cliente); }
    @Override public Optional<Cliente> buscarPorDocumentoIdentidad(String documento) { return buscarRegistro(documento); }
    @Override public Optional<Cliente> buscarPorTelefono(String telefono) {
        return filtrarRegistros(cliente -> telefono.equals(cliente.getTelefono())).stream().findFirst();
    }
    @Override public List<Cliente> listarTodos() { return listarRegistros(); }
    @Override public void actualizar(Cliente cliente) { actualizarRegistro(cliente); }
    @Override public void eliminarPorDocumentoIdentidad(String documento) { eliminarRegistro(documento); }
}
