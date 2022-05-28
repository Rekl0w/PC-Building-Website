
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class SystemGroup implements Serializable{
    private Long id;
    private String gname;
    private Date created;
    private Date updated;

    public SystemGroup(Long id, String gname, Date created, Date updated) {
        this.id = id;
        this.gname = gname;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public SystemGroup() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemGroup other = (SystemGroup) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}