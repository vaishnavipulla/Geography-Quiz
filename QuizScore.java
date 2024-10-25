QuizScore.java
package edu.uga.cs1302.quiz;

import java.io.Serializable;
import java.util.Date;

public class QuizScore implements Serializable {
    private Date quizDate;
    private int score;

    public QuizScore(int score) {
        this.quizDate = new java.util.Date();
        this.score = score;
    }

    public Date getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(Date quizDate) {
        this.quizDate = quizDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "QuizScore{" +
            "quizDate=" + quizDate +
            ", score=" + score +
            '}';
    }
}
