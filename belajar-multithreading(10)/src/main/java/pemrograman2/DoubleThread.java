/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pemrograman2;

/**
 *
 * @author Rita Faria Candra
 */
public class DoubleThread { 
    public static void main(String[] x) throws Exception{
		System.out.println("Baris pertama");
		System.out.println("Baris kedua");
		new Thread(new Runnable(){
			public void run(){
				System.out.println("Baris ketiga");
				System.out.println("Baris keempat");
			}
		}).start();
		System.out.println("Baris kelima");
		System.out.println("Baris keenam");
	}
}
