public class resource {
    private String name;
    private List<Skill> skills;

    public resource(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
