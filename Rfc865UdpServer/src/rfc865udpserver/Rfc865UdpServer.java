/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfc865udpserver;

import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author mohit009
 */
public class Rfc865UdpServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String quote="TESTSSSS";
        
        DatagramSocket socket=null;
        
        try{
            socket=new DatagramSocket(17);
        }catch(SocketException e){
            e.printStackTrace();
        }
        
        while(true){
            try{
                DatagramPacket request=new DatagramPacket(new byte[512], 512);
                socket.receive(request);
                
                String s=new String(request.getData());
                System.out.println("RECEIVED : "+s);
                InetAddress clientAddress=request.getAddress();
                int clientPort=request.getPort();
                
                DatagramPacket reply=new DatagramPacket(quote.getBytes(), quote.getBytes().length, clientAddress, clientPort);
                socket.send(reply);
                
                
            }catch(IOException e){
                e.printStackTrace();
            }
            
            
        }
    }
    
}
