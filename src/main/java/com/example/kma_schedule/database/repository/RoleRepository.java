package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Role;
import com.example.kma_schedule.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
