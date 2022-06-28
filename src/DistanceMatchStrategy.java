import java.util.*;

public class DistanceMatchStrategy implements MatchStrategy {

    /**
     * allMembers : 所有參與配對的人(包括user自己)
     * */

    @Override
    public PairTable match(Individual user, List<Individual> allMembers) {
        Collections.sort(allMembers, new Comparator<Individual>() {
            @Override
            public int compare(Individual member1, Individual member2) {
                Coordinate userCoordinate = user.getCoordinate();
                double x1 = member1.getCoordinate().getX();
                double y1 = member1.getCoordinate().getY();
                //user與member1的距離
                double distance1 = userCoordinate.getDistance(x1, y1);

                double x2 = member2.getCoordinate().getX();
                double y2 = member2.getCoordinate().getY();
                //user與member2的距離
                double distance2 = userCoordinate.getDistance(x2, y2);

                //如果member1與user距離較小，member1排前面；反之member2排前面
                return (distance1 < distance2) ? 1 : -1;
            }
        });
        //註：user和自己的距離為0，一定是排在最前面(index = 0)
        return new PairTable(allMembers);
    }
}
