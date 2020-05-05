package lambda.lesson1.predicate;


import lambda.lesson1.Project;
import lambda.lesson1.ProjectPredicate;

/**
 * 按 star 数过滤
 *
 * @author biezhi
 * @date 2018/2/9
 */
public class ProjectStarPredicate implements ProjectPredicate {

    private Integer stars;

    public ProjectStarPredicate(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean test(Project project) {
        return project.getStars() > stars;
    }

}
