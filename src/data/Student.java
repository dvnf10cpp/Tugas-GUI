package data;
public class Student 
{
    private String name;
    private String nim;

    public Student(String name, String nim)
    {
        this.name = name;
        this.nim = nim; 
    }

    public boolean isMatch(Student student)
    {
        return this.name.equals(student.getName()) && this.nim.equals(student.getNim());
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getNim() 
    {
        return nim;
    }

    public void setNim(String nim) 
    {
        this.nim = nim;
    }

    public String toString()
    {
        return this.name + ";" + this.nim; 
    }
}