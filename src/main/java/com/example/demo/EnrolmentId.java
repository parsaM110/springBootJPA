package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolmentId implements Serializable {
    @Column(
            name = "student_id"
    )
    private long studentId;
    @Column(
            name = "course_id"
    )
    private long courseId;

    public EnrolmentId(long studentId, long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public EnrolmentId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
