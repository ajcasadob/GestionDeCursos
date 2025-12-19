package com.salesianostriana.gestiondecursos.service;

import com.salesianostriana.gestiondecursos.model.Course;
import com.salesianostriana.gestiondecursos.model.Enrollment;
import com.salesianostriana.gestiondecursos.model.Review;
import com.salesianostriana.gestiondecursos.model.User;
import com.salesianostriana.gestiondecursos.repository.CourseRepository;
import com.salesianostriana.gestiondecursos.repository.EnrollmentRepository;
import com.salesianostriana.gestiondecursos.repository.ReviewRepository;
import com.salesianostriana.gestiondecursos.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final ReviewRepository reviewRepository;




    @Transactional
    public Review createOrUpdateReview(Long userId, Long courseId,
                                       Integer rating, String comment) {

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));


        Enrollment enrollment = enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseThrow(() -> new RuntimeException(
                        "User must be enrolled to review this course"
                ));







    }

}
