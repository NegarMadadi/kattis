package org.example.ProblemD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> defs = new HashMap<>();
        while (scan.hasNext()) {
            String command = scan.next();
            if (command.equals("def")) {
                // Store definition variable and integer into the map
                defs.put(scan.next(), scan.nextInt());
            } else if (command.equals("calc")) {
                StringBuilder output = new StringBuilder();
                String input = scan.next();
                String result = "";
                int total = 0;
                boolean unknown = false;
                boolean firstWord = true;
                while (!input.equals("=")) {
                    // First word in the calc command
                    if (firstWord) {
                        firstWord = false;
                        output.append(input + " ");
                        if (defs.containsKey(input)) {
                            total = defs.get(input);
                            input = scan.next();
                        } else {
                            unknown = true;
                            input = scan.next();
                        }
                    }
                    if (input.equals("+")) {
                        output.append(input + " ");
                        input = scan.next();
                        output.append(input + " ");
                        if (defs.containsKey(input)) {
                            total += defs.get(input);
                            input = scan.next();
                        } else {
                            unknown = true;
                            input = scan.next();
                        }
                    } else if (input.equals("-")) {
                        output.append(input + " ");
                        input = scan.next();
                        output.append(input + " ");
                        if (defs.containsKey(input)) {
                            total -= defs.get(input);
                            input = scan.next();
                        } else {
                            unknown = true;
                            input = scan.next();
                        }
                    }
                }
                // Check if total value has a corresponding variable in defs
                if (defs.containsValue(total)) {
                    // Search through the keys in the map
                    for (String key : defs.keySet()) {
                        if (defs.get(key) == total) {
                            result = key;
                        }
                    }
                } else {
                    unknown = true;
                }
                if (unknown) {
                    System.out.println(output + " = " + "unknown");
                } else {
                    System.out.println(output + " = " + result);
                }
            } else {
                // Clear map when command is clear
                defs.clear();
            }
        }
    }
}
