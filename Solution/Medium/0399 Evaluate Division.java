// Using DFS with graph
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Node>> hashMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String operand1 = equation.get(0);
            String operand2 = equation.get(1);
            hashMap.putIfAbsent(operand1, new ArrayList<>());
            hashMap.get(operand1).add(new Node(operand2, values[i]));
            hashMap.putIfAbsent(operand2, new ArrayList<>());
            hashMap.get(operand2).add(new Node(operand1, 1 / values[i]));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String origin = query.get(0);
            String destination = query.get(1);

            if (!hashMap.containsKey(destination) || !hashMap.containsKey(origin)) {
                result[i] = -1;
            } else if (origin.equals(destination)) {
                result[i] = 1;
            } else {
                result[i] = DFS(hashMap, new HashSet<>(), origin, destination, 1);
            }
        }

        return result;
    }

    // DFS from origin to destination
    // Objective: find a path that leads from origin to destination
    // Return the cumulative multiplication value along the path
    private double DFS(HashMap<String, List<Node>> graph, Set<String> visited, String curr, String destination, double value) {
        Set<String> newVisited = new HashSet<>(visited);
        newVisited.add(curr);
        for (Node node : graph.get(curr)) {
            String nextNode = node.getDest();
            if (visited.contains(nextNode)) continue;  // skip curr loop if we visit the node before
            if (!nextNode.equals(destination)) {
                double res = DFS(graph, newVisited, nextNode, destination, value * node.getWeight());
                if (res != -1) {
                    return res;
                }
            } else {
                return value * node.getWeight();
            }
        }
        return -1;
    }
}

class Node {
    private String dest;
    private double weight;

    public String getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    public Node(String dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }
}
