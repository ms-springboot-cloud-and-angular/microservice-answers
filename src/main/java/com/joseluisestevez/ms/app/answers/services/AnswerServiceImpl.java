package com.joseluisestevez.ms.app.answers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.ms.app.answers.models.entity.Answer;
import com.joseluisestevez.ms.app.answers.models.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Override
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
        return answerRepository.findAll();
    }

}
