import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "applicant.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0];
                    System.out.println("Applicant: " + name);

                    for (int i = 1; i < parts.length; i++) {
                        String[] skillData = parts[i].split(":");
                        if (skillData.length == 2) {
                            String skill = skillData[0];
                            int experience = Integer.parseInt(skillData[1]);
                            System.out.println("  Skill: " + skill + ", Experience: " + experience + " years");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}