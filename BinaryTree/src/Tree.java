public class Tree {

    private TreeNode root;

    /* Returns an array of trees from links input. Links are assumed to
       be Strings of the form "<s> <e>" where <s> and <e> are starting
       and ending points for the link. The returned array is of size 26
       and has non-null values at indexes corresponding to roots of trees
       in output */
    public boolean buildFromLinks(String [] links) {

        // Create two arrays for nodes and forest
        TreeNode[] nodes = new TreeNode[26];
        Tree[] forest = new Tree[26];
        int forestCount = 0;

        // Process each link
        for (String link : links) {

            // Find the two ends of current link
            String[] ends = link.split("(?!^)");
            int start = (int) (ends[0].charAt(0) - 'a'); // Start node
            int end   = (int) (ends[1].charAt(0) - 'a'); // End node

            // If start of link not seen before, add it two both arrays
            if (nodes[start] == null)
            {
                nodes[start] = new TreeNode((char) (start + 'a'));

                // Note that it may be removed later when this character is
                // last character of a link. For example, let we first see
                // a--->b, then c--->a.  We first add 'a' to array of trees
                // and when we see link c--->a, we remove it from trees array.
                forest[start] = new Tree(nodes[start]);
                forestCount ++;
            }

            // If end of link is not seen before, add it to the nodes array
            if (nodes[end] == null)
                nodes[end] = new TreeNode((char) (end + 'a'));

                // If end of link is seen before, remove it from forest if
                // it exists there.
            else {
                forest[end] = null;
                forestCount --;
            }

            // Establish Parent-Child Relationship between Start and End
            nodes[start].addChild(nodes[end], end);
            if(!nodes[start].isBinary)
                return false;
        }
        if (forestCount > 1)
            return false;
        else
            return true;
    }

    // Constructor
    public Tree(TreeNode root) { this.root = root;  }

    public static void printForest(String[] links)
    {
        Tree t = new Tree(new TreeNode('\0'));
        boolean isBinary =  t.buildFromLinks(links);

        if(isBinary)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // Driver method to test
    public static void main(String[] args) {
        String [] links1 = {"ab", "bc", "bd", "ae"};
        System.out.println("------------ Forest 1 ----------------");
        printForest(links1);

        String [] links2 = {"ab", "ag", "bc", "cd", "de", "cf",
                "zy", "yx", "xw"};
        System.out.println("------------ Forest 2 ----------------");
        printForest(links2);

        String [] links3 = {"ab", "bf", "ac", "be", "cn"};
        System.out.println("------------ Forest 3 ----------------");
        printForest(links3);

        String [] links4 = {"ab", "be", "ac", "cf", "cg", "ad"};
        System.out.println("------------ Forest 4 ----------------");
        printForest(links4);
    }
}
