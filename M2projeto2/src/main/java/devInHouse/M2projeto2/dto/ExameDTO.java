package devInHouse.M2projeto2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ExameDTO {
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]{2}(/|.)[0-3][0-9](/|.)[0-9]{4}$" ,message = "Opção inválida, use a data no formato (dd/MM/yyyy) 21/12/2012 ou 21-12-2012")
    private String data;
    @NotNull
    @NotBlank
    private String tipo;
    @NotNull
    @NotBlank
    private String laboratorio;
    private String url;
    @NotNull
    @NotBlank
    private String resultado;
    @NotNull
    private Integer id_paciente;
    @NotNull
    private Integer id_medico;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }
}
