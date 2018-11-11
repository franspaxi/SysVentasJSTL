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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sys_menu", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMenu.findAll", query = "SELECT s FROM SysMenu s")
    , @NamedQuery(name = "SysMenu.findByIdMenu", query = "SELECT s FROM SysMenu s WHERE s.idMenu = :idMenu")
    , @NamedQuery(name = "SysMenu.findByNombre", query = "SELECT s FROM SysMenu s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SysMenu.findByEtiqueta", query = "SELECT s FROM SysMenu s WHERE s.etiqueta = :etiqueta")
    , @NamedQuery(name = "SysMenu.findByEstado", query = "SELECT s FROM SysMenu s WHERE s.estado = :estado")
    , @NamedQuery(name = "SysMenu.findByImagen", query = "SELECT s FROM SysMenu s WHERE s.imagen = :imagen")})
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMenu", nullable = false)
    private Integer idMenu;
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
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imagen", nullable = false, length = 200)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private Collection<SysAccesos> sysAccesosCollection;
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo", nullable = false)
    @ManyToOne(optional = false)
    private SysGrupo idGrupo;

    public SysMenu() {
    }

    public SysMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public SysMenu(Integer idMenu, String nombre, String etiqueta, String estado, String imagen) {
        this.idMenu = idMenu;
        this.nombre = nombre;
        this.etiqueta = etiqueta;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<SysAccesos> getSysAccesosCollection() {
        return sysAccesosCollection;
    }

    public void setSysAccesosCollection(Collection<SysAccesos> sysAccesosCollection) {
        this.sysAccesosCollection = sysAccesosCollection;
    }

    public SysGrupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(SysGrupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMenu)) {
            return false;
        }
        SysMenu other = (SysMenu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.SysMenu[ idMenu=" + idMenu + " ]";
    }
    
}
