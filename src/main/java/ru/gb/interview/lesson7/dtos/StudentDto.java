package ru.gb.interview.lesson7.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.gb.interview.lesson7.data.StudentEntity;

@Data
@RequiredArgsConstructor
public class StudentDto {

    private Long id;
    private String name;
    private Integer age;

    public StudentDto(StudentEntity student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }
}
