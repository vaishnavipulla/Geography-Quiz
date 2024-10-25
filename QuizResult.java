QuizResult.java
package edu.uga.cs1302.quiz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizResult implements Serializable {
    private List<QuizScore> scores;
   
    public QuizResult() {
        scores = new ArrayList<>();
    }

    public void addScore(int score) {
        QuizScore quizScore = new QuizScore(score);
        scores.add(0, quizScore);
    }

    public List<QuizScore> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (QuizScore score : scores) {
            resultString.append(score).append("\n");
        }
        return resultString.toString();
    }
}
