package model;

import java.util.ArrayList;

public class mokupDB implements animalDa {
    private  ArrayList<Animal> animal=new ArrayList<>();
    String q1= "panda can . . . the tree";
    String []OP1=new String[]{"swim", "climb", "swing", "run"};
    String q2= "Fish has . . . to swim";
    String []OP2=new String[]{"flippers", "fins", "legs", "tail"};
    String q3= "Octopus lives in the . . . .";
    String []OP3=new String[]{"land", "water", "tree", "dessert"};
    String q4= "Tiger can . . . . fast";
    String []OP4=new String[]{"climb", "run", "swim", "fly"};
    String q5= "This animal lives at . . . . .";
    String []OP5=new String[]{"water", "tree", "ground", "sky"};
    String q6= "Frog uses its legs to . . . .";
    String []OP6=new String[]{"run", "hop", "fly", "walk"};
    String q7= "Birds has . . . to . . . .";
    String []OP7=new String[]{"wings - climb", "legs - fly", "wings - fly", "body - run"};
    String q8= "This fish has . . . . color";
    String []OP8=new String[]{"orange", "red", "white", "yellow"};
    String q9= "This is dog's . . . .";
    String []OP9=new String[]{"tail", "wings", "head", "legs"};
    String q10= "These are . . . .";
    String []OP10=new String[]{"fins", "tail", "body", "head"};

    public mokupDB() {
        animal.add(new Animal("Q1",q1,"climb",OP1));
        animal.add(new Animal("Q2",q2,"fins",OP2));
        animal.add(new Animal("Q3",q3,"water",OP3));
        animal.add(new Animal("Q4",q4,"run",OP4));
        animal.add(new Animal("Q5",q5,"tree",OP5));
        animal.add(new Animal("Q6",q6,"hop",OP6));
        animal.add(new Animal("Q7",q7,"wings - fly",OP7));
        animal.add(new Animal("Q8",q8,"yellow",OP8));
        animal.add(new Animal("Q9",q9,"tail",OP9));
        animal.add(new Animal("Q10",q10,"fins",OP10));
    }


    @Override
    public String getRightAnswer(String numOfQ) {
        for (Animal element : animal)
        {
            if (element.getNumOfQ().equals(numOfQ))
            {
                return element.getAnswer();
            }
        }
        return null;
    }



    @Override
    public void printList()
    {

        System.out.println(animal.toString()+"\n");
    }
    @Override
    public String[] getNextOptions(int currentIndex) {
      //  int nextIndex = currentIndex + 1;
        if (currentIndex < animal.size()) {
            return animal.get(currentIndex).getOptions();
        } else {
            return null;
        }
    }


    private int cuurQ = 1;
    public String getNextQuestion() {
        if (cuurQ >= animal.size()) {
            cuurQ = 0;
        }
        String nextQ = animal.get(cuurQ).getAnimalQ();
        cuurQ++;
        return nextQ;
    }

    private int currNumQ = 1;
    @Override
    public String getNextNumOfQ() {
        if (currNumQ >= animal.size()) {
            currNumQ = 0;
        }
        String nextNQ = animal.get(currNumQ).getNumOfQ();
        currNumQ++;
        return nextNQ;
    }

    private int currAns = 1;
    @Override
    public int getAnimalListSize() {
        return animal.size();
    }


}
