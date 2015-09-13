/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ismael
 */

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String datos = "Lorem ipsum";
        
        try {
            Socket socket = new Socket("localhost", 8080);
            
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Enviando datos: " + datos);
            
            salida.print(datos);
            salida.print("Enviando otros datos.\n");
            salida.print("Uno mas.\n");
            
            salida.close();
            socket.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
