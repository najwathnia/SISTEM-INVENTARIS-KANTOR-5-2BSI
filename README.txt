================================================================
           SISTEM INVENTARIS KANTOR - README
================================================================
Nama Program : InventarisKantor.java
Bahasa       : Java
Versi        : 1.0
================================================================

DESKRIPSI
---------
Program manajemen inventaris kantor berbasis console (CLI) yang
memungkinkan pengguna untuk mengelola data barang kantor secara
lengkap, mulai dari CRUD, pencarian, pengurutan, hingga statistik.


FITUR UTAMA
-----------
1. Tambah Barang         - Input data barang baru (ID, Nama, Kategori, Jumlah)
2. Tampilkan Barang      - Menampilkan semua barang yang aktif dalam bentuk tabel
3. Edit Barang           - Mengubah data barang berdasarkan ID
4. Hapus Barang          - Soft delete (data tidak hilang, status = "dihapus")
5. Restore Barang        - Mengembalikan barang yang sudah dihapus
6. Cari Barang           - Pencarian berdasarkan Nama / ID / Kategori
7. Urutkan Barang        - Sorting by ID (Bubble Sort), Nama (Selection Sort), Jumlah
8. Update Status         - Mengubah status barang menjadi "dipinjam"
9. Statistik             - Menampilkan total, aktif, dan jumlah dipinjam
10. Keluar               - Keluar dari program


CARA MENJALANKAN
----------------
Persyaratan:
  - Java JDK 14 atau lebih baru (mendukung switch expression ->)

Langkah:
  1. Simpan file sebagai: InventarisKantor.java
  2. Buka terminal / command prompt
  3. Kompilasi:
       javac InventarisKantor.java
  4. Jalankan:
       java InventarisKantor


STRUKTUR DATA
-------------
Class Barang memiliki atribut:
  - id        (int)    : Identitas unik barang
  - nama      (String) : Nama barang
  - kategori  (String) : Kategori (Elektronik, ATK, Furniture, Konsumsi)
  - jumlah    (int)    : Stok barang
  - status    (String) : "aktif" / "dipinjam" / "dihapus"
  - counter   (int)    : Jumlah berapa kali barang dipinjam

Array utama: Barang[] data dengan kapasitas maksimal 100 item.


ALGORITMA SORTING
-----------------
  - Bubble Sort      : Digunakan untuk mengurutkan berdasarkan ID
  - Selection Sort   : Digunakan untuk mengurutkan berdasarkan Nama
  - Bubble Sort Desc : Digunakan untuk mengurutkan berdasarkan Jumlah (terbanyak dulu)


CATATAN PENTING
---------------
  - Soft Delete: barang yang "dihapus" tidak benar-benar hilang dari array,
    hanya statusnya berubah menjadi "dihapus" dan tidak ditampilkan.
  - ID bersifat unik; program akan menolak jika ID sudah terdapat di sistem.
  - Data awal (30 barang) otomatis dimuat saat program pertama dijalankan.
  - Program tidak menyimpan data ke file; data akan hilang saat program ditutup.


CONTOH KATEGORI BARANG
-----------------------
  Elektronik  : Laptop, Mouse, Keyboard, Printer, AC, Proyektor, dll.
  ATK         : Spidol, Pulpen, Kertas A4, Buku, Stapler, dll.
  Furniture   : Meja, Kursi, Lemari, Rak Buku
  Konsumsi    : Galon


================================================================
