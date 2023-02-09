package com.example.findjobbe.service;

import java.util.List;
import java.util.Optional;

public interface ICoreCrud<E, K> {
	List<E> findAll();
	Optional<E> findOne(K k);
	E save(E e);
	void delete(K k);
}
