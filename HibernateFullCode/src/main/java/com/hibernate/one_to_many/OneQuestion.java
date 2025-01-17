package com.hibernate.one_to_many;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class OneQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManyAnswer> list;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ManyAnswer> getList() {
        return list;
    }

    public void setList(List<ManyAnswer> list) {
        this.list = list;
    }
}
