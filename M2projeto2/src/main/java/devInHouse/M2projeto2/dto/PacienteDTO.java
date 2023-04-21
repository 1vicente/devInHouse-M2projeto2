package devInHouse.M2projeto2.dto;

import devInHouse.M2projeto2.model.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PacienteDTO extends PessoaDTO {

    private String listaAlergia;
    private String listaCuidadosE;
    @NotBlank
    @NotNull
    private String contatoEmergencia;
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    private Integer id_endereco;

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

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }
}
