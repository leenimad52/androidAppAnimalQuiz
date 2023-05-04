package model;

import java.util.Arrays;

public class Animal {

    private String numOfQ;
    private String AnimalQ;
   private String Answer;
    private String Options[];

    public Animal(String NumOfQ, String animalQ, String answer, String[] options) {
        numOfQ = NumOfQ;
        AnimalQ = animalQ;
        Answer = answer;
        Options = options;
    }

    public String getAnimalQ() {
        return AnimalQ;
    }

    public void setAnimalQ(String animalQ) {
        AnimalQ = animalQ;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String[] getOptions() {
        return Options;
    }

    public void setOptions(String[] options) {
        Options = options;
    }

    public String getNumOfQ() {
        return numOfQ;
    }

    public void setNumOfQ(String numOfQ) {
        this.numOfQ = numOfQ;
    }

    @Override

    public String toString() {
        return "Animal{" +
                "numOfQ='" + numOfQ + '\'' +
                ", AnimalQ='" + AnimalQ + '\'' +
                ", Answer='" + Answer + '\'' +
                ", Options=" + Arrays.toString(Options) +
                '}';
    }
}
