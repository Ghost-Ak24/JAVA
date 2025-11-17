
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


public class AgeValidator
    static void validate(int age) throws InvalidAgeException 
    {
        if (age < 18) 
        {
            throw new InvalidAgeException("Invalid age: must be 18 or above.");
        } 
        else 
        {
            System.out.println("Welcome! You are eligible.");
        }
    }
    
    public static void main(String[] args)
    {
        try 
        {
            validate(15);
            
        } catch (InvalidAgeException e) 
        {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
