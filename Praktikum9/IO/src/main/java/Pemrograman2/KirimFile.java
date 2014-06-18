/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pemrograman2;

import java.io.*;
import java.net.*;
/**
 *
 * @author Rita Faria Candra
 */
public class KirimFile {
    public static void main(String[] x) throws Exception {
		//1. File yang akan dikirim
		InputStream is =
			KirimFile.class.getResourceAsStream("/lala.jpg"); 
		//2. Buka socket
		String ipPenerima = "127.0.0.1";
		Integer portPenerima = 10000;

		Socket s = new Socket(ipPenerima,portPenerima);
		OutputStream os = s.getOutputStream();
		//3. Kirim isi file
		int data;
		while ((data = is.read()) != -1){
			os.write(data);
		}
		//4. Tutup resources
		is.close();
		os.close();
		s.close();
	}
}
