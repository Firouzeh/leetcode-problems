public class TreeNode {

    char c;
    TreeNode[] left;
    TreeNode[] right;
    boolean hasLeft;
    boolean hasRight;
    boolean isBinary = true;

    // Adds a child 'n' to this node
    public void addLeft(TreeNode n, int index) {
        this.left[index] = n;
        hasLeft = true;
    }

    public void addRight(TreeNode n, int index) {
        this.right[index] = n;
        hasRight = true;
    }

    public void addChild(TreeNode n, int index) {
        if (!this.hasLeft)
            addLeft(n,index);
        else if(!this.hasRight)
            addRight(n,index);
        else
            isBinary = false;
    }

    // Constructor
    public TreeNode(char c) {
        this.c = c;
        this.left = new TreeNode[26];
        this.right = new TreeNode[26];
    }
}
