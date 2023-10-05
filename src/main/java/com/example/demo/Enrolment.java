package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity (name="Enrolment")
@Table (name="enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId") //the name in EnrolmentId
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id"
            )
    )
    private Course course;


    @Column(
            name="create_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT  TIME ZONE"
    )
    private LocalDateTime createAt;

    public Enrolment(Student student, Course course, LocalDateTime createAt) {
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public Enrolment(EnrolmentId id,
                     Student student,
                     Course course,
                     LocalDateTime createAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
