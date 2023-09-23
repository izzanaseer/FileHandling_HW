public class task {
    private String name;
    private List<Skill> requiredSkills;

    public Task(String name) {
        this.name = name;
        this.requiredSkills = new ArrayList<>();
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
}
