package utspbo;

public class DroneAerial extends Drone {
    private String resolusiKamera;

    public DroneAerial(String idDrone, String merk, String tipe, double hargaSewaPerHari, String resolusiKamera) {
        super(idDrone, merk, tipe, hargaSewaPerHari);
        this.resolusiKamera = resolusiKamera;
    }

    public void setResolusiKamera(String resolusiKamera) {
        this.resolusiKamera = resolusiKamera;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("--- Detail Drone Aerial ---");
        super.tampilkanDetail();
        System.out.println("Resolusi      : " + resolusiKamera);
    }
}