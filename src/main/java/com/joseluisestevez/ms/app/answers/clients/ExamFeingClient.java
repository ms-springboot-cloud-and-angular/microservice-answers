package com.joseluisestevez.ms.app.answers.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.joseluisestevez.ms.commons.exams.models.entity.Exam;

@FeignClient(name = "microservice-exams")
public interface ExamFeingClient {

    @GetMapping("/{id}")
    Exam getExamById(@PathVariable Long id);
}
