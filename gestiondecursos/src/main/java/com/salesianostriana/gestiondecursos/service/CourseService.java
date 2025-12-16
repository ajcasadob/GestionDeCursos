package com.salesianostriana.gestiondecursos.service;


import com.salesianostriana.gestiondecursos.model.Category;
import com.salesianostriana.gestiondecursos.model.Course;
import com.salesianostriana.gestiondecursos.repository.CategoryRepository;
import com.salesianostriana.gestiondecursos.repository.CourseRepository;
import com.salesianostriana.gestiondecursos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository courseRepository;




    public List<Course > findAll(Long categoryId) {
        if (categoryId != null) {
            return courseRepository.findByCategoryId(categoryId);
        } else {
            return courseRepository.findAll();
        }



    }



}
