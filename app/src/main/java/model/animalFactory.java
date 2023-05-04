package model;

public class animalFactory {
    public animalDa getModel()
    {
        return new mokupDB(); //poly
    }
}
