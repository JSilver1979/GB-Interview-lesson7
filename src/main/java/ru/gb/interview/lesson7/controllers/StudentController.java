package ru.gb.interview.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.interview.lesson7.dtos.StudentDto;
import ru.gb.interview.lesson7.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping()
    public void addStudent(@RequestBody StudentDto student) {
        service.createStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentDto student) {
        service.updateStudent(student);
    }
}
