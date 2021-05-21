package model;

import java.util.ArrayList;

public class Teacher {
    private String id;
    private String firstName;
    private String lastName;
    private String user;
    private String password;
    private ArrayList<Group> groups;

    /**
     * Descripción: metodo constructor de la clase:
     * @param id (String): identificador del docente
     * @param firstName (String): nombre del docente
     * @param lastName (String): apellidos del docente
     * @param user (String): usuario asignado al docente
     * @param password (String): contraseña
     */
    public Teacher(String id, String firstName, String lastName, String user, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        groups = new ArrayList<>();


    }

    /**
     * Descripción: metodo que agrega un Object Group al docente
     * @param group (Group): grupo asignado al docente
     * @return boolean:
     */
    public boolean addGroup(Group group){
        for (int i = 0; i < groups.size(); i++) {
            if (!group.getId().equals(groups.get(i).getId())){
                groups.add(group);
                return true;
            }
        }
        return false;
    }

    /**
     * Descripción: metodo que ubica la posición de un grupo dentro de la colleccion de objetos
     * @param idGroup (String): identificador del grupo a buscar
     * @return int: posicion de un grupo dentro del array
     */
    public int findGroup(String idGroup){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(idGroup)){
                return i;
            }
        }
        return -1;
    }

    /**
     * metodo de acceso
     */
    public ArrayList<Group> getGroups() {
        return groups;
    }

    /**
     * metodo de acceso
     */

    public String getId() {
        return id;
    }

     /**
     * metodo de acceso
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * metodo de acceso
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * metodo de acceso
     */
    public String getPassword() {
        return password;
    }
    /**
     * metodo de acceso
     */
    public String getUser() {
        return user;
    }
}
