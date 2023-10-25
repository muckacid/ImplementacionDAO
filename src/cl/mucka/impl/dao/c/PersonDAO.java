/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.mucka.impl.dao.c;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cl.mucka.impl.model.Person;
import cl.mucka.impl.dao.i.DAOPerson;

/**
 *
 * @author morag
 */
public class PersonDAO implements DAOPerson {

    private final Conexion conn;
    private final String MSG = "[PersonaDAO] ";

    public PersonDAO(String db) {
        conn = Conexion.getConnection(db);
    }

    @Override
    public void create(Person p) {
        String query = "INSERT INTO persona VALUES(null, '" + p.getName() + "', '" + p.getLastName() + "');";
        try {
            conn.ejecutar(query);
        } catch (SQLException ex) {
            System.out.println(MSG + " Metodo: CREATE");
        }
    }

    @Override
    public Person read(int id) {
        Person person = new Person();
        String query = "SELECT * FROM persons WHERE id = " + id;
        try {
            ResultSet rs = conn.ejecutar(query);
            if (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            System.out.println(MSG + " Metodo: READ");
        }
        return person;
    }

    @Override
    public void update(Person p) {
        String query = "UPDATE";
        try {
            conn.ejecutar(query);
        } catch (SQLException ex) {
            System.out.println(MSG + " Metodo: UPDATE");
        }
    }

    @Override
    public void delete(Person p) {
        String query = "DELETE FROM persons WHERE id = " + p.getId();
        try {
            conn.ejecutar(query);
        } catch (SQLException ex) {
            System.out.println(MSG + " Metodo: DELETE");
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        String query = "SELECT * FROM persons";
        try {
            ResultSet rs = conn.ejecutar(query);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLastName(rs.getString("last_name"));
                personList.add(person);
            }
        } catch (SQLException ex) {
            System.out.println(MSG + " Metodo: READ");
        }
        return personList;
    }

}
