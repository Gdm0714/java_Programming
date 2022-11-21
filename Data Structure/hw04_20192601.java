package hw04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Node {
    char c;
    int freq;
    Node left, right;

    public Node(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    public Node(char c, int freq, Node left, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}
class MinHeap {

    private ArrayList<Node> tree = new ArrayList<Node>(54);

    public MinHeap() {
        tree.add(null);
    }

    public void insert(Node n) {
        tree.add(n);
        int childPos = tree.size()-1;
        int parentPos = childPos/2;

        while(parentPos >= 1 && tree.get(childPos).freq < tree.get(parentPos).freq) {
            Collections.swap(tree, childPos, parentPos);
            childPos = parentPos;
            parentPos = childPos/2;
        }
    }

    public boolean isEmpty() {
        return (tree.size() <= 1);
    }

    public Node extractMinNode() {
        if(isEmpty()) return null;

        Node min = tree.get(1);
        int top = tree.size()-1;
        tree.set(1, tree.get(top));
        tree.remove(top);
        int parentPos = 1;
        int leftPos = parentPos*2;
        int rightPos = parentPos*2 + 1;

        while(leftPos <= tree.size()-1) {
            int targetPos;
            if(rightPos > tree.size()-1) {
                if(tree.get(leftPos).freq >= tree.get(parentPos).freq)
                    break;
                targetPos = leftPos;
            } else {
                if(tree.get(leftPos).freq >= tree.get(parentPos).freq && tree.get(rightPos).freq >= tree.get(parentPos).freq)
                    break;
                targetPos = (tree.get(leftPos).freq < tree.get(rightPos).freq) ? leftPos : rightPos;
            }
            Collections.swap(tree, targetPos, parentPos);
            parentPos = targetPos;
            leftPos = parentPos*2;
            rightPos = parentPos*2 + 1;
        }
        return min;
    }
    public void printTree() {
        for(Node n : tree)
            if(n != null)
                System.out.print(n.freq+" ");
        System.out.println("");
    }
}

class Huffman {
    public void encode(Node root, String text, Map<Character, String> huff) {
        if (root == null)
            return;
        if (isleaf(root))
            huff.put(root.c, text.length() > 0 ? text : "1");
        encode(root.left, text + "0", huff);
        encode(root.right, text + "1", huff);
    }

    public boolean isleaf(Node root) {
        return root.left == null && root.right == null;
    }

    public int decode(Node root, int index, StringBuilder sb) {
        if (root == null)
            return index;
        if (isleaf(root)) {
            System.out.println(root.c);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decode(root, index, sb);
        return index;
    }

    public void start(String text) {
        if (text == null || text.length() == 0)
            return;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        for (var entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            int sum = left.freq + right.freq;
            pq.add(new Node(' ', sum, left, right));
        }

        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        System.out.println("Huffman Codes are: " + huffmanCode);
        System.out.println("The original string is: " + text);
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded string is: " + sb);
        System.out.print("The decoded string is: ");

        if (isleaf(root)) {
            while (root.freq-- > 0) {
                System.out.print(root.c);
            }
        } else {
            int index = -1;
            while (index < sb.length() - 1) {
                index = decode(root, index, sb);
            }
        }
    }
}


    public class hw04_20192601 {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\고동민\\Desktop\\데이터 구조\\ds.txt"));
            StringBuilder sb = new StringBuilder();
            Huffman hf = new Huffman();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str).append("\n");
            }
            String text = sb.toString();
            hf.start(text);
        }
    }