# UTS PBO - Sistem Penyewaan Drone BANGBRO

## Identitas Mahasiswa
* **Nama** : Mohammed Rifqy Syahdi
* **NIM** : 2509116037
* **Kelas** : Sistem Informasi A'25
* **Mata Kuliah** : Pemrograman Berbasis Objek (PBO)


## Deskripsi Proyek
**Sistem Penyewaan Drone BANGBRO** adalah aplikasi berbasis CLI (*Command Line Interface*) yang dirancang untuk mengelola operasional persewaan drone. Aplikasi ini mempermudah admin atau kasir dalam mengelola katalog unit drone (tambah, lihat, ubah, hapus) serta melakukan proses kalkulasi transaksi penyewaan secara otomatis berdasarkan durasi sewa dan diskon yang berlaku.

Program ini dibangun menggunakan bahasa pemrograman **Java** dengan menerapkan prinsip-prinsip dasar **Object-Oriented Programming (OOP)** serta elemen wajib perkuliahan:
* **Encapsulation**: Mengamankan atribut data drone menggunakan access modifier `private` dan menyediakan metode `getter`/`setter`.
* **Inheritance**: Superclass `Drone` diturunkan ke 2 tipe subclass spesifik, yaitu `DroneAerial` dan `DroneFPV`.
* **Polymorphism**:
  * *Method Overriding*: Metode cetak informasi/detail drone disesuaikan pada masing-masing subclass (`DroneAerial` dan `DroneFPV`).
  * *Method Overloading*: Perhitungan atau pencetakan transaksi disesuaikan dengan parameter input durasi/diskon.
* **Condition (If-Else)**: Digunakan untuk penentuan persentase diskon berdasarkan lama hari sewa serta validasi pilihan menu/jenis drone.
* **Looping**: Menerapkan perulangan `do-while`/`while` untuk navigasi menu CLI agar program terus berjalan hingga pengguna memilih menu keluar.
* **Data Management**: Memanfaatkan struktur data dinamis `ArrayList` untuk manajemen operasi CRUD data drone.


## Alur Program dan Petunjuk Eksekusi

### 1. Struktur Class
Program terdiri dari 4 kelas utama dalam package `utspbo`:
* `Drone` (Superclass): Menyimpan atribut dasar drone (ID, Merk, Tipe, Harga/Hari) dan metode perhitungan biaya sewa.
* `DroneAerial` (Subclass): Turunan dari `Drone` dengan atribut tambahan `resolusiKamera`.
* `DroneFPV` (Subclass): Turunan dari `Drone` dengan atribut tambahan `includeGoggles`.
* `MainPenyewaanDrone` / `Utspbo` (Main Class): Memuat logika utama, menu interaktif, koleksi data (`ArrayList`), dan kontrol transaksi.

### 2. Cara Kerja Sistem (Alur Operasional)
1. **Inisialisasi Data:** Saat program pertama kali dijalankan, sistem secara otomatis memasukkan 4 data *default* drone (2 Drone Aerial & 2 Drone FPV) ke dalam daftar.
2. **Menu Utama:** Pengguna disajikan 6 pilihan menu utama:
   * **Menu 1 (Read):** Menampilkan seluruh unit drone yang tersimpan beserta spesifikasi khususnya.
   * **Menu 2 (Create):** Menambahkan unit drone baru ke dalam sistem dengan memilih tipe (Aerial / FPV).
   * **Menu 3 (Update):** Mengubah informasi drone (Merk, Tipe, Harga, Spesifikasi khusus) berdasarkan indeks pilihan.
   * **Menu 4 (Delete):** Menghapus unit drone dari daftar berdasarkan indeks pilihan.
   * **Menu 5 (Transaksi Sewa):** Melakukan proses sewa unit drone.
     * Pengguna memilih unit drone yang tersedia.
     * Menginput nama penyewa dan lama durasi sewa (hari).
     * Sistem secara otomatis menghitung diskon:
       * Sewa **>= 7 hari**: Diskon 20%
       * Sewa **>= 3 hari**: Diskon 10%
       * Sewa **< 3 hari**: Tanpa diskon
     * Sistem mencetak **Nota Penyewaan** rinci.
   * **Menu 6 (Keluar):** Menghentikan dan menutup perulangan aplikasi.


