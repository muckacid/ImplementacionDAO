/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cl.mucka.impl.dao;

import java.util.List;

/**
 *
 * @author morag
 * @param <D>
 */
public interface DAO<D> {
    
    public void create(D p);
    public D read(int id);
    public void update(D p);
    public void delete(D p);
    
    public List<D> getAll();
    
}
