package org.example;

import java.util.Stack;

/**
 * Created by: Raul Ortiz for Encora
 */
public class CheckBalancedParenthesis {

    private static final String EXPRESSION = "({)}"; //aqui cambio por la de los ejemplos que me diste


    public static void main(String[] args) {
        boolean balanced = checkBalancedParenthesis(EXPRESSION);
        System.out.println("La expresión " + EXPRESSION + " está " + (balanced ? "bien" : "mal") + " balanceada");
    }

    /**
     * Verifica si los paréntesis en la expresión dada están balanceados.
     *
     * @param expression La expresión que se va a verificar puede ser dinamica.
     * @return true si la expresión está balanceada, de lo contrario, false.
     */
    static boolean checkBalancedParenthesis(String expression) {
        ParenthesisValidator validator = new ParenthesisValidator();
        return validator.isValid(expression);
    }
}

/**
 * Clase interna que contiene la lógica de validación de los paréntesis.
 */
class ParenthesisValidator {
    private final Stack<Character> characterParenthesis;

    /**
     * Constructor de la clase se creo protected para confirmar su uso segun lo hablado en la entrevista tecnica.
     */
    protected ParenthesisValidator() {
        characterParenthesis = new Stack<>();
    }

    /**
     * Verifica si los paréntesis en la expresión dada están balanceados.
     *
     * @param expression La expresión que se va a verificar.
     * @return true si la expresión está balanceada, de lo contrario, false.
     */
    protected boolean isValid(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (isOpenParenthesis(currentChar)) {
                characterParenthesis.push(currentChar);
            } else if (isCloseParenthesis(currentChar)) {
                if (characterParenthesis.isEmpty()) {
                    return false;
                }
                char lastParenthesis = characterParenthesis.pop();
                if (!isValidPair(lastParenthesis, currentChar)) {
                    return false;
                }
            }
        }

        return characterParenthesis.isEmpty();
    }

    /**
     * Verifica si un carácter es un paréntesis abierto.
     *
     * @param c El carácter/parentesis que se va a verificar.
     * @return true si el carácter es un paréntesis abierto, de lo contrario, false.
     */
    private boolean isOpenParenthesis(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    /**
     * Verifica si un carácter es un paréntesis cerrado.
     *
     * @param c El carácter que se va a verificar.
     * @return true si el carácter es un paréntesis cerrado, de lo contrario, false.
     */
    private boolean isCloseParenthesis(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    /**
     * Verifica si un par de paréntesis coincide.
     *
     * @param openParenthesis  El paréntesis de apertura.
     * @param closeParenthesis El paréntesis de cierre.
     * @return true si el par de paréntesis coincide, de lo contrario, false.
     */
    private boolean isValidPair(char openParenthesis, char closeParenthesis) {
        return (openParenthesis == '(' && closeParenthesis == ')') ||
                (openParenthesis == '[' && closeParenthesis == ']') ||
                (openParenthesis == '{' && closeParenthesis == '}');
    }
}
