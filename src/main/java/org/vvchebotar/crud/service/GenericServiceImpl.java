package org.vvchebotar.crud.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.vvchebotar.crud.dao.GenericDao;

public class GenericServiceImpl <T, PK extends Serializable> implements GenericService <T, PK> {
	@Autowired
	private GenericDao<T, PK> genericDao;

	@Override
	public PK create(T newInstance) {
		return genericDao.create(newInstance);
	}

	@Override
	public T read(Class <T> clazz, PK id) {
		return (T) genericDao.read(clazz,id);
	}

	@Override
	public void update(T transientObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T persistentObject) {
		genericDao.delete(persistentObject);
	}

	

}
