package com.bogdan.web;

import com.bogdan.dto.Student;
import com.bogdan.exceptions.StudentNotFoundException;
import com.bogdan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/students")
@Validated
public class StudentsController {

  private StudentRepository studentRepository;

  public StudentsController(
      @Autowired final StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  private static URI createUri(String uri) {
    try {
      return new URI(uri);
    } catch (URISyntaxException e) {
      throw new RuntimeException(String.format("Invalid URI '%s'", uri), e);
    }
  }

  @PostMapping
  public ResponseEntity<Student> postCustomer(@Valid @RequestBody Student student) {
    Student createdStudent = studentRepository.save(student);
    return ResponseEntity.created(createUri("/customers/" + createdStudent.getId())).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getCustomer(@PathVariable String id) {
    Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    return ResponseEntity.ok().body(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllCustomers() {
    List<Student> students = StreamSupport.stream(studentRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(students);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteCustomer(@PathVariable String id) {
    Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    studentRepository.delete(student);
    return ResponseEntity.ok().build();
  }

}