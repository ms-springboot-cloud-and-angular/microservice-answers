package com.joseluisestevez.ms.app.answers.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseluisestevez.ms.commons.exams.models.entity.Exam;

@FeignClient(name = "microservice-exams")
public interface ExamFeingClient {

    @GetMapping("/{id}")
    Exam getExamById(@PathVariable Long id);

    @GetMapping("/answered-by-questions")
    List<Long> getAnsweredByQuestions(@RequestParam List<Long> questionIds);
}
