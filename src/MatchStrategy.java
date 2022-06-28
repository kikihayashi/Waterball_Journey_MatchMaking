import java.util.List;

public interface MatchStrategy {
    PairTable match(Individual user, List<Individual> allMembers);
}
