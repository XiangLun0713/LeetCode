class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product : products) {
            root.insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(root.search(prefix));
        }
        return result;
    }
}

class Trie {

    private Node root;
    private List<String> result;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public List<String> search(String prefix) {
        Node curr = root;
        result = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return result;
            curr = curr.children[c - 'a'];
        }
        dfs(curr, prefix);
        return result;
    }
    
    private void dfs(Node curr, String prefix) {
        if (result.size() == 3) return;
        if (curr.isWord) result.add(prefix);
        for (int i = 0; i < 26; i++) {
            Node child = curr.children[i];
            if (child != null)
                dfs(child, prefix + (char) (i + 'a'));
        }
    }

    static class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
