import java.util.*;

public class HuffmanEncoder {
    private static final Map<Character, String> huffmanCodes = new HashMap<>();
    static {
        huffmanCodes.put('r', "000");
        huffmanCodes.put('t', "001");
        huffmanCodes.put('e', "01");
        huffmanCodes.put(' ', "100");
        huffmanCodes.put('u', "1010");
        huffmanCodes.put('c', "10110");
        huffmanCodes.put('h', "10111");
        huffmanCodes.put('a', "110");
        huffmanCodes.put('m', "11100");
        huffmanCodes.put('n', "11101");
        huffmanCodes.put('f', "1111");
    }

    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(huffmanCodes.get(c));
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String text = "create a huffman tree";
        String encoded = encode(text);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Output Encoded Text
        System.out.println("Encoded Text: " + encoded);
    }
}
