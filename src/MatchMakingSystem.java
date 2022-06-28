import java.util.List;

public class MatchMakingSystem {

    private MatchStrategy matchStrategy;

    public MatchMakingSystem(MatchStrategy matchStrategy) {
        this.matchStrategy = matchStrategy;
    }

    public PairTable match(Individual user, List<Individual> allMembers) {
        return matchStrategy.match(user, allMembers);
    }

    public void setMatchStrategy(MatchStrategy matchStrategy) {
        this.matchStrategy = matchStrategy;
    }
}

