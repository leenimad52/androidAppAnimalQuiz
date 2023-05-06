package model;

import java.util.ArrayList;
import java.util.List;

public interface animalDa {
    String getRightAnswer(String animal);
    String[] getNextOptions(int q);
    String getNextQuestion();
    String getNextNumOfQ();
    int getAnimalListSize();
    public String getFirtsQuestion();
    public String getFirtsNumOfQuestion();
    public String getFirtsAnswer();
    public String[] getFirtsOptions();

}
