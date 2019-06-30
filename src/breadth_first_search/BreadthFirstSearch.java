package breadth_first_search;

import java.util.*;

/**
 * 广度优先算法
 * 思路： 使用散列表（Map集合健为String类型，值为字符数组），检查时先获取其中一个键对应的值，检查值中的数据是否符合要求，如果不符合，查看该数据
 * 是否有子数据，有的话继续查找，没有的话就下一个值，依次检查，直到检查到需要的数据
 */
public class BreadthFirstSearch {

    private static Map<String, List<String>> graph = new HashMap<>();

    private static boolean search(String name){
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name)); // 创建存放查找队列对象
        List<String> searched = new ArrayList<>(); // 创建数组，用于记录已经检查的数据

        // 对队列数据进行检查
        while(!searchQueue.isEmpty()){
            String person = searchQueue.poll();// 出列数据
            if (!searched.contains(person)){
                if(person_is_seller(person)){
                    System.out.println(person + " is a mango seller!");
                    return true;
                }else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }
    // 检查是否为要找的目标数据
    private static boolean person_is_seller(String name){
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice","bob","claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search("you");
    }
}
