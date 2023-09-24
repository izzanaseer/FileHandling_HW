import java.util.ArrayList;
import java.util.List;

public class task {
    private String name;
    private List<Skill> requiredSkills = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRequiredSkill(Skill skill) {
        requiredSkills.add(skill);
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public boolean isQualified(Applicant applicant, MatchingStrategy strategy) {
        return strategy.match(applicant, this);
    }
}
