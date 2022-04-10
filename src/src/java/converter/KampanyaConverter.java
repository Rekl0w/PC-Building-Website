
package converter;

import dao.KampanyaDAO;
import entity.Kampanya;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("kampanyaConverter")
public class KampanyaConverter implements Converter{
    
    private KampanyaDAO kampanyaDAO;

   
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kampanya k = this.getKampanyaDAO().findById(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kampanya k = (Kampanya)t;
        return String.valueOf(k.getKampanya_id());
    
    }
    
    public KampanyaDAO getKampanyaDAO() {
        if(this.kampanyaDAO == null){
            this.kampanyaDAO = new KampanyaDAO();
        }
        return kampanyaDAO;
    }

    public void setKampanyaDAO(KampanyaDAO kampanyaDAO) {
        this.kampanyaDAO = kampanyaDAO;
    }

    
    
}
