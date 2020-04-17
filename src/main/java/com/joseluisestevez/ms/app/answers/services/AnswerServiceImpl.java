package com.joseluisestevez.ms.app.answers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.ms.app.answers.clients.ExamFeingClient;
import com.joseluisestevez.ms.app.answers.models.entity.Answer;
import com.joseluisestevez.ms.app.answers.models.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ExamFeingClient examFeingClient;

    @Transactional
    @Override
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
        return answerRepository.saveAll(answers);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId) {
        return answerRepository.findAnswerByStudentAndExam(studentId, examId);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Long> findExamIdWithAnswersAndStudent(Long studentId) {
        return answerRepository.findExamIdWithAnswersAndStudent(studentId);
    }

}
