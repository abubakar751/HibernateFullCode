package com.hibernate.one_to_many;

import com.hibernate.one_to_one.Question;
import jakarta.persistence.*;

@Entity
public class ManyAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private OneQuestion question;

    public ManyAnswer() {
    }

    public ManyAnswer(String answer, int answerId, OneQuestion question) {
        this.answer = answer;
        this.answerId = answerId;
        this.question = question;
    }

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

    public OneQuestion getQuestion() {
        return question;
    }

    public void setQuestion(OneQuestion question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ManyAnswer{" +
                "answer='" + answer + '\'' +
                ", answerId=" + answerId +
                ", question=" + question +
                '}';
    }
}
