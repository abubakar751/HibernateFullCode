package com.hibernate.one_to_one;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int answerId;
    private String answer;
    @OneToOne
    private Question question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", answerId=" + answerId +
                ", question=" + question +
                '}';
    }

    public Answer(String answer, int answerId, Question question) {
        this.answer = answer;
        this.answerId = answerId;
        this.question = question;
    }

    public Answer() {
    }
}
