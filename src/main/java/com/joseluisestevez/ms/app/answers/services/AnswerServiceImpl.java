package com.joseluisestevez.ms.app.answers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluisestevez.ms.app.answers.clients.ExamFeingClient;
import com.joseluisestevez.ms.app.answers.models.entity.Answer;
import com.joseluisestevez.ms.app.answers.models.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ExamFeingClient examFeingClient;

    @Override
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
        return answerRepository.saveAll(answers);
    }

    @Override
    public Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId) {
        /**
         * <pre>
         * Exam exam = examFeingClient.getExamById(examId);
         * List<Question> questions = exam.getQuestions();
         * List<Long> questionIds = questions.stream().map(q -> q.getId()).collect(Collectors.toList());
         * List<Answer> answers = (List<Answer>) answerRepository.findAnswerByStudentAndQuestionIds(studentId, questionIds);
         * answers = answers.stream().map(a -> {
         *     questions.forEach(q -> {
         *         if (q.getId().equals(a.getQuestionId())) {
         *             a.setQuestion(q);
         *         }
         *     });
         *     return a;
         * }).collect(Collectors.toList());
         * return answers;
         * </pre>
         */
        return answerRepository.findAnswerByStudentAndExam(studentId, examId);
    }

    @Override
    public Iterable<Long> findExamIdWithAnswersAndStudent(Long studentId) {
        /**
         * <pre>
         * List<Answer> answers = (List<Answer>) this.findByStudentId(studentId);
         * List<Long> examIds = Collections.emptyList();
         * if (answers != null && !answers.isEmpty()) {
         *     List<Long> questionIds = answers.stream().map(a -> a.getQuestionId()).collect(Collectors.toList());
         *     examIds = examFeingClient.getAnsweredByQuestions(questionIds);
         * }
         *
         * return examIds;
         * </pre>
         */
        List<Answer> answers = (List<Answer>) answerRepository.findExamIdWithAnswersAndStudent(studentId);
        return answers.stream().map(a -> a.getQuestion().getExam().getId()).distinct().collect(Collectors.toList());
    }

    @Override
    public Iterable<Answer> findByStudentId(Long studentId) {
        return answerRepository.findByStudentId(studentId);
    }

}
