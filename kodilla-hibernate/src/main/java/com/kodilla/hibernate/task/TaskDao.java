/*package com.kodilla.hibernate.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);
    @Override
    long count();
}
*/