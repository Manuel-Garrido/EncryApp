/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryapp;

import java.security.*;

/**
 *
 * @author shiba
 */
public class EncriptadoSha512 extends Encriptador {

    @Override
    public String encriptador() {
        try {
            // Obtener una instancia de MessageDigest con el algoritmo SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Actualizar el objeto MessageDigest con los bytes de la contraseña
            md.update(super.getTexto().getBytes());

            // Calcular el hash de la contraseña en forma de bytes
            byte[] bytes = md.digest();

            // Convertir los bytes del hash en una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Devolver la representación hexadecimal del hash de la contraseña
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // En caso de que no se encuentre el algoritmo SHA-512, devolver null
            return null;
        }
    }

}
