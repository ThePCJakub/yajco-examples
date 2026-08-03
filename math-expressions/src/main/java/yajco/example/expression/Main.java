package yajco.example.expression;

import yajco.example.expression.model.Expression;
import yajco.example.expression.parser.ExpressionParser;
import yajco.example.expression.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        String input = "(1+6/2)*30";
        try {
            Expression expression = new ExpressionParser().parse(input);
            System.out.println("Result for '" + input + "' is: " + expression.eval());
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }
}
