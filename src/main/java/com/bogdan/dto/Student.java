package com.bogdan.dto;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Objects;

@RedisHash("Student")
public class Student implements Serializable {

  private String id;
  private String name;
  private Gender gender;
  private int grade;

  public String getId() {
    return id;
  }

  public Student setId(final String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Student setName(final String name) {
    this.name = name;
    return this;
  }

  public Gender getGender() {
    return gender;
  }

  public Student setGender(final Gender gender) {
    this.gender = gender;
    return this;
  }

  public int getGrade() {
    return grade;
  }

  public Student setGrade(final int grade) {
    this.grade = grade;
    return this;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Student student = (Student) o;
    return grade == student.grade &&
        Objects.equals(id, student.id) &&
        Objects.equals(name, student.name) &&
        gender == student.gender;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gender, grade);
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", gender=" + gender +
        ", grade=" + grade +
        '}';
  }

  public enum Gender {
    MALE, FEMALE
  }
}
