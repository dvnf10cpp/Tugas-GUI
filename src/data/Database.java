package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import tools.console;

public class Database implements Connection
{
    private static ArrayList<Student> db = init(pathFile);
    
    public static ArrayList<Student> init(String pathFile)
    {
        ArrayList<Student> temp = new ArrayList<>();

        Scanner cin; String tempLine;
        try {
            cin = new Scanner(file); 
            while(cin.hasNextLine())
            {
                tempLine = cin.nextLine();
                fetchData(temp, tempLine);
            }
            cin.close();
        } catch (Exception e) {console.log(e.getMessage()); return new ArrayList<Student>();}


        return temp;
    }

    private static void fetchData(ArrayList<Student> temp, String data)
    {
        String name, nim;
        String[] students;   

        students = data.split(";");
        name = students[0]; nim = students[1];

        temp.add(new Student(name, nim));
    }

    private static void addData(Student student)
    {
        try {
            FileWriter writer = new FileWriter(pathFile, true);
            String data = student.toString();
            BufferedWriter bf = new BufferedWriter(writer);
            bf.write(data); bf.newLine(); bf.close();

        } catch (Exception e) {console.log(e.getMessage());}
    }


    public static void insertStudent(Student student)
    {
        db.add(student);
        try {
            addData(student);
        } catch (Exception e) {console.log(e.getMessage());}
    }

    public static boolean hasStudent(Student check)
    {   
        for(Student student : db)
        {
            if(student.isMatch(check))
                return true;
        }
        return false;
    }
}
