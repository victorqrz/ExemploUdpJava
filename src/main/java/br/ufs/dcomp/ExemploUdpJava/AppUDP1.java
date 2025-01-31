package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            String msg = "Olá, amigo";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getByName("3.235.180.153");
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
            
            byte[] buf = new byte[20];
            DatagramPacket packReceive = new DatagramPacket(buf, buf.length);
            
            System.out.println("\n[AGUARDANDO DATAGRAMA UDP]\n");
            
            socket.receive(packReceive);
            
            byte[] received_data = packReceive.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = packReceive.getAddress();
            int origin_port = packReceive.getPort();
            
            System.out.println("  Mensagem recebida:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}