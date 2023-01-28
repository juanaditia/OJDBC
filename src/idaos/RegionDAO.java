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
import models.Region;

/**
 *
 * @author ASUS BAE YA
 */
public class RegionDAO implements IRegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;

    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return listRegion;
    }

    @Override
    public Region getById(int id) {
        Region r = new Region();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return r;

    }

    @Override
    public List<Region> search(String key) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_NAME LIKE ? ";// LIKE '% ? %'
        try {
            PreparedStatement search = connection.prepareStatement(query);
            search.setString(1, "%" + key + "%");

            ResultSet resultSet = search.executeQuery();
            while (resultSet.next()) {
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return listRegion;
    }

    @Override
    public Region insert(Region r) {
        //boolean result = false;
        String query = "INSERT INTO HR.REGIONS(REGION_ID, REGION_NAME) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, r.getId());
            ps.setString(2, r.getName());
            ps.executeQuery();

            //result = true ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

    @Override
    public Region update(Region r) {
        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setInt(2, r.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("error!!!");/
        return null;
        }
        return r;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error");
//            System.out.println("See the details below");

        }

    }

}
