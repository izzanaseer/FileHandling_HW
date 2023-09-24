public class skill {
    private String name;
    private String skillLevel;

    public skill(String name, String skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }
}
