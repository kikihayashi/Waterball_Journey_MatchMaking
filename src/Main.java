import java.util.List;

public class Main {

    private static List<Individual> allMembers;
    private static Individual user;

    public static void main(String[] args) {

        DistanceMatchStrategy distanceMatchStrategy = new DistanceMatchStrategy();
        HabitMatchStrategy habitMatchStrategy = new HabitMatchStrategy();

        //設定距離策略
        MatchMakingSystem system = new MatchMakingSystem(distanceMatchStrategy);
        //距離先決
        Individual distanceMatchPerson = system.match(user, allMembers).getIndividual();
        //距離先決(反向)
        Individual distanceMatchReversePerson = system.match(user, allMembers).getReverseIndividual();

        //設定興趣策略
        system.setMatchStrategy(habitMatchStrategy);
        //興趣先決
        Individual habitMatchPerson = system.match(user, allMembers).getIndividual();
        //興趣先決(反向)
        Individual habitMatchReversePerson = system.match(user, allMembers).getReverseIndividual();

    }
}
