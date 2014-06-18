package tugas.praktikum2;

import java.io.*;
import java.sql.*;
import java.text.*;

public class Main 
{
	static Integer lines;
	
    public static void main( String[] args ) throws Exception
    {
		// 0. Koneksi database memanggil file Database.java
		Database db = new Database();
		Connection conn = db.getConnection();
		
		// 1. Buat variable bertipe FileReader
		String namafile1 = "src/main/resources/mahasiswa.csv";
		FileReader fr = new FileReader(namafile1);
		
		// 2. Writer ke file tujuan
		String namafile2 = "src/main/resources/error_output.txt";
		FileWriter output = new FileWriter(namafile2);
		
		// 3. Bungkus dalam BufferedReader
		BufferedReader reader = new BufferedReader(fr);
		
		// 4. Baca data
		String data = reader.readLine(); //ignore header

		// 5. Jalankan query
		String sql = "insert into mahasiswa (id,npm,nama,email,tanggal_lahir,tahun_masuk)";
		sql += "values (?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		String sql2 = "select * from mahasiswa";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ResultSet rs = ps2.executeQuery();
		
		output.write("line,keterangan");
		output.write("\r\n");
		output.flush();
		
		try {
			String line = null;
			String[] st = null;
			Integer no=1;
			
			while((line = reader.readLine()) != null ) {
				st = line.replace("\"","").split(",");
				String[] date = st[4].split("-");
				String datee = date[2]+"-"+date[1]+"-"+date[0];
				lines = no;
				no++;
				
				Boolean validasi = isTglValid(st[4]);
				
				if(validasi) {
					if(st[0].equals("") || st[1].equals("") || st[2].equals("") || st[3].equals("") || st[4].equals("") || st[5].equals("")) {
						System.out.println(lines+", Jumlah field kurang");
						output.write(lines+",Jumlah field kurang");
						output.write("\r\n");
						output.flush();
					} 
						
					else {
						try {
							ps.setString(1, st[0]);
							ps.setString(2, st[1]);
							ps.setString(3, st[2]);
							ps.setString(4, st[3]);
							ps.setString(5, datee);
							ps.setString(6, st[5]);
							ps.executeUpdate();
						} catch(SQLException e) {
							System.out.println(lines+", Harus Unik");
							output.write(lines+",Harus Unik");
							output.write("\r\n");
							output.flush();
						} 
					}
				} else {
					System.out.println(lines+", Format tanggal salah");
					output.write(lines+",Format tanggal salah");
					output.write("\r\n");
					output.flush();
				}
			}
		} finally {
		  reader.close();
		}
    }
	
	public static boolean isTglValid(String tgl) {
		// Pola tgl(2 digit)/bulan(2 digit)/tahun(4 digit)
		String pola = "dd-MM-yyyy";
		  
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pola);
			// Tidak ada toleransi interpretasi
			sdf.setLenient(false);
			// Parsing masukan tgl berdasar pola
			java.util.Date dt = sdf.parse(tgl);
			// Jika berhasil merepresentasikan Date, berarti ok
			return true;
		} catch (ParseException ex) {
		   //System.err.println("Error: " + ex.getMessage());
		   //System.out.println(lines+", Format tanggal salah");
		} catch (IllegalArgumentException ex) {
		   //System.err.println("Tidak valid: " + ex.getMessage());
		}
		return false;
	}
}
