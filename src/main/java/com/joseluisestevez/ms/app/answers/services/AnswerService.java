package com.joseluisestevez.ms.app.answers.services;

import com.joseluisestevez.ms.app.answers.models.entity.Answer;

public interface AnswerService {

    Iterable<Answer> saveAll(Iterable<Answer> answers);

    Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId);

    Iterable<Long> findExamIdWithAnswersAndStudent(Long studentId);

    Iterable<Answer> findByStudentId(Long studentId);

}
