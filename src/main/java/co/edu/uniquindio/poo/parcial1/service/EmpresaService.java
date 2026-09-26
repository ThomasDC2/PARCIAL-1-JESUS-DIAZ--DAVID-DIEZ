package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.EmpresaRepository;
import co.edu.uniquindio.poo.parcial1.model.Empresa;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository);
    }

    public void guardar(Empresa empresa) {
        empresaRepository.guardar(Objects.requireNonNull(empresa));
    }

    public Optional<Empresa> buscarPorNit(String nit) {
        return empresaRepository.buscarPorNit(nit);
    }

    public List<Empresa> listarTodas() {
        return empresaRepository.listarTodas();
    }

    public void actualizar(Empresa empresa) {
        empresaRepository.actualizar(Objects.requireNonNull(empresa));
    }

    public void eliminar(String nit) {
        empresaRepository.eliminarPorNit(nit);
    }
}
