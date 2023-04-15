/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduardo.pycemjar;

/**
 *
 * @author Cris
 */
public class TesteLogin {
    public static void main(String[] args) {
        Database banco = new Database();
        banco.realizarSelect("leonardo@gmail.com", "M@12345678");
    }
}
