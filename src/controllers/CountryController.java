/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ICountryController;
import idaos.ICountryDAO;
import idaos.CountryDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author ASUS BAE YA
 */
public class CountryController implements ICountryController {

    private ICountryDAO icdao;

    public CountryController(Connection connection) {
        icdao = new CountryDAO(connection);

    }

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
    }

    @Override
    public Country getById(String id) {
        Country c = new Country("0", "0", 0);
        try {
            //Id kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } //Id tidak ada
            else if (!icdao.getById(id).equals(id)) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } //length name < 2
//            else if (id.length() < 2) {
//                System.out.println("Error!!");
//                System.out.println("Nama yang dimasukan melebihi 2 kata, masukan Nama yang benar");
//            } 
            else {
                c = icdao.getById(id);
            }
        } catch (NullPointerException nfe) {
            System.out.println("Error!!");
            System.out.println("Masukan ID dengan benar");
        }
        return c;
    }

    @Override
    public List<Country> search(String key) {
        List<Country> c = new ArrayList<Country>();
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
                c = icdao.search(key);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return c;
    }

    @Override
    public Country insert(String id, String name, String idr) {
        Country c = new Country(id, name, Integer.parseInt(idr));
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan melebihi 15 kata, masukan Nama yang benar");
            } //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan kurang 3 kata, masukan Nama yang benar");
            } //data sudah ada di tabel
            else if (!icdao.getById(id).equals(id)) {
                System.out.println("Error!!");
                System.out.println("ID sudah ada dalam database");
            } else {
                c = icdao.insert(c);
                System.out.println("Data berhasil di simpan");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return c;
    }

    @Override
    public Country update(String id, String name, String idr) {
        Country c = new Country(id, name, Integer.parseInt(idr));
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan melebihi 15 kata, masukan Nama yang benar");
            } //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Nama yang dimasukan kurang 3 kata, masukan Nama yang benar");
            } //data tidak ada di tabel
            else if (!icdao.getById(id).equals(id)) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } else {
                c = icdao.update(c);
                System.out.println("Data berhasil di simpan");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            npe.printStackTrace();
        }
        return c;
    }

    @Override
    public void delete(String id) {
        try {
            //id kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Inputan kosong");
            } //data tidak ada di tabel
            else if (!icdao.getById(id).equals(id)) {
                System.out.println("Error!!");
                System.out.println("ID tidak ada dalam database");
            } else {
                icdao.delete(id);
                System.out.println("Data berhasil terhapus");
            }
        } catch (Exception e) {
            System.out.println("Error!!");
            System.out.println("Masukan data dengan benar");
            e.getStackTrace();
        }
    }

}
