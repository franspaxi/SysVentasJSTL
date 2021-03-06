/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "cont_subdiv_cuenta", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContSubdivCuenta.findAll", query = "SELECT c FROM ContSubdivCuenta c")
    , @NamedQuery(name = "ContSubdivCuenta.findByIdSubdivCuenta", query = "SELECT c FROM ContSubdivCuenta c WHERE c.idSubdivCuenta = :idSubdivCuenta")
    , @NamedQuery(name = "ContSubdivCuenta.findByCuenta", query = "SELECT c FROM ContSubdivCuenta c WHERE c.cuenta = :cuenta")
    , @NamedQuery(name = "ContSubdivCuenta.findByDescripcion", query = "SELECT c FROM ContSubdivCuenta c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ContSubdivCuenta.findByEstado", query = "SELECT c FROM ContSubdivCuenta c WHERE c.estado = :estado")})
public class ContSubdivCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubdivCuenta", nullable = false)
    private Integer idSubdivCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cuenta", nullable = false, length = 14)
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @JoinColumn(name = "idDivision", referencedColumnName = "idDivision", nullable = false)
    @ManyToOne(optional = false)
    private ContDivision idDivision;

    public ContSubdivCuenta() {
    }

    public ContSubdivCuenta(Integer idSubdivCuenta) {
        this.idSubdivCuenta = idSubdivCuenta;
    }

    public ContSubdivCuenta(Integer idSubdivCuenta, String cuenta, String descripcion, String estado) {
        this.idSubdivCuenta = idSubdivCuenta;
        this.cuenta = cuenta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdSubdivCuenta() {
        return idSubdivCuenta;
    }

    public void setIdSubdivCuenta(Integer idSubdivCuenta) {
        this.idSubdivCuenta = idSubdivCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ContDivision getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(ContDivision idDivision) {
        this.idDivision = idDivision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubdivCuenta != null ? idSubdivCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContSubdivCuenta)) {
            return false;
        }
        ContSubdivCuenta other = (ContSubdivCuenta) object;
        if ((this.idSubdivCuenta == null && other.idSubdivCuenta != null) || (this.idSubdivCuenta != null && !this.idSubdivCuenta.equals(other.idSubdivCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.ContSubdivCuenta[ idSubdivCuenta=" + idSubdivCuenta + " ]";
    }
    
}
