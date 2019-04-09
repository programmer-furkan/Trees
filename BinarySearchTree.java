public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{
    protected boolean addReturn;
    protected E deleteReturn;
    /**
     * Starter find method. Wrapper.
     */
    public E find(E target){
        return find(root, target);
    }
    /**
     * Recursive find method
     * @param localRoot
     * @param target
     * @return
     */
    private E find(Node<E> localRoot, E target){
        if(localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if(compResult == 0)
            return localRoot.data;
        else if(compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    public boolean add(E item){
        root = add(root, item);
        return addReturn;
    }
    
    private Node<E> add(Node<E> localRoot, E item){
        if(localRoot == null){
            addReturn = true;
            return new Node<E>(item);
        }
        else if(item.compareTo(localRoot.data) == 0){
            addReturn = false;
            return localRoot;
        }
        else if(item.compareTo(localRoot.data) < 0){
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    public E delete(E target){
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E target){
        if(localRoot == null){
            deleteReturn = null;
            return localRoot;
        }
        int compResult = target.compareTo(localRoot.data);
        if(compResult < 0){
            localRoot.left = delete(localRoot.left, target);
            return localRoot;
        } else if(compResult > 0){
            localRoot.right = delete(localRoot.right, target);
            return localRoot;
        } else {
            deleteReturn = localRoot.data;
            if(localRoot.left.right == null){
                localRoot.data = localRoot.left;
                localRoot.left = localRoot.left.left;
                return localRoot;
            }else{
                localRoot.data = findLargestChild(localRoot.left);
                return localRoot;
            }
        }
    }

    private E findLargestChild(Node<E> localRoot){
        if(localRoot.right.right == null){
            E returnValue = localRoot.right.data;
            localRoot.right = localRoot.right.left;
            return returnValue;
        } else {
            return findLargestChild(localRoot.right);
        }
    }
}