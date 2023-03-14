package ru.gb.interview.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.interview.lesson7.data.StudentEntity;
import ru.gb.interview.lesson7.dtos.StudentDto;
import ru.gb.interview.lesson7.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;


    public List<StudentDto> getAllStudents() {

        return repository.findAll()
                .stream()
                .map(StudentDto::new)
                .toList();
    }

    public StudentDto getStudentById(Long id) {
        return repository.findById(id)
                .map(StudentDto::new).orElseThrow();
    }

    public void createStudent(StudentDto student) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());

        repository.save(newStudent);
    }

    public void deleteStudent (Long id) {
        repository.deleteById(id);
    }

    public void updateStudent(StudentDto student) {
        StudentEntity updatedStudent = repository.findById(student.getId()).orElseThrow();
        updatedStudent.setName(student.getName());
        updatedStudent.setAge(student.getAge());
        repository.save(updatedStudent);
    }
}
