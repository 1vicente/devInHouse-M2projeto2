package devInHouse.M2projeto2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="pacientes")
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "lista_alergia")
    private String listaAlergia;
    @Column(name = "cuidados_especificos")
    private String listaCuidadosE;
    @Column(name = "contato_emergencia")
    private String contatoEmergencia;
    @Column
    private String convenio;
    @Column(name = "numero_convenio")
    private String numeroConvenio;
    @Column(name = "validade_convenio")
    private String validadeConvenio;
    @ManyToOne
    private Endereco endereco;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getListaAlergia() {
        return listaAlergia;
    }

    public void setListaAlergia(String listaAlergia) {
        this.listaAlergia = listaAlergia;
    }

    public String getListaCuidadosE() {
        return listaCuidadosE;
    }

    public void setListaCuidadosE(String listaCuidadosE) {
        this.listaCuidadosE = listaCuidadosE;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getValidadeConvenio() {
        return validadeConvenio;
    }

    public void setValidadeConvenio(String validadeConvenio) {
        this.validadeConvenio = validadeConvenio;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
