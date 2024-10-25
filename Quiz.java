package edu.uga.cs1302.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz {
    private List<Question> questions;
    private int totalScore;

    public Quiz(CountryCollection countryCollection) {
        questions = new ArrayList<>();
        generateQuiz(countryCollection);
        totalScore = 0;
    }

    private void generateQuiz(CountryCollection countryCollection) {
        List<Country> countries = countryCollection.getCountries();

        // Generate questions
        for (int i = 0; i < 6; i++) {
            Country randomCountry;
            do {
                int randomIndex = ThreadLocalRandom.current().nextInt(countries.size());
                randomCountry = countries.get(randomIndex);
            } while (containsCountry(randomCountry));

            questions.add(new Question(randomCountry));
        }
    }

    private boolean containsCountry(Country country) {
        for (Question question : questions) {
            if (question.getCountry().equals(country)) {
                return true;
            }
        }
        return false;
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void updateScore(String userAnswer, int questionIndex) {
        Question question = questions.get(questionIndex);
        if (userAnswer.equals(question.getCorrectAnswer())) {
            totalScore++;
        }
    }

    public double calculateScore() {
        return ((double) totalScore / questions.size()) * 100.0;
    }

    public void setUserAnswer(int questionIndex, String userAnswer) {
        Question question = questions.get(questionIndex);
        question.setUserAnswer(userAnswer);
    }

    public String getUserAnswer(int questionIndex) {
        Question question = questions.get(questionIndex);
        return question.getUserAnswer();
    }

    @Override
    public String toString() {
        StringBuilder quizString = new StringBuilder();
        for (int i = 0; i < questions.size(); i++) {
            quizString.append("Question ").append(i + 1).append(": ").append(questions.get(i).getCountry().getCountry()).append("\n");
        }
        return quizString.toString();
    }
}
