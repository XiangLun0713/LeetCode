class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int numOfRow = board.length;
        int numOfCol = board[0].length;
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int row = 0; row < numOfRow; row++) {
            for (int col = 0; col < numOfCol; col++) {
                dfs(result, row, col, root, board);
            }
        }

        return result;
    }
    
    private void dfs(List<String> result, int row, int col, TrieNode node, char[][] board) {
        char curr = board[row][col];
        if (curr == '#' || node.next[curr - 'a'] == null) return;

        node = node.next[curr - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';
        if (row > 0) dfs(result, row - 1, col, node, board);
        if (col > 0) dfs(result, row, col - 1, node, board);
        if (row < board.length - 1) dfs(result, row + 1, col, node, board);
        if (col < board[0].length - 1) dfs(result, row, col + 1, node, board);
        board[row][col] = curr;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode pointer = root;
            for (char c : word.toCharArray()) {
                int temp = c - 'a';
                if (pointer.next[temp] == null) pointer.next[temp] = new TrieNode();
                pointer = pointer.next[temp];
            }
            pointer.word = word;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
