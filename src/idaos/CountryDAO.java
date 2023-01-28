/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author ASUS BAE YA
 */
public class CountryDAO implements ICountryDAO {

    private Connection connection;

    // DAO = Data Access Object
    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<models.Country> getAll() {
        List<Country> listcoun = new ArrayList<Country>();
        String query = "Select * FROM HR.COUNTRIES";
        try {
            PreparedStatement getAll = connection.prepareStatement(query);
            ResultSet resultSet = getAll.executeQuery();
            while (resultSet.next()) {
                Country r = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listcoun.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listcoun;
    }

    @Override
    public List<Country> search(String key) {
        List<Country> listcoun = new ArrayList<Country>();
        String query = "Select * FROM HR.COUNTRIES WHERE COUNTRY_NAME LIKE ? ";// LIKE '% ? %'
        try {
            PreparedStatement search = connection.prepareStatement(query);
            search.setString(1, "%" + key + "%");
            ResultSet resultSet = search.executeQuery();
            while (resultSet.next()) {
                Country r = new Country();
                r.setId(resultSet.getString(1));
                r.setName(resultSet.getString(2));
                r.setIdr(resultSet.getInt(3));
                listcoun.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return listcoun;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM HR.COUNTRIES WHERE COUNTRY_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error");
//            System.out.println("See the details below");

        }
    }

    @Override
    public Country getById(String id) {
        Country c = new Country();
        String query = "SELECT * FROM HR.COUNTRIES WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                c.setId(resultSet.getString(1));
                c.setName(resultSet.getString(2));
                c.setIdr(resultSet.getInt(3)); 
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
       return c;
    }

    @Override
    public Country update(Country c) {
        String query = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getIdr());
            ps.setString(3, c.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return c;
    }

    @Override
    public Country insert(Country c) {
//        Country c = countries;
        String query = "INSERT INTO HR.COUNTRIES(COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getId());
            ps.setString(2, c.getName());
            ps.setInt(3, c.getIdr());
//            System.out.println(preparedStatement);
            ps.executeQuery();
//            System.out.println("t");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("f");
            return null;
        }
        return c;
    }

}
