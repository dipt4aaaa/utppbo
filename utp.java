package oopmodul;

public class utp {
    public static void main(String[] args) {
        Pegawai pegawaiPerpus = new Pegawai("Muhammad Fadhil Pradipta", "225150200111002");
        Perpustakaan perpus = new Perpustakaan(pegawaiPerpus);
        pegawaiPerpus.menambahBuku("Tutorial Java", "Graita", 2);
        pegawaiPerpus.menambahBuku("Tutorial Phyton", "Safir", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Bagus", 2);
        pegawaiPerpus.menambahBuku("Tutorial Golang", "Budi", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Shinta", 2);
        pegawaiPerpus.menambahPelanggan("Wildan", "1");
        pegawaiPerpus.menambahPelanggan("Machsun", "2");
        pegawaiPerpus.menambahPelanggan("Adin", "3");
        pegawaiPerpus.menambahPelanggan("Machsun", "4");
        perpus.pinjam("Wildan", "Tutorial Java");
        perpus.pinjam("Machsun", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Wildan", "Tutorial Golang");
        perpus.pinjam("Wildan", "Tutorial Javascript");
        perpus.pinjam("Wildan", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Tutorial Golang");
        perpus.pinjam("Machsun", "Sastra Inggris");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Cara cepat belajar Phyton");
        perpus.tampilkanInfoPerpustakaan();
    }
}

class Buku{
    private String judul;
    private String penulis;
    private int jumlah;

    public Buku(String judul, String penulis, int jumlah) {
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void tampilanInfoBuku(){
        System.out.print("Judul Buku ini adalah :" + judul + "\n Penulisnya adalah :" + penulis + " \n Berjumlah :" + jumlah);
    }

}

class Pegawai {
    private String nama;
    private String nomorPegawai;

    Pegawai(String nama, String nomorPegawai) {
        setNama(nama);
        setNomorPegawai(nomorPegawai);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }

    public void tampilkanInfoPegawai() {
        System.out.println("============ Data Pegawai ============");
        System.out.println("Nama            : " + getNama());
        System.out.println("Nomor Pegawai   : " + getNomorPegawai());
        System.out.println("========================================");
    }

    public void menambahPelanggan(String nama, String nomorPelanggan) {
        boolean temu = false;

        if (Perpustakaan.listPelanggan[Perpustakaan.listPelanggan.length - 1] != null)
            return;

        if (Perpustakaan.listPelanggan[0] != null) {
            for (int i = 0; i < Perpustakaan.listPelanggan.length; i++) {
                if (Perpustakaan.listPelanggan[i].getNama() == nama) {
                    temu = true;
                    break;
                }
                if (Perpustakaan.listPelanggan[i + 1] == null)
                    break;
            }
        }

        if (temu) {
            return;
        }

        for (int i = 0; i < Perpustakaan.listPelanggan.length; i++) {
            if (Perpustakaan.listPelanggan[i] == null) {
                Perpustakaan.listPelanggan[i] = new Pelanggan(nama, nomorPelanggan);
                break;
            }
        }
    }

    public void menambahBuku(String judul, String penulis, int jumlah) {
        boolean temu = false;

        if (Perpustakaan.listBuku[Perpustakaan.listBuku.length - 1] != null)
            return;

        if (Perpustakaan.listBuku[0] != null) {
            for (int i = 0; i < Perpustakaan.listBuku.length; i++) {
                if (Perpustakaan.listBuku[i].getJudul().equals(judul)) {
                    temu = true;
                }
                if (Perpustakaan.listBuku[i + 1] == null)
                    break;
            }
        }

        if (temu) {
            return;
        }

        for (int i = 0; i < Perpustakaan.listBuku.length; i++) {
            if (Perpustakaan.listBuku[i] == null) {
                Perpustakaan.listBuku[i] = new Buku(judul, penulis, jumlah);
                break;
            }
        }
    }
}

class Pelanggan {
    private String nama;
    private String nomorPelanggan;
    private Buku[] bukuPinjaman = new Buku[3];

    Pelanggan(String nama, String nomorPelanggan) {
        setNama(nama);
        setNomorPelanggan(nomorPelanggan);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("Nama                : " + getNama());
        System.out.println("Nomor Pelanggan     : " + getNomorPelanggan());
        System.out.print("Buku yang dipinjam  : ");

        if (bukuPinjaman[0] == null) {
            System.out.println("Tidak ada!");
            return;
        } else {
            for (int i = 0; i < bukuPinjaman.length; i++) {
                System.out.print(bukuPinjaman[i].getJudul());
                if (i == 2)
                    break;
                if (bukuPinjaman[i + 1] != null) {
                    System.out.print(", ");
                } else {
                    break;
                }
            }
        }
        System.out.println();

    }

    public void tambahBuku(Buku bukuPinjam) {
        if (bukuPinjaman[2] != null) {
            return;
        }

        for (int i = 0; i < bukuPinjaman.length; i++) {
            if (bukuPinjaman[i] == null) {
                bukuPinjaman[i] = bukuPinjam;
                break;
            }
        }
    }

}

class Perpustakaan {
    public static Buku[] listBuku = new Buku[100];
    public Pegawai pegawaiPerpus;
    public static Pelanggan[] listPelanggan = new Pelanggan[20];

    Perpustakaan(Pegawai pegawai) {
        pegawaiPerpus = pegawai;
    }

    public void pinjam(String namaPelanggan, String judulBuku) {
        if (cariBuku(judulBuku) == null) {
            return;
        }

        for (int i = 0; i < listPelanggan.length; i++) {
            if (listPelanggan[i].getNama().equals(namaPelanggan)) {
                listPelanggan[i].tambahBuku(cariBuku(judulBuku));
                for (int j = 0; j < listBuku.length; j++) {
                    if (listBuku[j] == cariBuku(judulBuku)) {
                        listBuku[j].setJumlah(listBuku[j].getJumlah() - 1);
                    }
                    if (listBuku[i + 1] == null)
                        break;
                }
            }
            if (listPelanggan[i + 1] == null)
                break;
        }
    }

    public Buku cariBuku(String judulBuku) {
        for (int i = 0; i < listBuku.length; i++) {
            if (listBuku[i].getJudul().equals(judulBuku)) {
                return listBuku[i];
            }
            if (listBuku[i + 1] == null)
                break;
        }
        return null;
    }

    public void tampilkanInfoPerpustakaan() {
        for (int i = 0; i < listPelanggan.length; i++) {
            listPelanggan[i].tampilkanInfoPelanggan();
            System.out.println();
            if (listPelanggan[i + 1] == null)
                break;
        }
    }

}
