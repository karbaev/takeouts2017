package PiratesSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Danila on 31.01.2017.
 */
public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<DataNode> nodeList = new ArrayList<>();
        nodeList.add(new DataNode("Bill1", 200));
        nodeList.add(new DataNode("Silver", 100));
        nodeList.add(new DataNode("One-leg", 5));

        DataNode dn = new DataNode("aaa", 333);
        DataNode dd = (DataNode)dn.clone();
        System.out.println(dd);

        //1st variant
        // Collections.sort(nodeList);

        //2nd variant
/*
        nodeList.sort(new Comparator<PiratesSort.DataNode>() {
            @Override
            public int compare(PiratesSort.DataNode o1, PiratesSort.DataNode o2) {
                if(o1.getValue() == o2.getValue()) return 0;
                return o1.getValue()<o2.getValue() ? -1 : -1;
            }
        });
*/

        //3rd variant
        Collections.sort(nodeList, ((o1, o2) -> o1.getValue() - o2.getValue()));

        System.out.println(nodeList);

    }
}
