/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryapp;

/**
 *
 * @author shiba
 */
public class EncriptadoCaesar extends Encriptador{
    private int movimiento;

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    
    @Override
    public String encriptador() {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < super.getTexto().length(); i++) {
            char c = super.getTexto().charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    char encryptedChar = (char) ((c - 'A' + movimiento) % 26 + 'A');
                    encryptedText.append(encryptedChar);
                } else {
                    char encryptedChar = (char) ((c - 'a' + movimiento) % 26 + 'a');
                    encryptedText.append(encryptedChar);
                }
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
    
}
