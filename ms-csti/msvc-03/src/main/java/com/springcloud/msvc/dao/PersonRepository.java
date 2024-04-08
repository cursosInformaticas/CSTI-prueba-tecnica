package com.springcloud.msvc.dao;

import com.springcloud.msvc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