## Penjelasan Hasil Output (Screenshot)

### 1. Tampilan Menu Utama
![Menu Utama]()
* **Penjelasan:** Tampilan awal program saat dijalankan. Memuat header program "SISTEM SEWA DRONE BANGBRO" dan menyajikan 6 pilihan menu utama yang dapat dipilih oleh pengguna dengan memasukkan angka 1 sampai 6.


### 2. Tampilan Menu 1 - Lihat Daftar Drone (Read)
![Lihat Daftar Drone]()
* **Penjelasan:** Output saat pengguna memilih **Menu 1**. Sistem menampilkan seluruh koleksi data drone yang ada di dalam `ArrayList`. Terlihat penerapan *Polymorphism (Overriding)* di mana tipe `DroneAerial` menampilkan atribut khusus `Resolusi`, sedangkan `DroneFPV` menampilkan atribut khusus `Kacamata VR`.


### 3. Tampilan Menu 2 - Tambah Drone Baru (Create)
![Tambah Drone]()
* **Penjelasan:** Output saat pengguna memilih **Menu 2**. Sistem meminta input jenis drone (1. Aerial / 2. FPV). Pada contoh ini, pengguna memilih opsi `2` (Drone FPV) lalu mengisi data ID (`F03`), Merk (`ZX-300`), Tipe (`MARK-15`), Harga/Hari (`1000000000`), serta status goggles (`y`). Setelah diisi, pesan konfirmasi "Drone FPV berhasil ditambahkan!" muncul.


### 4. Tampilan Menu 3 - Ubah Data Drone (Update)
![Ubah Data Drone]()
* **Penjelasan:** Output saat pengguna memilih **Menu 3**. Sistem terlebih dahulu menampilkan daftar drone beserta nomor urutnya. Pengguna memilih nomor `5` (yaitu data F03 yang baru ditambahkan) untuk diperbarui datanya menjadi Merk (`CBR-150`), Tipe (`MARK-50`), Harga Baru, dan status goggles baru. Pesan konfirmasi "Data drone berhasil diperbarui!" menandakan perubahan berhasil disimpan ke `ArrayList`.


### 5. Tampilan Menu 4 - Hapus Data Drone (Delete)
![Hapus Data Drone]()
* **Penjelasan:** Output saat pengguna memilih **Menu 4**. Sistem menampilkan daftar ringkas drone. Pengguna memilih nomor `5` untuk dihapus dari sistem. Setelah dipilih, sistem menghapus objek dari `ArrayList` dan menampilkan notifikasi "Data drone berhasil dihapus!".


### 6. Tampilan Menu 5 - Transaksi Sewa Drone
![Transaksi Sewa Drone]()
* **Penjelasan:** Output saat pengguna memilih **Menu 5**. 
  * Pengguna memilih unit drone nomor `4` (BetaFPV Cetus X - Rp 200.000/hari).
  * Pengguna menginputkan Nama Penyewa (`Yusuf`) dan Lama Sewa (`7` hari).
  * Sistem memproses logika percabangan `if-else`. Karena lama sewa >= 7 hari, penyewa mendapatkan **Diskon 20%**.
  * **Kalkulasi Biaya:** 
    * Total Normal = 7 hari × Rp 200.000 = Rp 1.400.000
    * Potongan Diskon (20%) = Rp 280.000
    * Total Bayar = Rp 1.120.000
  * Sistem mencetak rincian pada **NOTA PENYEWAAN**.


### 7. Tampilan Menu 6 - Keluar dari Program
![Keluar Program]()
* **Penjelasan:** Output saat pengguna memilih **Menu 6**. Sistem menghentikan loop perulangan utama, menampilkan pesan "Program selesai.", dan menyelesaikan eksekusi program Java (`BUILD SUCCESS`).

