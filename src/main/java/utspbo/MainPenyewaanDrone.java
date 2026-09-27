package utspbo;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPenyewaanDrone {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Drone> listDrone = new ArrayList<>();
            
            listDrone.add(new DroneAerial("D01", "DJI", "Mini 3 Pro", 250000, "4K / 60fps"));
            listDrone.add(new DroneAerial("D02", "DJI", "Mavic 3", 500000, "5.1K"));
            listDrone.add(new DroneFPV("F01", "DJI", "Avata 2", 350000, true));
            listDrone.add(new DroneFPV("F02", "BetaFPV", "Cetus X", 200000, true));
            
            boolean berjalan = true;
            
            while (berjalan) {
                System.out.println("\n=================================");
                System.out.println("   SISTEM SEWA DRONE BANGBRO     ");
                System.out.println("=================================");
                System.out.println("1. Lihat Daftar Drone (Read)");
                System.out.println("2. Tambah Drone Baru (Create)");
                System.out.println("3. Ubah Data Drone (Update)");
                System.out.println("4. Hapus Data Drone (Delete)");
                System.out.println("5. Transaksi Sewa Drone");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu (1-6): ");
                int menu = input.nextInt();
                input.nextLine();
                
                if (menu == 1) {
                    System.out.println("\n--- DAFTAR DRONE TERSEDIA ---");
                    if (listDrone.isEmpty()) {
                        System.out.println("Belum ada data drone.");
                    } else {
                        for (int i = 0; i < listDrone.size(); i++) {
                            System.out.println("\nNo. " + (i + 1));
                            listDrone.get(i).tampilkanDetail();
                        }
                    }
                    
                } else if (menu == 2) {
                    System.out.println("\n--- TAMBAH DRONE BARU ---");
                    System.out.println("1. Drone Aerial");
                    System.out.println("2. Drone FPV");
                    System.out.print("Pilih jenis (1/2): ");
                    int jenis = input.nextInt();
                    input.nextLine();
                    
                    System.out.print("ID Drone      : ");
                    String id = input.nextLine();
                    System.out.print("Merk          : ");
                    String merk = input.nextLine();
                    System.out.print("Tipe          : ");
                    String tipe = input.nextLine();
                    System.out.print("Harga / Hari  : ");
                    double harga = input.nextDouble();
                    input.nextLine();
                    
                    if (jenis == 1) {
                        System.out.print("Resolusi Kamera : ");
                        String resolusi = input.nextLine();
                        listDrone.add(new DroneAerial(id, merk, tipe, harga, resolusi));
                        System.out.println("Drone Aerial berhasil ditambahkan!");
                    } else if (jenis == 2) {
                        System.out.print("Include Goggles? (y/n): ");
                        char gog = input.next().charAt(0);
                        boolean include = (gog == 'y' || gog == 'Y');
                        listDrone.add(new DroneFPV(id, merk, tipe, harga, include));
                        System.out.println("Drone FPV berhasil ditambahkan!");
                    } else {
                        System.out.println("Jenis tidak valid.");
                    }
                    
                } else if (menu == 3) {
                    System.out.println("\n--- UBAH DATA DRONE ---");
                    if (listDrone.isEmpty()) {
                        System.out.println("Belum ada data drone.");
                    } else {
                        for (int i = 0; i < listDrone.size(); i++) {
                            System.out.println((i + 1) + ". " + listDrone.get(i).getIdDrone() + " - " + listDrone.get(i).merk + " " + listDrone.get(i).tipe);
                        }
                        System.out.print("Pilih nomor drone yang diubah: ");
                        int idx = input.nextInt() - 1;
                        input.nextLine();
                        
                        if (idx >= 0 && idx < listDrone.size()) {
                            Drone d = listDrone.get(idx);
                            System.out.print("Merk Baru (" + d.merk + "): ");
                            String merkBaru = input.nextLine();
                            System.out.print("Tipe Baru (" + d.tipe + "): ");
                            String tipeBaru = input.nextLine();
                            System.out.print("Harga Baru (" + (long) d.hargaSewaPerHari + "): ");
                            double hargaBaru = input.nextDouble();
                            input.nextLine();
                            
                            d.setMerk(merkBaru);
                            d.setTipe(tipeBaru);
                            d.setHargaSewaPerHari(hargaBaru);
                            
                            switch (d) {
                                case DroneAerial droneAerial -> {
                                    System.out.print("Resolusi Kamera Baru: ");
                                    String resBaru = input.nextLine();
                                    droneAerial.setResolusiKamera(resBaru);
                                }
                                case DroneFPV droneFPV -> {
                                    System.out.print("Include Goggles Baru? (y/n): ");
                                    char gog = input.next().charAt(0);
                                    droneFPV.setIncludeGoggles(gog == 'y' || gog == 'Y');
                                }
                                default -> {
                                }
                            }
                            System.out.println("Data drone berhasil diperbarui!");
                        } else {
                            System.out.println("Nomor drone tidak valid.");
                        }
                    }
                    
                } else if (menu == 4) {
                    System.out.println("\n--- HAPUS DATA DRONE ---");
                    if (listDrone.isEmpty()) {
                        System.out.println("Belum ada data drone.");
                    } else {
                        for (int i = 0; i < listDrone.size(); i++) {
                            System.out.println((i + 1) + ". " + listDrone.get(i).getIdDrone() + " - " + listDrone.get(i).merk + " " + listDrone.get(i).tipe);
                        }
                        System.out.print("Pilih nomor drone yang dihapus: ");
                        int idx = input.nextInt() - 1;
                        
                        if (idx >= 0 && idx < listDrone.size()) {
                            listDrone.remove(idx);
                            System.out.println("Data drone berhasil dihapus!");
                        } else {
                            System.out.println("Nomor drone tidak valid.");
                        }
                    }
                    
                } else if (menu == 5) {
                    System.out.println("\n--- TRANSAKSI SEWA ---");
                    if (listDrone.isEmpty()) {
                        System.out.println("Drone tidak tersedia.");
                    } else {
                        for (int i = 0; i < listDrone.size(); i++) {
                            System.out.println((i + 1) + ". " + listDrone.get(i).merk + " " + listDrone.get(i).tipe + " - Rp " + (long) listDrone.get(i).hargaSewaPerHari + "/hari");
                        }
                        System.out.print("Pilih drone (1-" + listDrone.size() + "): ");
                        int pilihan = input.nextInt() - 1;
                        
                        if (pilihan >= 0 && pilihan < listDrone.size()) {
                            Drone droneDipilih = listDrone.get(pilihan);
                            System.out.println();
                            droneDipilih.tampilkanDetail();
                            
                            System.out.print("\nNama Penyewa : ");
                            input.nextLine();
                            String namaPenyewa = input.nextLine();
                            
                            System.out.print("Lama Sewa (Hari) : ");
                            int lamaSewa = input.nextInt();
                            
                            double totalBiaya;
                            double diskon = 0;
                            
                            if (lamaSewa >= 7) {
                                diskon = 20;
                                totalBiaya = droneDipilih.hitungTotal(lamaSewa, diskon);
                            } else if (lamaSewa >= 3) {
                                diskon = 10;
                                totalBiaya = droneDipilih.hitungTotal(lamaSewa, diskon);
                            } else {
                                totalBiaya = droneDipilih.hitungTotal(lamaSewa);
                            }
                            
                            System.out.println("\n---------------------------------");
                            System.out.println("        NOTA PENYEWAAN           ");
                            System.out.println("---------------------------------");
                            System.out.println("Penyewa     : " + namaPenyewa);
                            System.out.println("Unit Drone  : " + droneDipilih.merk + " " + droneDipilih.tipe);
                            System.out.println("Lama Sewa   : " + lamaSewa + " hari");
                            if (diskon > 0) {
                                System.out.println("Diskon      : " + (int) diskon + "%");
                            } else {
                                System.out.println("Diskon      : -");
                            }
                            System.out.println("Total Bayar : Rp " + (long) totalBiaya);
                            System.out.println("---------------------------------");
                            
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    
                } else if (menu == 6) {
                    berjalan = false;
                    System.out.println("Program selesai.");
                } else {
                    System.out.println("Menu tidak ada.");
                }
            }
        }
    }
}