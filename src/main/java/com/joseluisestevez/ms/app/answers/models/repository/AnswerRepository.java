package com.joseluisestevez.ms.app.answers.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.joseluisestevez.ms.app.answers.models.entity.Answer;

public interface AnswerRepository extends MongoRepository<Answer, String> {

    @Query("{'studentId': ?0, 'questionId': {$in: ?1} }")
    Iterable<Answer> findAnswerByStudentAndQuestionIds(Long studentId, Iterable<Long> questionIds);

    @Query("{'studentId': ?0}")
    Iterable<Answer> findByStudentId(Long studentId);

    @Query("{'studentId': ?0, 'question.exam.id': ?1}")
    Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId);

    @Query(value = "{'studentId': ?0}", fields = "{'question.exam.id': 1}")
    Iterable<Answer> findExamIdWithAnswersAndStudent(Long studentId);

}
