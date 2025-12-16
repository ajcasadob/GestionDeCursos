package com.salesianostriana.gestiondecursos.service;

import com.salesianostriana.gestiondecursos.model.Course;
import com.salesianostriana.gestiondecursos.model.Enrollment;
import com.salesianostriana.gestiondecursos.model.EnrollmentId;
import com.salesianostriana.gestiondecursos.model.User;
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




    public Enrollment enrollUserInCourse(Long userId, Long courseId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));


        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));


        enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .ifPresent(e -> {
                    throw new RuntimeException("User already enrolled in this course");
                });


        EnrollmentId enrollmentId = new EnrollmentId(userId, courseId);
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentId);
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setStatus(Enrollment.EnrollmentStatus.ENROLLED);
        enrollment.setProgressPercent(0);

        return enrollmentRepository.save(enrollment);
    }






}
