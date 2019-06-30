package dijkstras_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 迪克斯特拉算法
 * 思路：
 * 1 找出最短时间节点
 * 2 更新该节点邻居的开销
 * 3 重复上面两步直到图中的每个点这么做
 * 4 计算最终路径
 */
public class DijkstrasAlgorithm {

    // the graph
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    private static String findLowestCostNode(Map<String, Double> costs){
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        // Go through each node
        for (Map.Entry<String, Double> node : costs.entrySet()){
            Double cost = node.getValue();

            if(cost < lowestCost && !processed.contains(node.getKey())){
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }
}
