package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class ServicioAdicionalRepositoryArchivo extends ArchivoRepository<ServicioAdicional>
        implements ServicioAdicionalRepository {
    public ServicioAdicionalRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("servicios-adicionales.dat"),
                ServicioAdicional::getCodigo);
    }

    @Override public void guardar(ServicioAdicional servicio) { guardarRegistro(servicio); }
    @Override public Optional<ServicioAdicional> buscarPorCodigo(String codigo) { return buscarRegistro(codigo); }
    @Override public List<ServicioAdicional> listarTodos() { return listarRegistros(); }
    @Override public void actualizar(ServicioAdicional servicio) { actualizarRegistro(servicio); }
    @Override public void eliminarPorCodigo(String codigo) { eliminarRegistro(codigo); }
}
