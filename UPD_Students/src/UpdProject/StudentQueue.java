package UpdProject;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentQueue
{
    ArrayList<Students> list = new ArrayList<>();

    public void add(int id, String first, String last, int score)
    {
        list.add(new Students(id,first, last, score));
        System.out.println("Server: Add to the database successful\n");
    }

    public void displayID(int id)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                list.get(i).printInfo();
                break;
            }
            else if(i == (list.size() - 1))
                System.out.println("Server: ID not found");
        }
    }

    public void displayScore(int score)
    {
        System.out.println();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getScore() > score)
                list.get(i).printInfo();
        }

        System.out.println("Server: Completed showing of all scores");
    }

    public void displayAll()
    {
        if(list.size() == 0)
        {
            System.out.println("Server: Database is empty");
        }
        for(int i = 0; i < list.size(); i++)
            list.get(i).printInfo();
    }

    public void delete(int id)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
                list.remove(list.get(i));
        }

        System.out.println("Server: Delete successful");
    }

    public void start()
    {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        boolean goAgain = true;

        while(goAgain)
        {
            System.out.println("\nBrandon Alfred's Hw2 Program\n");

            System.out.println("---Main Menu---");
            System.out.println("Press 1, 2, 3, 4, 5, or 9\n");

            System.out.println("1. add()");
            System.out.println("2. display(ID)");
            System.out.println("3. display(score)");
            System.out.println("4. display_all");
            System.out.println("5. delete(ID)");
            System.out.println("9. EXIT\n");

            int input = s.nextInt();

            switch(input)
            {
                case 1:
                    int id;
                    String first;
                    String last;
                    int score;

                    System.out.println("Server: Enter ID ");
                    id = s.nextInt();

                    System.out.println("Server: Enter First Name ");
                    first = s.next();

                    System.out.println("Server: Enter Last Name ");
                    last = s.next();

                    System.out.println("Server: Enter Score ");
                    score = s.nextInt();

                    add(id, first, last, score);
                    break;

                case 2:
                    System.out.println("Server: Enter ID to search for ");
                    int id2 = s.nextInt();

                    displayID(id2);
                    break;

                case 3:
                    System.out.println("Server: Enter score to search for ");
                    int score2 = s.nextInt();

                    displayScore(score2);
                    break;

                case 4:
                    System.out.println("\nServer: Showing all entries...\n");

                    displayAll();
                    break;

                case 5:
                    System.out.println("Server: Enter ID of student to delete ");
                    int id3 = s.nextInt();

                    delete(id3);
                    break;

                case 9:
                    goAgain = false;

                    System.out.println("Server: Exit Successful");
                    break;
            }
        }
    }
}
