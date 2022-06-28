import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HabitMatchStrategy implements MatchStrategy {

    /**
     * allMembers : 所有參與配對的人(包括user自己)
     * */

    @Override
    public PairTable match(Individual user, List<Individual> allMembers) {
        Collections.sort(allMembers, new Comparator<Individual>() {
            @Override
            public int compare(Individual member1, Individual member2) {
                int number1 = getCommonHabitNumber(user, member1);
                int number2 = getCommonHabitNumber(user, member2);

                if (number1 > number2) {
                    return 1;//i1排前面
                } else if (number1 < number2) {
                    return -1;//i2排前面
                } else {
                    //如果數量相等，將編號較小的那位排前面
                    return (member1.getId() < member2.getId()) ? 1 : -1;
                }
            }
        });
        //註：user和自己的共同興趣量最多，一定是排在最前面(index = 0)
        return new PairTable(allMembers);
    }

    private int getCommonHabitNumber(Individual user, Individual member) {
        //如果member是user，設定共同興趣量為整數最大值
        if (user.getId() == member.getId()) {
            return Integer.MAX_VALUE;
        }
        //如果不是user
        else {
            int commonHabitNumber = 0;
            //查看此人與user有多少興趣交集量
            for (String userHabit : user.getHabits()) {
                if (member.getHabits().contains(userHabit)) {
                    commonHabitNumber++;
                }
            }
            return commonHabitNumber;
        }
    }
}
