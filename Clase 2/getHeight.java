class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BinarySearchTree {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    // Método para calcular la altura del BST usando "Dividir y Vencerás"
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1; // Si el árbol está vacío, la altura es -1 (considerando la altura como la longitud del camino más largo desde la raíz hasta una hoja)
        }

        // Dividir: calcular la altura de los subárboles izquierdo y derecho
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Vencer: la altura del árbol es 1 más la altura mayor de los subárboles
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        TreeNode result = tree.searchBST(root, valueToSearch);

        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }

        // Calcular y mostrar la altura del árbol
        int height = tree.getHeight(root);
        System.out.println("Altura del árbol: " + height);
    }
}
