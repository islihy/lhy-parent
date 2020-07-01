package lambda.lesson1.predicate;


import lambda.lesson1.Project;
import lambda.lesson1.ProjectPredicate;

/**
 * 按编程语言过滤
 *
 * @author biezhi
 * @date 2018/2/9
 */
public class ProjectLanguagePredicate implements ProjectPredicate {

    private String language;

    public ProjectLanguagePredicate(String language) {
        this.language = language;
    }

    @Override
    public boolean test(Project project) {
        return language.equals(project.getLanguage());
    }
}