/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author ASUS BAE YA
 */
public interface IRegionDAO {

    public List<Region> getAll();

    public Region getById(int id);

    public List<Region> search(String key);

    public Region insert(Region r);

    public Region update(Region r);

    public void delete(int id);
}
