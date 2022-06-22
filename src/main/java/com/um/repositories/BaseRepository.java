package com.um.repositories;

import java.util.List;

public interface BaseRepository {

    Object getOne(Object model, Long id);

    List<Object> getAll(Object model);

    void deleteOne(Object model);

    void create(Object model);

    void update(Object model);

}
