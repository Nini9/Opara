import java.util.ArrayList;

/**
 * TestHarness
 */
public class TestHarness {

    public TestHarness() {
        testPeople();
        testBalance();
    }
    
    //test interface and polymorphism 
    public void testInterface()
    {
        ArrayList<Fireable> listItems = new ArrayList<>();
        Student studentA = new Student("Joe", "Smith", "jsmith@psu.edu", "980387746", "Junior");
        Faculty facultyA = new Faculty("Sam", "Deik", "sdeik@psu.edu", "938539903", "10/20/2010");
        listItems.add(studentA);
        listItems.add(facultyA);

        for (Fireable listItem : listItems)
        {
            listItem.firePerson();
        }
    }

    //test inheritance 
    public void testClassHierarchy()
    {
        ArrayList<People> people = new ArrayList<>();
        Student studentA = new Student("Joe", "Smith", "jsmith@psu.edu", "980387746", "Junior");
        Faculty facultyA = new Faculty("Sam", "Deik", "sdeik@psu.edu", "938539903", "10/20/2010");
        people.add(studentA);
        people.add(facultyA);

        for (People person: people){
            person.accessCanvas();
        }
    }
    
    //test for the people class
    public void testPeople() 
    {
        People person = new People("Alex", "Jones", "ajones@psu.edu", "909887363");
        //test to make sure the constrcutor works 
        if ((person.toString()) != null)
        {
            System.out.println("Success. The people class is working.");
            System.out.println(person.toString());
        }

        //test the set methods for the people class 
        System.out.println("Checking the setters...");
        person.setFirstName("Susan");
        person.setLastName("Falker");
        person.setEmail("susanf@psu.edu");
        person.setUserID("989402234");

        //test the get methods for the people class 
        System.out.println("Checking the getters...");
        person.getFirstName();
        person.getLastName();
        person.getEmail();
        person.getUserID();
    }

    //test fot the Balnce class 
    public void testBalance() 
    {
        Balance remainingBal = new Balance(115.40, "02/15/21");
        //test to make sure the constructor works 
        if (remainingBal.toString() != null)
        {
            System.out.println("Success. The balance class is working.");
            System.out.println(remainingBal.toString());
        }
        //test the set methods for the balance class
        System.out.println("Checking the setters...");
        remainingBal.setCurrentBalance(90.0);
        remainingBal.setDate("02/25/21"); 

        //test the get methods for the people class
        System.out.println("Checking the getters...");
        remainingBal.getCurrentBalance();
        remainingBal.getDate();
    }

}