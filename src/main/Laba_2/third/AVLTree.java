package Laba_2.third;

import java.util.*;

public class AVLTree<E extends Comparable<E>> implements ISortedSet<E> {
    private class Node {
        public E data;
        public int height;
        public Node left;
        public Node right;

        public Node(E data) {
            this.data = data;
            height = 1;
        }

        public Node(E data, Node left, Node right) {
            this(data);
            this.left = left;
            this.right = right;
            fixHeight();
        }

        int balanceFactor() {
            final int hl = left != null ? left.height : 0;
            final int hr = right != null ? right.height : 0;
            return hr - hl;
        }

        void fixHeight() {
            final int hl = left != null ? left.height : 0;
            final int hr = right != null? right.height : 0;
            height = Math.max(hl, hr) + 1;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("N{");
            sb.append("d=").append(data);
            if (left != null) {
                sb.append(", l=").append(left);
            }
            if (right != null) {
                sb.append(", r=").append(right);
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private Node root;
    private final Comparator<E> comparator;

    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty, no first element");
        }
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty, no last element");
        }
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    @Override
    public List<E> inorderTraverse() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        }
        List<E> res = new LinkedList<>();
        inorderTraverse(root, res);
        return res;
    }
    private void inorderTraverse(Node elem, List<E> lst) {
        if (elem != null) {
            inorderTraverse(elem.left, lst);
            lst.add(elem.data);
            inorderTraverse(elem.right, lst);
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node){
        if (node == null) {
            return 0;
        } else {
            return (int) Math.min((long) (1 + size(node.left)) + size(node.right), Integer.MAX_VALUE);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(E value) {
        if (value == null) {
            throw new NullPointerException("Value is null");
        }
        if (!isEmpty()) {
            Node curr = root;
            while (curr != null) {
                int cmp = compare(curr.data, value);
                if (cmp == 0) {
                    return true;
                } else if (cmp < 0) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
        }
        return false;
    }

    private boolean isAdded;
    @Override
    public boolean add(E value) {
        if (value == null) {
            throw new NullPointerException("Value is null");
        }
        isAdded = true;
        root = new Object() {
            Node insert(Node elem, E value) {
                if (elem == null) {
                    return new Node(value);
                }
                int cmp = compare(value, elem.data);
                if (cmp < 0) {
                    elem.left = insert(elem.left, value);
                } else if (cmp > 0) {
                    elem.right = insert(elem.right, value);
                } else {
                    isAdded = false;
                }
                return balance(elem);
            }
        }.insert(root, value);
        return isAdded;
    }

    private boolean isRemoved;
    @Override
    public boolean remove(E value) {
        if (value == null) {
            throw new NullPointerException("Value is null");
        }
        isRemoved = false;
        root = new Object() {
            Node delete(Node elem, E value) {
                if (elem == null) {
                    return null;
                }
                int cmp = compare(value, elem.data);
                if (cmp < 0) {
                    elem.left = delete(elem.left, value);
                } else if (cmp > 0) {
                    elem.right = delete(elem.right, value);
                } else {
                    isRemoved = true;
                    if (elem.left == null) {
                        return elem.right;
                    } else if (elem.right == null) {
                        return elem.left;
                    } else {
                        Node r = elem;
                        elem = findMin(r.right);
                        elem.right = removeMin(r.right);
                        elem.left = r.left;
                    }
                }
                return balance(elem);
            }
        }.delete(root, value);
        return isRemoved;
    }

    private Node findMin(Node elem) {
        return elem.left != null ? findMin(elem.left) : elem;
    }

    private Node findMax(Node elem) {
        return elem.right != null ? findMax(elem.right) : elem;
    }

    private Node removeMin(Node elem) {
        if (elem.left == null) {
            return elem.right;
        }
        elem.left = removeMin(elem.left);
        return balance(elem);
    }

    private int compare(E v1, E v2) {
        return comparator == null ? v1.compareTo(v2) : comparator.compare(v1, v2);
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.fixHeight();
        y.fixHeight();
        return y;
    }
    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        y.fixHeight();
        x.fixHeight();
        return x;
    }

    private Node balance(Node elem) {
        elem.fixHeight();
        if (elem.balanceFactor() > 1) {
            if (elem.right.balanceFactor() < 0) {
                elem.right = rightRotate(elem.right);
            }
            return leftRotate(elem);
        }
        if (elem.balanceFactor() < -1) {
            if (elem.left.balanceFactor() > 0) {
                elem.left = leftRotate(elem.left);
            }
            return rightRotate(elem);
        }
        return elem;
    }



    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(42);
        System.out.println(tree.size());
    }
}

