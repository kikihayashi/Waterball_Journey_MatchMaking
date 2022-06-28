import java.util.Set;

public class Individual {

    public enum Gender {
        MALE, FEMALE;
    }

    private int id;
    private Gender gender;
    private int age;
    private String introduction;
    private Set<String> habits;
    private Coordinate coordinate;

    public Individual(int id, Gender gender, int age, String introduction, Set<String> habits, Coordinate coordinate) {
        this.id = id;
        this.gender = gender;
        setAge(age);
        setIntroduction(introduction);
        setHabits(habits);
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = ageShouldBe(age, 18);
    }

    private int ageShouldBe(int age, int min) {
        if (age < 18) {
            throw new IllegalArgumentException(
                    String.format("年齡必須在%d以上", min));
        }
        return age;
    }

    private void setHabits(Set<String> habits) {
        this.habits = habitShouldBe(habits, 1, 10);
    }

    private Set<String> habitShouldBe(Set<String> habits, int min, int max) {
        for (String habit : habits) {
            if (habit.length() < min || habit.length() > max) {
                throw new IllegalArgumentException(
                        String.format("興趣的長度必須介於%d ~ %d之間", min, max));
            }
        }
        return habits;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introductionShouldBe(introduction, 200);
    }

    private String introductionShouldBe(String introduction, int max) {
        if (introduction.length() > max){
            throw new IllegalArgumentException(
                    String.format("自介的長度必須在%d字以內", max));
        }
        return introduction;
    }
}
