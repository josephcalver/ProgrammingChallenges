package _4_8_FirstCommonAncestor;

public class App {

    static class Node {

        int data;
        Node left;
        Node right;
        Node parent;

    }

    // Version #1 : Link to parents, less optimal

    public static Node commonAncestor1(Node p, Node q) {

        int delta = getDepth(p) - getDepth(q);
        Node first = delta > 0 ? p : q; // shallower node
        Node second = delta > 0 ? q : p; // deeper node
        second = moveUpBy(second, Math.abs(delta)); // move deeper node up to same level as shallower node

        // find intersection
        while ( first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private static int getDepth(Node n) {
        int depth = 0;
        while (n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
    }

    private static Node moveUpBy(Node n, int delta) {
        while (delta > 0) {
            n = n.parent;
            delta--;
        }
        return n;
    }

    // Version #2 : Link to parents, optimal

    public static Node commonAncestor2(Node root, Node p, Node q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null; // one or both nodes are not in tree
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        Node sibling = getSibling(p);
        Node parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private static boolean covers(Node root, Node n) {
        if (root == null) return false;
        if (root == n) return true; // root effectively moves down subtree with each recursive call
        return covers(root.left, n) || covers(root.right, n);
    }

    private static Node getSibling(Node n) {
        if (n == null || n.parent == null) {
            return null;
        }

        Node parent = n.parent;
        return parent.left == n ? parent.right : parent.left;
    }

    // Version #3 : No link to parents, less optimal

    public static Node commonAncestor3(Node root, Node p, Node q) {

        if (!covers(root, p) || !covers(root, q)) return null;
        return ancestorHelper(root, p, q);
    }

    private static Node ancestorHelper(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root; // we've found common ancestor or run out of nodes
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers (root.left, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        // decide whether to move recursive search left of right
        // doesn't matter if we test p or q because they're on the same side
        // (haven't yet satisfied pIsOnLeft != qIsOnLeft, see above)
        Node searchSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(searchSide, p, q);
    }

    // Version #4 : No link to parent, optimal with Result class

    static class Result {

        Node node;
        boolean isAncestor;

        public Result(Node node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    public static Node commonAncestor4(Node root, Node p, Node q) {

        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    public static Result commonAncestorHelper(Node root, Node p, Node q) {
        if (root == null) return new Result(null, false);

        if (root == p && root == q) return new Result(root, true);

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) return rx; // found common ancestor

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) return ry; // found common ancestor

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // common ancestor;
        } else if (root == p || root == q) {
            // if we're currently on either p or q and the other is in a subtree of the current node
            // set ancestor flag to true
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else { // we've found one of the nodes but the other is not in the tree
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }

    }

    public static void main(String[] args) {



    }

}
