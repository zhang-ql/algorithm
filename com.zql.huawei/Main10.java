package com.zql.huawei;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Main10 {
    public static void main(String[] args) throws ScriptException {
        Scanner scanner = new Scanner(System.in);

        int numExpressions = scanner.nextInt();
        int numReplacements = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        List<String> expressions = new ArrayList<>();
        for (int i = 0; i < numExpressions; i++) {
            expressions.add(scanner.nextLine());
        }

        Map<String, String> replacements = new HashMap<>();
        for (int i = 0; i < numReplacements; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            replacements.put(input[0], input[1]);
        }

        // Initialize the JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        for (String expression : expressions) {
            // Replace operators to match JavaScript syntax
            expression = expression.replace("=", "==")
                    .replace("AND", "&&")
                    .replace("OR", "||");

            // Create a new set of bindings for each expression
            Bindings bindings = engine.createBindings();
            for (Map.Entry<String, String> entry : replacements.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                // Attempt to parse the value as a number
                try {
                    bindings.put(key, Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    try {
                        bindings.put(key, Double.parseDouble(value));
                    } catch (NumberFormatException ex) {
                        bindings.put(key, value);
                    }
                }
            }

            // Evaluate the expression
            Object result = engine.eval(expression, bindings);

            // Output the result
            if (result instanceof Boolean) {
                System.out.println((Boolean) result ? 0 : 1);
            } else {
                System.out.println(result.toString().equals("0") ? 1 : 0);
            }
        }
    }

}
