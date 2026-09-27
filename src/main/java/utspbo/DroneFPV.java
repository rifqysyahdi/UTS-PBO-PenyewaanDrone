package utspbo;

public class DroneFPV extends Drone {
    private boolean includeGoggles;

    public DroneFPV(String idDrone, String merk, String tipe, double hargaSewaPerHari, boolean includeGoggles) {
        super(idDrone, merk, tipe, hargaSewaPerHari);
        this.includeGoggles = includeGoggles;
    }

    public void setIncludeGoggles(boolean includeGoggles) {
        this.includeGoggles = includeGoggles;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("--- Detail Drone FPV ---");
        super.tampilkanDetail();
        System.out.println("Kacamata VR   : " + (includeGoggles ? "Termasuk Goggles" : "Tanpa Goggles"));
    }
}