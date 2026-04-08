import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> map = new TreeMap<>();
        String line;
        int total = 0;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) continue; 
            map.put(line, map.getOrDefault(line, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String tree = entry.getKey();
            int count = entry.getValue();
            double percent = (count * 100.0) / total;

            sb.append(tree)
              .append(" ")
              .append(String.format("%.4f", percent))
              .append("\n");
        }

        System.out.print(sb);
    }
}