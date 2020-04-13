package com.joseluisestevez.ms.app.answers.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.ms.app.answers.models.entity.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
