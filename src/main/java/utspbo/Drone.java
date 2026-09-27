package utspbo;

public class Drone {
    protected String idDrone;
    protected String merk;
    protected String tipe;
    protected double hargaSewaPerHari;

    public Drone(String idDrone, String merk, String tipe, double hargaSewaPerHari) {
        this.idDrone = idDrone;
        this.merk = merk;
        this.tipe = tipe;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getIdDrone() {
        return idDrone;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public void tampilkanDetail() {
        System.out.println("ID Drone      : " + idDrone);
        System.out.println("Merk          : " + merk);
        System.out.println("Tipe          : " + tipe);
        System.out.println("Harga / Hari  : Rp " + (long) hargaSewaPerHari);
    }

    public double hitungTotal(int lamaSewa) {
        return lamaSewa * hargaSewaPerHari;
    }

    public double hitungTotal(int lamaSewa, double persenDiskon) {
        double totalAwal = lamaSewa * hargaSewaPerHari;
        return totalAwal - (totalAwal * (persenDiskon / 100));
    }
}