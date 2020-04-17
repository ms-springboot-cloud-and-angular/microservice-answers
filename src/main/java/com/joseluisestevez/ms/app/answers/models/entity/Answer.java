package com.joseluisestevez.ms.app.answers.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joseluisestevez.ms.commons.exams.models.entity.Question;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "answers")
public class Answer {

    @Id
    private String id;

    private String text;

    @Transient
    private Student student;

    private Long studentId;

    @Transient
    private Question question;

    private Long questionId;
}
