package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ModalidadRepository;
import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.TipoModalidad;
import co.edu.uniquindio.poo.parcial1.factory.CreadorModalidades;
import co.edu.uniquindio.poo.parcial1.factory.DatosModalidad;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ModalidadService {
    private final ModalidadRepository modalidadRepository;

    public ModalidadService(ModalidadRepository modalidadRepository) {
        this.modalidadRepository = Objects.requireNonNull(modalidadRepository);
    }

    public void registrar(ModalidadAlquiler modalidad) {
        modalidadRepository.guardar(Objects.requireNonNull(modalidad));
    }

    public ModalidadAlquiler crearYRegistrar(TipoModalidad tipo, DatosModalidad datos) {
        ModalidadAlquiler modalidad = CreadorModalidades.para(tipo).crearModalidad(datos);
        registrar(modalidad);
        return modalidad;
    }

    public Optional<ModalidadAlquiler> buscarPorCodigo(String codigo) {
        return modalidadRepository.buscarPorCodigo(codigo);
    }

    public List<ModalidadAlquiler> listarTodas() {
        return modalidadRepository.listarTodas();
    }

    public void actualizar(ModalidadAlquiler modalidad) {
        modalidadRepository.actualizar(Objects.requireNonNull(modalidad));
    }

    public void eliminar(String codigo) {
        modalidadRepository.eliminarPorCodigo(codigo);
    }
}
