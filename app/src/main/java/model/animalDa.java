package model;

import java.util.ArrayList;
import java.util.List;

public interface animalDa {
    String getRightAnswer(String animal);
    String[] getNextOptions(int q);
    void printList();

    String getNextQuestion();
    String getNextNumOfQ();
    int getAnimalListSize();

}
