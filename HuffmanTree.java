import java.util.*;

public class HuffmanTree {
    static class HuffmanNode implements Comparable<HuffmanNode> {
        char data;
        int frequency;
        HuffmanNode left, right;

        public HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(HuffmanNode node) {
            int freqCompare = Integer.compare(this.frequency, node.frequency);
            if (freqCompare == 0) {
                return Character.compare(this.data, node.data);
            }
            return freqCompare;
        }
    }

    public static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isDefined(root.data)) {
            System.out.println(root.data + ": " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        String test = "create a huffman tree";
        char[] charArray = test.toCharArray();
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : charArray) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode sum = new HuffmanNode('-', x.frequency + y.frequency);
            sum.left = x;
            sum.right = y;
            pq.add(sum);
        }

        HuffmanNode root = pq.poll();
        printCodes(root, "");
    }
}
