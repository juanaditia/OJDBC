/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author ASUS BAE YA
 */
public interface ICountryDAO {
    
    public List<Country> getAll();

    public Country getById(String id);

    public List<Country> search(String key);

    public Country insert(Country c);

    public Country update(Country c);

    public void delete(String id);
}
