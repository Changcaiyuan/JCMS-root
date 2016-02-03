/****
Copyright (c) 2015 The Jackson Laboratory

This is free software: you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by  
the Free Software Foundation, either version 3 of the License, or  
(at your option) any later version.
 
This software is distributed in the hope that it will be useful,  
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this software.  If not, see <http://www.gnu.org/licenses/>.
****/

package jcms.integrationtier.cv;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import jcms.integrationtier.base.ITBaseEntity;
import jcms.integrationtier.base.ITBaseEntityInterface;

/**
 * <b>File name:</b>  CvMouseProtocolEntity.java  <p>
 * <b>Date developed:</b>  August 2010 <p>
 * <b>Purpose:</b>  Contains all mouse protocol information  <p>
 * <b>Inputs:</b>  None   <p>
 * <b>Outputs:</b>  Named queries can be invoked from a local or remote session
 *                  beans.  EJB query language provides support
 *                  for setting query parameters as indicated by
 *                  colon and parameter syntax, :ParameterName.  <p>
 * <b>Last changed by:</b>   $Author$ <p>
 * <b>Last changed date:</b> $Date$   <p>
 * @author Kavitha Rama
 * @version $Revision$
 */
@Entity
@Table(name = "cv_MouseProtocol", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(
        name = "CvMouseProtocolEntity.findAll",
        query = "SELECT c FROM CvMouseProtocolEntity c " +
                "ORDER BY c.id"),

    @NamedQuery(
        name = "CvMouseProtocolEntity.findAllByOwner",
        query = "SELECT DISTINCT c FROM CvMouseProtocolEntity c, MouseEntity m " +
                "WHERE m.protocol = c.id AND m.owner = :fOwner " +
                "ORDER BY c.id"),

    @NamedQuery(
        name = "CvMouseProtocolEntity.findAllByOwners",
        query = "SELECT c FROM CvMouseProtocolEntity c " +
                "WHERE EXISTS( " +
                "SELECT 1 FROM MouseEntity m WHERE " +
                "m.protocol = c.id AND m .owner IN (:lOwner)) " +
                "ORDER BY c.id "),

    @NamedQuery(
        name = "CvMouseProtocolEntity.findBykey",
        query = "SELECT c FROM CvMouseProtocolEntity c WHERE c.mouseProtocolkey = :key"),

    @NamedQuery(name = "CvMouseProtocolEntity.findByMouseProtocolkey", query = "SELECT c FROM CvMouseProtocolEntity c WHERE c.mouseProtocolkey = :mouseProtocolkey"),
    @NamedQuery(name = "CvMouseProtocolEntity.findById", query = "SELECT c FROM CvMouseProtocolEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CvMouseProtocolEntity.findByDescription", query = "SELECT c FROM CvMouseProtocolEntity c WHERE c.description = :description"),
    @NamedQuery(name = "CvMouseProtocolEntity.findByVersion", query = "SELECT c FROM CvMouseProtocolEntity c WHERE c.version = :version")})

public class CvMouseProtocolEntity extends ITBaseEntity implements Serializable, ITBaseEntityInterface {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "_mouseProtocol_key", nullable = false)
    private Integer mouseProtocolkey;

    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "description", length = 255)
    private String description;
    
    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;

    public CvMouseProtocolEntity() {
    }

    public CvMouseProtocolEntity(Integer mouseProtocolkey) {
        this.mouseProtocolkey = mouseProtocolkey;
    }

    public CvMouseProtocolEntity(Integer mouseProtocolkey, String id, int version) {
        this.mouseProtocolkey = mouseProtocolkey;
        this.id = id;
        this.version = version;
    }

    public Integer getMouseProtocolkey() {
        return mouseProtocolkey;
    }

    public void setMouseProtocolkey(Integer mouseProtocolkey) {
        this.mouseProtocolkey = mouseProtocolkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mouseProtocolkey != null ? mouseProtocolkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvMouseProtocolEntity)) {
            return false;
        }
        CvMouseProtocolEntity other = (CvMouseProtocolEntity) object;
        if ((this.mouseProtocolkey == null && other.mouseProtocolkey != null) || (this.mouseProtocolkey != null && !this.mouseProtocolkey.equals(other.mouseProtocolkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcms.integrationtier.cv.CvMouseProtocolEntity[mouseProtocolkey=" + mouseProtocolkey + "]";
    }

    @Override
    public Integer getKey() {
        return mouseProtocolkey;
    }

    @Override
    public ITBaseEntityInterface getEntity() {
        return this ;
    }

    @Override
    public void printDetail()
    {
        System.out.println("\n");
        System.out.println(this.getClass().getSimpleName() + " Contents");
        System.out.println("================================");
        System.out.println("\tPK" + "\t" + this.getMouseProtocolkey() );
        System.out.println("\tKey" + "\t" + this.getKey() );
        System.out.println("\tPen ID" + "\t" + this.getId() );
        System.out.println("\tVersion" + "\t" + this.getVersion() );

    }
}