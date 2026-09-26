package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository {
    void guardar(Empresa empresa);

    Optional<Empresa> buscarPorNit(String nit);

    List<Empresa> listarTodas();

    void actualizar(Empresa empresa);

    void eliminarPorNit(String nit);
}
