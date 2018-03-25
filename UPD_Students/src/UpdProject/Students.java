package UpdProject;

public class Students
{
    private int id;
    private String firstName;
    private String lastName;
    private int score;

    public Students(int id, String first, String last, int score)
    {
        this.setId(id);
        this.setFirstName(first);
        this.setLastName(last);
        this.setScore(score);
    }

    public Students()
    {

    }

    public void printInfo()
    {
        System.out.println("ID: " + this.getId());
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Score: " + this.getScore());
        System.out.println();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

}

