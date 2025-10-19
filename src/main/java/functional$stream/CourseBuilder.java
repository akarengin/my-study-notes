package functional$stream;

public class CourseBuilder {

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public CourseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public CourseBuilder setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
        return this;
    }

    public CourseBuilder setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
        return this;
    }

    public Course build() {
        return new Course(name, category, reviewScore, noOfStudents);
    }
}
