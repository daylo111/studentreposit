import java.util.ArrayList;

public class Students {

    private String name;

    private String gpa;

    private String email;

    private String gender;

    public Students() {}

    public Students(String name, String gpa, String email, String gender) {
        this.name = name;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public String getGpa()
    {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }

    public void searchByGender(ArrayList<Students> studentData, String gender) {


        for (Students studentGender : studentData) {
            if (studentGender.getGender().equalsIgnoreCase(gender) == true) {
                System.out.println("Gender found!");
                System.out.printf("" + studentGender.getName() + " " + studentGender.getGpa() + " " + studentGender.getEmail() + "" + studentGender.getGender());
                System.out.println();
            }
        }
    }
    }

