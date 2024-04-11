package data;

import java.io.File;

public interface Connection 
{
    String pathFile = "./src/data/students.txt";
    File file = new File(pathFile);
}
