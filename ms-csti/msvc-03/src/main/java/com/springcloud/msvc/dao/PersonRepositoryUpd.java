package com.springcloud.msvc.dao;

import com.springcloud.msvc.entity.Person;
import com.springcloud.msvc.entity.PersonUpdated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryUpd extends JpaRepository<PersonUpdated, Long> {
}
