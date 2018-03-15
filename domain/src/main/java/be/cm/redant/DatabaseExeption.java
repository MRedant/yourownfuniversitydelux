package be.cm.redant;

public class DatabaseExeption extends RuntimeException{
    public DatabaseExeption(String message){
        super(message);
    }
}
