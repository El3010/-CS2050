// Jose Lopez
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(String word) {
        if (root == null) {
            root = new TreeNode(word);
        } else {
            insert(root, word);
        }
    }

    private void insert(TreeNode node, String word) {
        if (word.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new TreeNode(word);
            } else {
                insert(node.left, word);
            }
        } else if (word.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new TreeNode(word);
            } else {
                insert(node.right, word);
            }
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getMaxNodes(int height) {
        return (int) Math.pow(2, height) - 1;
    }

    public void analyzeTree(String analysisFileName) throws IOException {
        int nodeCount = countNodes();
        int treeHeight = getHeight();
        int maxNodes = getMaxNodes(treeHeight);

        FileWriter writer = new FileWriter(analysisFileName);
        writer.write("Number of nodes: " + nodeCount + "\n");
        writer.write("Height of the tree: " + treeHeight + "\n");
        writer.write("Maximum possible nodes for the given height: " + maxNodes + "\n");
        writer.close();
    }
}

public class Program8 {
    public static void main(String[] args) throws IOException {
        String inputFileName = "dracula.txt";
        String analysisFileName = "analysis.txt";
        BST bst = new BST();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    // Remove special characters and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z']", "").toLowerCase();

                    // Ignore words with numbers
                    if (!word.matches(".*\\d+.*") && !word.isEmpty()) {
                        bst.insert(word);
                    }
                }
            }
        }

        bst.analyzeTree(analysisFileName);
        System.out.println("Analysis data written to " + analysisFileName);
    }
}
