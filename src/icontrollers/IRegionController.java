/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author ASUS BAE YA
 */
public interface IRegionController {
    
    public List<Region> getAll();

    public Region getById(String id);

    public List<Region> search(String key);

    public Region insert(String id, String name);

    public Region update(String id, String name);

    public void delete(String id);
}
