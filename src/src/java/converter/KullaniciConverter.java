
package converter;

import dao.KullaniciDAO;
import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("kullaniciConverter")
public class KullaniciConverter implements Converter{
    
    private KullaniciDAO kullaniciDAO;
   
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kullanici k = this.getKullaniciDAO().findById(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kullanici k = (Kullanici)t;
        return String.valueOf(k.getKullanici_id());
    
    }
    
    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO == null){
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    
    
}
