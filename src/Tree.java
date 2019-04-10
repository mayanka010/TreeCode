public class Tree {
    protected static class Node {
        protected int data;
        protected Node leftChild;
        protected Node rightChild;

        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    protected Node root;

    public Tree()
    {
        this.root = null;
    }

    protected Tree(Node root)
    {
        this.root = root;
    }

    public Tree(int data, Tree leftTree, Tree rightTree)
    {
        this.root = new Node(data);
        if(leftTree!=null)
        {
            this.root.leftChild = leftTree.root;
        }
        else
        {
            this.root.leftChild = null;
        }
        if(rightTree!=null)
        {
            this.root.rightChild = rightTree.root;
        }
        else
        {
            this.root.rightChild = null;
        }
    }

    public Tree getLeftSubTree()
    {
        if(root !=null && root.leftChild !=null)
        {
            return new Tree(root.leftChild);
        }
        else
        {
            return null;
        }
    }

    public Tree getRightSubTree()
    {
        if(root !=null && root.rightChild !=null)
        {
            return new Tree(root.rightChild);
        }
        else
        {
            return null;
        }
    }

    public boolean isLeaf()
    {
        return (root.leftChild == null && root.rightChild == null);
    }

    public boolean isLeaf(Node node)
    {
        return (node.leftChild == null && node.rightChild == null);
    }

    private boolean isNullTree()
    {
        boolean response= false;
        if(this.root == null)
        {
            response = true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        toString(root,1,sb);
        return sb.toString();
    }

    private void toString(Node node, int depth, StringBuilder stringBuilder)
    {
        for(int i =1; i < depth;i++)
        {
            stringBuilder.append(" - - ");
        }
        if(node == null)
        {
            stringBuilder.append("null\n");
        }
        else
        {
            stringBuilder.append(node.toString());
            stringBuilder.append("\n");
            toString(node.leftChild, depth+1,stringBuilder);
            toString(node.rightChild,depth+1,stringBuilder);
        }
    }
}
