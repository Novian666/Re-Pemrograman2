/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajar;

import java.io.*;
import java.net.*;
/**
 *
 * @author Rita Faria Candra
 */
public class ChatServer {
   public static void main(String[] x) throws Exception {
		//1. Input konfigurasi
		BufferedReader input = 
			new BufferedReader(
				new InputStreamReader(System.in));

		System.out.println("Masukkan nama : ");
		String nama = input.readLine();
		System.out.println("Halo "+nama);

		System.out.println("Masukkan port anda : ");
		Integer port = Integer.parseInt(input.readLine());

		//2. Start socket server
		ServerSocket server = new ServerSocket(port);
		System.out.println("Menunggu koneksi di port "+port);

		//3. Terima koneksi
		Socket koneksi = server.accept();
		System.out.println("terima koneksi dari alamat IP");
		System.out.println(((InetSocketAddress) koneksi.getRemoteSocketAddress()).getAddress());
		
                //4. Tampilkan data selama belum bye
		BufferedReader	chatIncoming = 
			new BufferedReader(new InputStreamReader(koneksi.getInputStream()));	
		String msg = chatIncoming.readLine();
		while (msg  != null && !"bye".equalsIgnoreCase(msg)){
			System.out.println(msg);
			msg = chatIncoming.readLine();
		}	

		//5. Tutup Koneksi
		chatIncoming.close();
		koneksi.close();
                
	} 
}
