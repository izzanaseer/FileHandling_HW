public class SkillOnlyMatch implements MatchingStrategy{
    @Override
    public boolean match(Applicant applicant, Task task) {
        List<Skill> requiredSkills = task.getRequiredSkills();
        List<Skill> applicantSkills = applicant.getSkills();

        for (Skill requiredSkill : requiredSkills) {
            boolean skillFound = false;
            for (Skill applicantSkill : applicantSkills) {
                if (applicantSkill.getName().equals(requiredSkill.getName())) {
                    skillFound = true;
                    break;
                }
            }
            if (!skillFound) {
                return false;
            }
        }
        return true;
    }
}
