/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "sys_grupo", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysGrupo.findAll", query = "SELECT s FROM SysGrupo s")
    , @NamedQuery(name = "SysGrupo.findByIdGrupo", query = "SELECT s FROM SysGrupo s WHERE s.idGrupo = :idGrupo")
    , @NamedQuery(name = "SysGrupo.findByNombre", query = "SELECT s FROM SysGrupo s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SysGrupo.findByEtiqueta", query = "SELECT s FROM SysGrupo s WHERE s.etiqueta = :etiqueta")
    , @NamedQuery(name = "SysGrupo.findByImagen", query = "SELECT s FROM SysGrupo s WHERE s.imagen = :imagen")})
public class SysGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrupo", nullable = false)
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "etiqueta", nullable = false, length = 3)
    private String etiqueta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imagen", nullable = false, length = 200)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<SysMenu> sysMenuCollection;

    public SysGrupo() {
    }

    public SysGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public SysGrupo(Integer idGrupo, String nombre, String etiqueta, String imagen) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.etiqueta = etiqueta;
        this.imagen = imagen;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<SysMenu> getSysMenuCollection() {
        return sysMenuCollection;
    }

    public void setSysMenuCollection(Collection<SysMenu> sysMenuCollection) {
        this.sysMenuCollection = sysMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysGrupo)) {
            return false;
        }
        SysGrupo other = (SysGrupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.SysGrupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
