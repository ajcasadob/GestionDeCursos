package com.salesianostriana.gestiondecursos.service;

import com.salesianostriana.gestiondecursos.model.*;
import com.salesianostriana.gestiondecursos.repository.CourseRepository;
import com.salesianostriana.gestiondecursos.repository.EnrollmentRepository;
import com.salesianostriana.gestiondecursos.repository.ReviewRepository;
import com.salesianostriana.gestiondecursos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {


    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository UserRepository;




    public Enrollment enrollUserInCourse(Long userId, Long courseId) {

        User user = UserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + userId));


        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + courseId));


        enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .ifPresent(e -> {
                    throw new RuntimeException("Usuario matriculado ya en el curso");
                });


        EnrollmentId enrollmentId = new EnrollmentId(userId, courseId);
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentId);
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setStatus(EnrollmentStatus.ENROLLED);
        enrollment.setProgressPercent(0);

        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollmentProgress(Long userId, Long courseId, Integer progressPercent) {

        if (progressPercent < 0 || progressPercent > 100) {
            throw new IllegalArgumentException("Progreso debe estar entre 0 y 100");
        }


        return enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .map(enrollment -> {
                    enrollment.setProgressPercent(progressPercent);


                    if (progressPercent == 100) {
                        enrollment.setStatus(EnrollmentStatus.COMPLETED);
                    }

                    return enrollmentRepository.save(enrollment);
                })
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }






}
