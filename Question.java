Question.java
package edu.uga.cs1302.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Question {
    protected Country country;
    protected List<String> answerChoices;

    int correctAnswer;
    String userAnswer;
    String[] continents = {"Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America"};

    public Question(Country country) {
        this.country = country;
        generateAnswerChoices();
    }

    private void generateAnswerChoices() {
        answerChoices = new ArrayList<>();
        answerChoices.add(country.getContinent());

        for (int i = 0; i < 3; i++) {
            int randomValue;
            do {
                randomValue = ThreadLocalRandom.current().nextInt(continents.length);
            } while (continents[randomValue].equals(country.getContinent()) || answerChoices.contains(continents[randomValue]));
            answerChoices.add(continents[randomValue]);
        }

        correctAnswer = ThreadLocalRandom.current().nextInt(answerChoices.size());
        List<String> shuffledAnswers = new ArrayList<>(answerChoices);
        answerChoices.clear();
        for (int i = 0; i < shuffledAnswers.size(); i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(shuffledAnswers.size());
            answerChoices.add(shuffledAnswers.get(randomIndex));
            shuffledAnswers.remove(randomIndex);
        }
    }

    public Country getCountry() {
        return country;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public String getCorrectAnswer() {
        return answerChoices.get(correctAnswer);
    }

    public String getQuestion() {
        return "Which continent is " + country.getCountry() + " located in?";
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    @Override
    public String toString() {
        return "Question: " + getQuestion() + "\nA) " + answerChoices.get(0)
            + "\nB) " + answerChoices.get(1)
            + "\nC) " + answerChoices.get(2);
    }
}
