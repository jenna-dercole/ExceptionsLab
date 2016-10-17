package lab0;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private int daysVacation;

    public Employee() {
        // initialize a bunch of default values
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }
    //validation rules: 
    //- daysVacation must be between 0 and 120 inclusive.
    public void setDaysVacation(int daysVacation) throws IllegalArgumentException {
        if(daysVacation < 0 || daysVacation > 120) {
            throw new IllegalArgumentException("Vacation days must be between 0 and 120 inclusive.");
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }
    //validation rules: no numbers, no spaces, 
    public final void setFirstName(String firstName) {
       if(firstName == null || firstName.equals("")) {
           throw new IllegalArgumentException("First name cannot be empty!");
       }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    //Validation rules: no null values, no empty strings, no names larger than 50 chars, 
    //not exclusively spaces, no name should start with a space, plus apostrophe, plus hyphens. 
    public void setLastName(String lastName) {
        char[] lastNameChars = lastName.toCharArray();
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("Last name cannot be empty!");
        } else if (lastName.length() > 50) {
            throw new IllegalArgumentException("Last name cannot be greater than 50 characters!");
        } else if (lastName.trim().equals("")) {
            throw new IllegalArgumentException("Last name cannot be all spaces!");
        } else if (lastName.indexOf(" ") == 0) {
            throw new IllegalArgumentException("Last name cannot start with a space!");
        } else if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number!");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }
    
    //validation rules: -must be in ssn format: xxx-xx-xxxx, no letters,
    //only allow digits and hyphens
    //only allows two hyphens
    //cannot all be zero
    //
    public void setSsn(String ssn) {
        String[] parts = ssn.split("-");
        if(ssn.length() < 9 || ssn.length() > 11) {
            throw new IllegalArgumentException();
        } 
        
        if (parts.length != 3 || parts.length != 1) {
            throw new IllegalArgumentException();
        } 
        
        char[] chars = ssn.toCharArray(); //send all digits to an array;
        for (char c : chars) {
            if (!Character.isDigit(c));
            throw new IllegalArgumentException();
        }
        this.ssn = ssn;
    }
    
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setLastName("dafdsf23434");
    }
    
}
