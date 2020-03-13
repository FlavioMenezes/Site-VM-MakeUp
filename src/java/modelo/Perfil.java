
package modelo;

import java.util.ArrayList;

/**
 *
 * @author MMAYER
 */
public class Perfil {

    private Integer id;
    private String perfil;
    private ArrayList<Menu> menu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

}
