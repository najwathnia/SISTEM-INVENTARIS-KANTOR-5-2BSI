import java.util.Scanner;

class Barang {
    int id;
    String nama;
    String kategori;
    int jumlah;
    String status;
    int counter;

    Barang(int id, String nama, String kategori, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.status = "aktif";
        this.counter = 0;
    }
}

public class InventarisKantor {
    static Barang[] data = new Barang[100];
    static int size = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        initData();

        int pilihan;
        do {
            menu();
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> editBarang();
                case 4 -> hapusBarang();
                case 5 -> restoreBarang();
                case 6 -> menuSearch();
                case 7 -> menuSort();
                case 8 -> updateStatus();
                case 9 -> statistik();
                case 10 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 10);
    }

    // ================= MENU =================
    static void menu() {
        System.out.println("\n=== SISTEM INVENTARIS KANTOR ===");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Tampilkan Barang");
        System.out.println("3. Edit Barang");
        System.out.println("4. Hapus Barang (Soft Delete)");
        System.out.println("5. Restore Barang");
        System.out.println("6. Cari Barang");
        System.out.println("7. Urutkan Barang");
        System.out.println("8. Update Status");
        System.out.println("9. Statistik");
        System.out.println("10. Keluar");
        System.out.print("Pilih: ");
    }

    // ================= DATA AWAL =================
    static void initData() {
        tambahAwal(1, "Laptop", "Elektronik", 10);
        tambahAwal(2, "Mouse", "Elektronik", 25);
        tambahAwal(3, "Keyboard", "Elektronik", 20);
        tambahAwal(4, "Printer", "Elektronik", 5);
        tambahAwal(5, "Scanner", "Elektronik", 4);
        tambahAwal(6, "Meja", "Furniture", 15);
        tambahAwal(7, "Kursi", "Furniture", 30);
        tambahAwal(8, "Lemari", "Furniture", 10);
        tambahAwal(9, "AC", "Elektronik", 6);
        tambahAwal(10, "Proyektor", "Elektronik", 3);
        tambahAwal(11, "Whiteboard", "ATK", 7);
        tambahAwal(12, "Spidol", "ATK", 50);
        tambahAwal(13, "Penghapus", "ATK", 40);
        tambahAwal(14, "Buku", "ATK", 100);
        tambahAwal(15, "Pulpen", "ATK", 200);
        tambahAwal(16, "Stapler", "ATK", 20);
        tambahAwal(17, "Kertas A4", "ATK", 500);
        tambahAwal(18, "Map", "ATK", 150);
        tambahAwal(19, "Rak Buku", "Furniture", 8);
        tambahAwal(20, "Jam", "Elektronik", 12);
        tambahAwal(21, "Dispenser", "Elektronik", 5);
        tambahAwal(22, "Galon", "Konsumsi", 25);
        tambahAwal(23, "Kipas", "Elektronik", 9);
        tambahAwal(24, "Telepon", "Elektronik", 6);
        tambahAwal(25, "Router", "Elektronik", 4);
        tambahAwal(26, "Flashdisk", "Elektronik", 30);
        tambahAwal(27, "Harddisk", "Elektronik", 10);
        tambahAwal(28, "Server", "Elektronik", 2);
        tambahAwal(29, "Kabel LAN", "Elektronik", 60);
        tambahAwal(30, "Switch", "Elektronik", 3);
    }

    static void tambahAwal(int id, String nama, String kategori, int jumlah) {
        data[size++] = new Barang(id, nama, kategori, jumlah);
    }

    // ================= CRUD =================
    static void tambahBarang() {
        if (size >= data.length) {
            System.out.println("Data penuh!");
            return;
        }

        System.out.print("ID: ");
        int id = input.nextInt();

        if (cekID(id)) {
            System.out.println("ID sudah ada!");
            return;
        }

        input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Kategori: ");
        String kategori = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah = input.nextInt();

        data[size++] = new Barang(id, nama, kategori, jumlah);
        System.out.println("Barang berhasil ditambahkan!");
    }

    static boolean cekID(int id) {
        for (int i = 0; i < size; i++) {
            if (data[i].id == id) return true;
        }
        return false;
    }

    static void tampilkanBarang() {
        tampilHeader();
        for (int i = 0; i < size; i++) {
            if (!data[i].status.equals("dihapus")) {
                tampil(data[i]);
            }
        }
    }

    static void editBarang() {
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < size; i++) {
            if (data[i].id == id && !data[i].status.equals("dihapus")) {
                System.out.print("Nama baru: ");
                data[i].nama = input.nextLine();

                System.out.print("Kategori baru: ");
                data[i].kategori = input.nextLine();

                System.out.print("Jumlah baru: ");
                data[i].jumlah = input.nextInt();

                System.out.println("Berhasil diupdate!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    static void hapusBarang() {
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();

        for (int i = 0; i < size; i++) {
            if (data[i].id == id && !data[i].status.equals("dihapus")) {
                data[i].status = "dihapus";
                System.out.println("Berhasil dihapus!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    static void restoreBarang() {
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();

        for (int i = 0; i < size; i++) {
            if (data[i].id == id && data[i].status.equals("dihapus")) {
                data[i].status = "aktif";
                System.out.println("Berhasil direstore!");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    // ================= SEARCH =================
    static void menuSearch() {
        System.out.println("\n1. Nama");
        System.out.println("2. ID");
        System.out.println("3. Kategori");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1 -> cariNama();
            case 2 -> cariID();
            case 3 -> cariKategori();
        }
    }

    static void cariNama() {
        System.out.print("Nama: ");
        String nama = input.nextLine().toLowerCase();

        tampilHeader();
        for (int i = 0; i < size; i++) {
            if (data[i].nama.toLowerCase().contains(nama) && !data[i].status.equals("dihapus")) {
                tampil(data[i]);
            }
        }
    }

    static void cariKategori() {
        System.out.print("Kategori: ");
        String kategori = input.nextLine().toLowerCase();

        tampilHeader();
        for (int i = 0; i < size; i++) {
            if (data[i].kategori.toLowerCase().equals(kategori) && !data[i].status.equals("dihapus")) {
                tampil(data[i]);
            }
        }
    }

    static void cariID() {
        System.out.print("ID: ");
        int id = input.nextInt();

        for (int i = 0; i < size; i++) {
            if (data[i].id == id && !data[i].status.equals("dihapus")) {
                tampilHeader();
                tampil(data[i]);
                return;
            }
        }
        System.out.println("Tidak ditemukan!");
    }

    // ================= SORT =================
    static void menuSort() {
        System.out.println("\n1. ID (Bubble Sort)");
        System.out.println("2. Nama (Selection Sort)");
        System.out.println("3. Jumlah Desc");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1 -> bubbleSortID();
            case 2 -> selectionSortNama();
            case 3 -> sortJumlahDesc();
        }
        System.out.println("Berhasil diurutkan!");
    }

    static void bubbleSortID() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].id > data[j + 1].id) {
                    tukar(j, j + 1);
                }
            }
        }
    }

    static void selectionSortNama() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].nama.compareToIgnoreCase(data[min].nama) < 0) {
                    min = j;
                }
            }
            tukar(i, min);
        }
    }

    static void sortJumlahDesc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].jumlah < data[j + 1].jumlah) {
                    tukar(j, j + 1);
                }
            }
        }
    }

    static void tukar(int i, int j) {
        Barang temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // ================= LAINNYA =================
    static void updateStatus() {
        System.out.print("ID: ");
        int id = input.nextInt();

        for (int i = 0; i < size; i++) {
            if (data[i].id == id && !data[i].status.equals("dihapus")) {
                data[i].status = "dipinjam";
                data[i].counter++;
                System.out.println("Status diperbarui!");
                return;
            }
        }
        System.out.println("Tidak ditemukan!");
    }

    static void statistik() {
        int total = 0, aktif = 0, dipinjam = 0;

        for (int i = 0; i < size; i++) {
            if (!data[i].status.equals("dihapus")) {
                total++;
                if (data[i].status.equals("aktif")) aktif++;
                if (data[i].status.equals("dipinjam")) dipinjam++;
            }
        }

        System.out.println("\n=== STATISTIK ===");
        System.out.println("Total: " + total);
        System.out.println("Aktif: " + aktif);
        System.out.println("Dipinjam: " + dipinjam);
    }

    static void tampilHeader() {
        System.out.printf("%-5s %-15s %-15s %-10s %-12s %-10s\n",
                "ID", "Nama", "Kategori", "Jumlah", "Status", "Dipinjam");
        System.out.println("---------------------------------------------------------------------");
    }

    static void tampil(Barang b) {
        System.out.printf("%-5d %-15s %-15s %-10d %-12s %-10d\n",
                b.id, b.nama, b.kategori, b.jumlah, b.status, b.counter);
    }
}
