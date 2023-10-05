package com.example.demo;

import javax.persistence.*;

@Entity (name="Enrolment")
@Table (name="enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id"
    )
    private Course course;

    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
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
}
