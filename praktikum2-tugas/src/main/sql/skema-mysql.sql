create table mahasiswa (
	id INT PRIMARY KEY AUTO_INCREMENT,
	npm VARCHAR(255) NOT NULL UNIQUE,
	nama VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	tanggal_lahir DATE NOT NULL,
	tahun_masuk INT NOT NULL
);