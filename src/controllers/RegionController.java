/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IRegionController;
import idaos.IRegionDAO;
import idaos.RegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS BAE YA
 */
public class RegionController implements IRegionController {

    private IRegionDAO irdao;

    public RegionController(Connection connection) {
        irdao = new RegionDAO(connection);

    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
        Region r = new Region(0, "0");
        try {
            //Id kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            }  //Id tidak ada
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } else {
                r = irdao.getById(Integer.parseInt(id));
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!");
            System.out.println("Masukan ID dengan benar");
        }
        return r;

    }

    @Override
    public List<Region> search(String key) {
        List<Region> r = new ArrayList<Region>();
        try {
            //name kosong
            if (key.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } //length name > 15
            else if (key.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan melebihi 15 kata, masukan Nama yang benar");
            } else {
                r = irdao.search(key);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return r;
    }

//    @Override
//    public String insert(String id, String name) {
//        String result = "";
//        Region coba = new Region(Integer.parseInt(id), name);
//        System.out.println(coba.getId());
//        System.out.println(coba.getName());
//
//        if (name.isEmpty()) {
//            result = "Data berhasil disimpan";
//            irdao.insert(coba);
//        } else {
//            result = "Maaf data gagal disimpan";
//        }
//        return result;
//    }
    @Override
    public Region insert(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } 
               //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan melebihi 15 kata, masukan Nama yang benar");
            } 
              //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan kurang 3 kata, masukan Nama yang benar");
            } 
            //data sudah ada di tabel
            else if (Integer.parseInt(id) == irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID sudah ada dalam database");
            }else {
                r = irdao.insert(r);
                System.out.println("Data berhasil di simpan");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return r;
    }

//    @Override
//    public String update(String id, String name) {
//        String result = "";
//        Region coba = new Region(Integer.parseInt(id), name);
//        System.out.println(coba.getId());
//        System.out.println(coba.getName());
//
//        try {
//            result = "Data berhasil di update";
//            irdao.update(coba);
//        } catch (Exception e) {
//            e.getStackTrace();
//            result = "Maaf data gagal di ";
//        }
//        return result;
//    }
    @Override
    public Region update(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } 
              //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan melebihi 15 kata, masukan Nama yang benar");
            } 
              //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan kurang 3 kata, masukan Nama yang benar");
            } 
            //data tidak ada di tabel
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } else {
                r = irdao.update(r);
                System.out.println("Data berhasil di update");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return r;
    }

    @Override
    public void delete(String id) {
        try {
            //id kosong
            if (id.isEmpty()){
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } 
            //data tidak ada di tabel
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } else {
                irdao.delete(Integer.parseInt(id));
                System.out.println("Data berhasil terhapus");
            }
        } catch (Exception e){
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            e.getStackTrace();
        }
    }

}
