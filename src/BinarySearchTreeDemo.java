public class BinarySearchTreeDemo
{
    private Node root;

    public void addNode(int key)
    {
        Node newNode = new Node(key);
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            Node currentNode = root;
            Node parent;

            while(true)
            {
                parent = currentNode;
                if(key < currentNode.getKey())
                {
                    currentNode = currentNode.getLeftChild();
                    if(currentNode == null)
                    {
                        parent.setLeftChild(newNode);
                        return;
                    }
                }
                else
                {
                    currentNode = currentNode.getRightChild();
                    if(currentNode == null)
                    {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverse(Node currentNode)
    {
        if(currentNode != null)
        {
            inOrderTraverse(currentNode.getLeftChild());
            System.out.println(currentNode.getKey());
            inOrderTraverse(currentNode.getRightChild());
        }
    }

    public void preOrderTraverse(Node currentNode)
    {
        if(currentNode != null)
        {
            System.out.println(currentNode.getKey());
            preOrderTraverse(currentNode.getLeftChild());
            preOrderTraverse(currentNode.getRightChild());
        }
    }

    public void postOrderTraverse(Node currentNode)
    {
        if(currentNode != null)
        {
            postOrderTraverse(currentNode.getLeftChild());
            postOrderTraverse(currentNode.getRightChild());
            System.out.println(currentNode.getKey());
        }
    }

    public String findNode(int key)
    {
        Node currentNode = root;
        while(currentNode.getKey() != key)
        {
            if(key < currentNode.getKey())
            {
                currentNode = currentNode.getLeftChild();
            }
            else
            {
                currentNode = currentNode.getRightChild();
            }
            if(currentNode == null)
            {
                return String.format("%d not found", key);
            }
        }
        return String.format("%d was found", currentNode.getKey());
    }

    public Node getRoot()
    {
        return root;
    }

    public String removeNode(int key)
    {
        Node currentNode = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(currentNode.getKey() != key)
        {
            parent = currentNode;
            if(key < currentNode.getKey())
            {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else
            {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if(currentNode == null)
            {
                return String.format("%d not found", key);
            }
        }
        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null)
        {
            if(currentNode == root)
            {
                root = null;
            }
            else if(isLeftChild)
            {
                parent.setLeftChild(null);
            }
            else
            {
                parent.setRightChild(null);
            }
        }
        else if(currentNode.getRightChild() == null)
        {
            if(currentNode == root)
            {
                root = currentNode.getLeftChild();
            }
            else if(isLeftChild)
            {
                parent.setLeftChild(currentNode.getLeftChild());
            }
            else
            {
                parent.setRightChild(currentNode.getLeftChild());
            }
        }
        else if(currentNode.getLeftChild() == null)
        {
            if(currentNode == root)
            {
                root = currentNode.getRightChild();
            }
            else if(isLeftChild)
            {
                parent.setLeftChild(currentNode.getRightChild());
            }
            else
            {
                parent.setRightChild(currentNode.getRightChild());
            }
        }
        else
        {
            Node replacement = getReplacementNode(currentNode);
            if(currentNode == root)
            {
                root = replacement;
            }
            else if(isLeftChild)
            {
                parent.setLeftChild(replacement);
            }
            else
            {
                parent.setRightChild(replacement);
            }
            replacement.setLeftChild(currentNode.getLeftChild());
        }
        return String.format("%d was removed",key);
    }

    public Node getReplacementNode(Node replacedNode)
    {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node currentNode = replacedNode.getRightChild();
        while(currentNode != null)
        {
            replacementParent = replacement;
            replacement = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if(replacement != replacedNode.getRightChild())
        {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());
        }
        return replacement;
    }
}
