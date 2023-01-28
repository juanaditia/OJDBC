/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import idaos.CountryDAO;
import idaos.IRegionDAO;
import idaos.RegionDAO;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;

/**
 *
 * @author ASUS BAE YA
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection connection = new DBConnection();
//        System.out.println(connection);

        RegionController rdao = new RegionController(connection.getConnection());
        CountryController crd = new CountryController(connection.getConnection());

        Scanner scrInt = new Scanner(System.in);
        Scanner scrStr = new Scanner(System.in);

        int x = 0;
        do {
            System.out.println("=== SELAMAT DATANG ===\n"
                    + "Menu\n"
                    + "========================\n"
                    + "1. Melihat semua data region\n"
                    + "2. Tambah data region\n"
                    + "3. Update data region\n"
                    + "4. Search data region\n"
                    + "5. Search ID region\n"
                    + "6. Hapus data region\n"
                    + "========================\n"
                    + "7. Melihat semua data country\n"
                    + "8. Tambah data country\n"
                    + "9. Update data country\n"
                    + "10. Search data country\n"
                    + "11. Search ID country\n"
                    + "12. Hapus data country\n"
                    + "13. Keluar \n"
                    + "========================\n");
            System.out.print("Pilihan : ");
            x = scrInt.nextInt();

            switch (x) {
                case 1:
                    List<Region> regs = rdao.getAll();
                    for (Region reg : regs) {
                        reg.display();
                    }
                    break;
                case 2:
                    System.out.print("Masukan Id Region : ");
                    String id = scrStr.nextLine();
                    System.out.print("Masukan Nama Region : ");
                    String name = scrStr.nextLine();

                    rdao.insert(id, name);
                    break;
                case 3:
                    System.out.print("Masukan Id Region : ");
                    String idu = scrStr.nextLine();
                    System.out.print("Masukan Nama Region : ");
                    String nameu = scrStr.nextLine();

                    rdao.update(idu, nameu);
                    break;
                case 4:
                    System.out.print("Nama regon yang di cari : ");
                    String src = scrStr.nextLine();

                    List<Region> sc = rdao.search(src);
                    for (Region reg : sc) {
                        reg.display();
                    }
                    break;
                case 5:
                    System.out.print("ID regon yang di cari : ");
                    String getid = scrStr.nextLine();

                    Region rid = rdao.getById(getid);
                    rid.display();
                    break;
                case 6:
                    System.out.print("ID region yang akan di hapus : ");
                    String delid = scrStr.nextLine();

                    rdao.delete(delid);

                    break;
                case 7:
                    List<Country> cegs = crd.getAll();
                    for (Country reg : cegs) {
                        reg.display();
                    }
                    break;
                case 8:
                    System.out.print("Masukan Id Country : ");
                    String idc = scrStr.nextLine();
                    
                    System.out.print("Masukan Nama Ctounry : ");
                    String namec = scrStr.nextLine();

                    System.out.print("Masukan Region Id : ");
                    String idcr = scrStr.nextLine();

                    crd.insert(idc, namec, idcr);
                    break;
                case 9:
                    System.out.print("Masukan Id Country : ");
                    String idcu = scrStr.nextLine();
                    System.out.print("Masukan Nama Ctounry : ");
                    String namecu = scrStr.nextLine();

                    System.out.print("Masukan Region Id : ");
                    String idcru = scrStr.nextLine();

                    crd.update(idcu, namecu, idcru);
                    break;
                case 10:
                    System.out.print("Nama country yang di cari : ");
                    String srcc = scrStr.nextLine();

                    List<Country> scc = crd.search(srcc);
                    for (Country reg : scc) {
                        reg.display();
                    }
                    break;
                case 11:
                    System.out.print("ID counrty yang di cari : ");
                    String getidc = scrStr.nextLine();

                    Country cid = crd.getById(getidc);
                    cid.display();
//                    
                    break;
                case 12:
                    System.out.print("ID country yang akan di hapus : ");
                    String delId = scrStr.nextLine();

                    crd.delete(delId);
                    break;

            }
            System.out.println(" ");
        } while (x < 13);
    }

}
