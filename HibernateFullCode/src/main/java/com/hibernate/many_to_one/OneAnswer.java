package com.hibernate.many_to_one;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OneAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oneAnswerId;
    private String oneAnswer;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<ManyQuestion> manyQuestion;


    public List<ManyQuestion> getManyQuestion() {
        return manyQuestion;
    }

    public void setManyQuestion(List<ManyQuestion> manyQuestion) {
        this.manyQuestion = manyQuestion;
    }

    public String getOneAnswer() {
        return oneAnswer;
    }

    public void setOneAnswer(String oneAnswer) {
        this.oneAnswer = oneAnswer;
    }

    public int getOneAnswerId() {
        return oneAnswerId;
    }

    public void setOneAnswerId(int oneAnswerId) {
        this.oneAnswerId = oneAnswerId;
    }

    @Override
    public String toString() {
        return "OneAnswer{" +
                "manyQuestion=" + manyQuestion +
                ", oneAnswerId=" + oneAnswerId +
                ", oneAnswer='" + oneAnswer + '\'' +
                '}';
    }

    public OneAnswer() {
    }
}
