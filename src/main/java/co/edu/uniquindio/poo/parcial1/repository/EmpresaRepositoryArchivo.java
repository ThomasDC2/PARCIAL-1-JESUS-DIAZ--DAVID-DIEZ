package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Empresa;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class EmpresaRepositoryArchivo extends ArchivoRepository<Empresa> implements EmpresaRepository {
    public EmpresaRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("empresas.dat"), Empresa::getNit);
    }

    @Override public void guardar(Empresa empresa) { guardarRegistro(empresa); }
    @Override public Optional<Empresa> buscarPorNit(String nit) { return buscarRegistro(nit); }
    @Override public List<Empresa> listarTodas() { return listarRegistros(); }
    @Override public void actualizar(Empresa empresa) { actualizarRegistro(empresa); }
    @Override public void eliminarPorNit(String nit) { eliminarRegistro(nit); }
}
