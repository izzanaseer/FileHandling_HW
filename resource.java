public class resource {
    private String name;
    private List<Skill> skills;

    public Resource(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
