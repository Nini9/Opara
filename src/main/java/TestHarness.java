import java.util.ArrayList;

/**
 * TestHarness
 */
public class TestHarness {

<<<<<<< HEAD
    // TestHarness Constructor
    public TestHarness() {
        // Running the inheritance and interface method
        testClassHierarchy();
        testInterface();

        // Running the manual test unit
        testPerson();
        testBalance();
    }

    // test interface and polymorphism
    public void testInterface() {
=======
    public TestHarness() {
        testPeople();
        testBalance();
    }
    
    //test interface and polymorphism 
    public void testInterface()
    {
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
        ArrayList<Fireable> listItems = new ArrayList<>();
        Student studentA = new Student("Joe", "Smith", "jsmith@psu.edu", "980387746", "Junior");
        Faculty facultyA = new Faculty("Sam", "Deik", "sdeik@psu.edu", "938539903", "10/20/2010");
        listItems.add(studentA);
        listItems.add(facultyA);

<<<<<<< HEAD
        for (Fireable listItem : listItems) {
=======
        for (Fireable listItem : listItems)
        {
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
            listItem.firePerson();
        }
    }

<<<<<<< HEAD
    // test inheritance
    public void testClassHierarchy() {
        ArrayList<Person> people = new ArrayList<>();
=======
    //test inheritance 
    public void testClassHierarchy()
    {
        ArrayList<People> people = new ArrayList<>();
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
        Student studentA = new Student("Joe", "Smith", "jsmith@psu.edu", "980387746", "Junior");
        Faculty facultyA = new Faculty("Sam", "Deik", "sdeik@psu.edu", "938539903", "10/20/2010");
        people.add(studentA);
        people.add(facultyA);

<<<<<<< HEAD
        for (Person person : people) {
            person.accessCanvas();
        }
    }

    // test for the Person class
    public void testPerson() {
        Person person = new Person("Alex", "Jones", "ajones@psu.edu", "909887363");
        // test to make sure the constrcutor works
        if ((person.toString()) != null) {
=======
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
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
            System.out.println("Success. The people class is working.");
            System.out.println(person.toString());
        }

<<<<<<< HEAD
        // test the set methods for the people class
        System.out.println("Checking the Person setters...");
=======
        //test the set methods for the people class 
        System.out.println("Checking the setters...");
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
        person.setFirstName("Susan");
        person.setLastName("Falker");
        person.setEmail("susanf@psu.edu");
        person.setUserID("989402234");
<<<<<<< HEAD
        System.out.println("Checking the Person setters ends...");

        // test the get methods for the people class
        System.out.println("Checking the Person getters...");
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getEmail());
        System.out.println(person.getUserID());
        System.out.println("Checking the Person getters ends...");
    }

    // test fot the Balnce class
    public void testBalance() {
        Balance remainingBal = new Balance(115.40, "02/15/21");
        // test to make sure the constructor works
        if (remainingBal.toString() != null) {
            System.out.println("Success. The balance class is working.");
            System.out.println(remainingBal.toString());
        }
        // test the set methods for the balance class
        System.out.println("Checking the balance setters...");
        remainingBal.setCurrentBalance(90.0);
        remainingBal.setDate("02/25/21");
        System.out.println("Checking the balance setters ends...");

        // test the get methods for the people class
        System.out.println("Checking the balance getters...");
        System.out.println(remainingBal.getCurrentBalance());
        System.out.println(remainingBal.getDate());
        System.out.println("Checking the balance getters ends...");
=======

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
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
    }

}