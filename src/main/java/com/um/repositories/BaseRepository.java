package com.um.repositories;

import java.util.List;

public interface BaseRepository {
    Object getOne(String model, Long id);

    List<Object> getAll(String model);

    // void deleteOne(Object model, Long id);

    void create(Object model);

    // void update(Object model);

    // List<Usuario> getUsuarios();

    // void eliminar(Long id);

    // void registrar(Usuario usuario);

    // Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
