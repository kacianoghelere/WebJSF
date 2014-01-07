/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmp.src.utils;

/**
 *
 * @author Kaciano
 */
public class Gerador {

    private String Code;
    private int length = 12;
    private final char[] permitidos = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
        '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
        'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] numeric = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Gerador() {
    }

    public final String generateAlphaNumCode(int comp) {
        String tmp = "";
        for (int i = 0; i < comp; i++) {
            int c = (int) Math.floor(Math.random() * this.getPermitidos().length);
            tmp += this.getPermitidos()[c];
        }
        return tmp;
    }

    public final String generateAlphaCode(int comp) {
        String tmp = "";
        for (int i = 0; i < comp; i++) {
            int c = (int) Math.floor(Math.random() * this.getAlpha().length);
            tmp += this.getAlpha()[c];
        }
        return tmp;
    }

    public final String generateNumericCode(int comp) {
        String tmp = "";
        for (int i = 0; i < comp; i++) {
            int c = (int) Math.floor(Math.random() * this.getNumeric().length);
            tmp += this.getNumeric()[c];
        }
        return tmp;
    }

    private String getCode() {
        return Code;
    }

    private void setCode(String verificationCode) {
        this.Code = verificationCode;
    }

    private int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String toString() {
        return this.getCode();
    }

    private char[] getPermitidos() {
        return permitidos;
    }

    public char[] getAlpha() {
        return alpha;
    }

    public void setAlpha(char[] alpha) {
        this.alpha = alpha;
    }

    public char[] getNumeric() {
        return numeric;
    }

    public void setNumeric(char[] numeric) {
        this.numeric = numeric;
    }
    public static void main(String[] args) {
        Gerador gg = new Gerador();
        System.out.println(gg.generateAlphaNumCode(50));
    }
}
