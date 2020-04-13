package com.joseluisestevez.ms.app.answers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.ms.app.answers.models.entity.Answer;
import com.joseluisestevez.ms.app.answers.services.AnswerService;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Iterable<Answer> answers) {
        Iterable<Answer> saved = answerService.saveAll(answers);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/student/{studentId}/exam/{examId}")
    public ResponseEntity<?> getAnswerByStudentAndExam(@PathVariable Long studentId, @PathVariable Long examId) {
        Iterable<Answer> answers = answerService.findAnswerByStudentAndExam(studentId, examId);
        return ResponseEntity.ok().body(answers);
    }
}
