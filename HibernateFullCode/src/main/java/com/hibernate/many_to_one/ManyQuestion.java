package com.hibernate.many_to_one;

import jakarta.persistence.*;

@Entity
public class ManyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int manyAnswerId;
    private String manyQuestion;
    @ManyToOne
    @JoinColumn(name = "oneAnswerId")
    private OneAnswer answer;
    public  ManyQuestion(){

    }

    public OneAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(OneAnswer answer) {
        this.answer = answer;
    }

    public int getManyAnswerId() {
        return manyAnswerId;
    }

    public void setManyAnswerId(int manyAnswerId) {
        this.manyAnswerId = manyAnswerId;
    }

    public String getManyQuestion() {
        return manyQuestion;
    }

    public void setManyQuestion(String manyQuestion) {
        this.manyQuestion = manyQuestion;
    }
}
