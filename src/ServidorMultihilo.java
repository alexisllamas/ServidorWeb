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

public class ServidorMultihilo implements Runnable {
    
    Socket socket;
    static int puerto = 8080;

    public ServidorMultihilo(Socket socket) {
        this.socket = socket;
    }
    
    public static void main(String[] args) throws Exception {
        ServerSocket socketServidor = new ServerSocket(puerto);
        System.out.println("Escuchando por el puerto " + puerto);
        
        
        /*
        
        El servidor escucha todo el tiempo por el puerto indicado.
        Cuando se genera una conexión, el servidor crea un hilo de ejecución
        para responder a la petición.
        
        */
        while(true) {
            Socket socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado.");
            
            new Thread(new ServidorMultihilo(socketCliente)).start();
        }
        
    }
    
    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println("Cadena recibida: ");
            
            
            
            entrada.close();
            socket.close();
        }        
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}
