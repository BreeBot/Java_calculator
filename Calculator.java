import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
  //public static final String INPUT_FILE = "problem.txt";
  public static final String INPUT_FILE = "problems.txt";
  public static final String RESULT_PATH = "results.txt";


  public static void main(String[] args) throws IOException {
    File problem = new File(INPUT_FILE);
    File fileToWriteTo = new File(RESULT_PATH);
    FileWriter fileWriter = new FileWriter(fileToWriteTo);

    //String content = new Scanner(problem).useDelimiter("\\z").next();
    Scanner scanner = new Scanner(problem);

    int result = 0;
    boolean addition = false;
    boolean multiplication = false;

    while (scanner.hasNextLine()) {
      String currentLine = scanner.nextLine();

      if (currentLine.equals("+")) {
        addition = true;
        multiplication = false;
      } else if (currentLine.equals("*")){
        result = 1;
        multiplication = true;
        addition = false;
      } else if (currentLine.equals("=")) {
        fileWriter.write(result + "\n");
        System.out.println("The result is:"+ result);
        result = 0;
      } else {
        if (addition) {
          result += Integer.parseInt(currentLine);
        } else if (multiplication) {
          result *= Integer.parseInt(currentLine);
        }

      }
    }
    fileWriter.close();

  }

}
