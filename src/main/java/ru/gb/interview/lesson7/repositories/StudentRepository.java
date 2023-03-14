package ru.gb.interview.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.interview.lesson7.data.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
