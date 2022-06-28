import java.util.List;

public class PairTable {

    List<Individual> list;

    public PairTable(List<Individual> list) {
        this.list = list;
    }

    public List<Individual> getList() {
        return list;
    }

    public Individual getIndividual() {
        return list.get(1);//因為第0位是user本身，所以要從1開始才是被配對到的人
    }

    public Individual getReverseIndividual() {
        return list.get(list.size() - 1);//取最後一個，代表反向策略的第一個
    }
}
