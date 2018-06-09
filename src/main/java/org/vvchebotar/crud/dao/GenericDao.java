package org.vvchebotar.crud.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {

    PK create(T newInstance);

    T read(Class<T> clazz, PK id);

    void update(T transientObject);

    void delete(T persistentObject);
}

