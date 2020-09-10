package com.kodilla.hibernate.aaa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PhoDao extends CrudRepository<Pho,Long> {
}
