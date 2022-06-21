package com.um.repositories;
import com.um.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository {

    List<User> getUsers();

    // void eliminar(Long id);

    // void registrar(Usuario usuario);

    // Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}

