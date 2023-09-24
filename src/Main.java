import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<task> tasks = new ArrayList<>();
        String taskPath = "tasks.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(taskPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String taskName = parts[0].trim();
                    task task = new task(taskName);

                    for (int i = 1; i < parts.length; i++) {
                        String[] skillData = parts[i].split(":");
                        if (skillData.length == 2) {
                            String skillName = skillData[0].trim();
                            int skillLevel = Integer.parseInt(skillData[1].trim());
                            Skill skill = new Skill(skillName, skillLevel);
                            task.addRequiredSkill(skill);
                        }
                    }

                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<resource> applicants = new ArrayList<>();
        String filePath = "applicants.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0];
                    resource applicant = new resource(name);

                    for (int i = 1; i < parts.length; i++) {
                        String[] skillData = parts[i].split(":");
                        if (skillData.length == 2) {
                            String skillName = skillData[0];
                            int experience = Integer.parseInt(skillData[1]);
                            skill skill = new skill(skillName, experience);
                            applicant.addSkill(skill);
                        }
                    }
                    applicants.add(applicant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        MatchingStrategy exactMatch = new ExactMatch();
        MatchingStrategy skillOnlyMatch = new SkillOnlyMatch();


        for (task task : tasks) {
            System.out.println("Task: " + task.getName());

            System.out.println("Qualified Applicants (Exact Match):");
            for (resource applicant : applicants) {
                if (task.isQualified(applicant, exactMatch)) {
                    System.out.println("  Applicant: " + applicant.getName());
                }
            }

            System.out.println("Qualified Applicants (Skill-Only Match):");
            for (resource applicant : applicants) {
                if (task.isQualified(applicant, skillOnlyMatch)) {
                    System.out.println("  Applicant: " + applicant.getName());
                }
            }

            System.out.println();
        }
    }
}