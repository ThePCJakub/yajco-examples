package yajco.example.extMathExpr;

import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.model.printer.Printer;
import yajco.example.extMathExpr.parser.ExpressionParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Expression expression;
        try (InputStream in = Main.class.getResourceAsStream("/input.txt")) {
            if (in == null) throw new RuntimeException("input.txt not found");
            expression = new ExpressionParser().parse(new InputStreamReader(in));
        }

        System.out.println("Result: " + expression.eval());
        System.out.println("\nPrinter output:");
        try (PrintWriter out = new PrintWriter(System.out, true)) {
            new Printer().print(expression, out);
        }
        System.out.println();
    }
}
