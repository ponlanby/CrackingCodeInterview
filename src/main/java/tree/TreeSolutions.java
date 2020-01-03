package tree;

/**
 * @author tongruochen
 * @since 2020/1/3
 */
public class TreeSolutions {

    public boolean isBalance(TreeNode root) {
        // write code here
        if (null == root) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isBalance(root.left) && isBalance(root.right);
        } else {
            return false;
        }
    }

    private int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
    }
}
