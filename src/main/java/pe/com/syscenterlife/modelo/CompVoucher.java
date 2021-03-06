/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "comp_voucher", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompVoucher.findAll", query = "SELECT c FROM CompVoucher c")
    , @NamedQuery(name = "CompVoucher.findByIdVoucher", query = "SELECT c FROM CompVoucher c WHERE c.idVoucher = :idVoucher")
    , @NamedQuery(name = "CompVoucher.findByIdCompra", query = "SELECT c FROM CompVoucher c WHERE c.idCompra = :idCompra")
    , @NamedQuery(name = "CompVoucher.findByLibro", query = "SELECT c FROM CompVoucher c WHERE c.libro = :libro")
    , @NamedQuery(name = "CompVoucher.findByVoucher", query = "SELECT c FROM CompVoucher c WHERE c.voucher = :voucher")
    , @NamedQuery(name = "CompVoucher.findByNivel", query = "SELECT c FROM CompVoucher c WHERE c.nivel = :nivel")
    , @NamedQuery(name = "CompVoucher.findByFecha", query = "SELECT c FROM CompVoucher c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CompVoucher.findByEstado", query = "SELECT c FROM CompVoucher c WHERE c.estado = :estado")
    , @NamedQuery(name = "CompVoucher.findByModulo", query = "SELECT c FROM CompVoucher c WHERE c.modulo = :modulo")
    , @NamedQuery(name = "CompVoucher.findByLote", query = "SELECT c FROM CompVoucher c WHERE c.lote = :lote")})
public class CompVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVoucher", nullable = false)
    private Integer idVoucher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompra", nullable = false)
    private int idCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "libro", nullable = false, length = 4)
    private String libro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "voucher", nullable = false, length = 22)
    private String voucher;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "nivel", nullable = false, length = 12)
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modulo", nullable = false, length = 20)
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lote", nullable = false, length = 30)
    private String lote;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo", nullable = false)
    @ManyToOne(optional = false)
    private GloAperturaPeriodo idAperturaPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoucher")
    private Collection<CompCompras> compComprasCollection;

    public CompVoucher() {
    }

    public CompVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public CompVoucher(Integer idVoucher, int idCompra, String libro, String voucher, String nivel, Date fecha, String estado, String modulo, String lote) {
        this.idVoucher = idVoucher;
        this.idCompra = idCompra;
        this.libro = libro;
        this.voucher = voucher;
        this.nivel = nivel;
        this.fecha = fecha;
        this.estado = estado;
        this.modulo = modulo;
        this.lote = lote;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public GloAperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(GloAperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    @XmlTransient
    public Collection<CompCompras> getCompComprasCollection() {
        return compComprasCollection;
    }

    public void setCompComprasCollection(Collection<CompCompras> compComprasCollection) {
        this.compComprasCollection = compComprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoucher != null ? idVoucher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompVoucher)) {
            return false;
        }
        CompVoucher other = (CompVoucher) object;
        if ((this.idVoucher == null && other.idVoucher != null) || (this.idVoucher != null && !this.idVoucher.equals(other.idVoucher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompVoucher[ idVoucher=" + idVoucher + " ]";
    }
    
}
