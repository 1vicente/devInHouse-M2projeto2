package devInHouse.M2projeto2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ConsultaDTO {
    @NotNull
    @NotBlank
    private String motivo;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]{2}(/|.)[0-3][0-9](/|.)[0-9]{4}$" ,message = "Opção inválida, use a data no formato (dd/MM/yyyy) 21/12/2012 ou 21-12-2012")
    private String data;
    @NotNull
    @NotBlank
    private String descProblema;
    @NotNull
    @NotBlank
    private String medicacaoReceitada;
    @NotNull
    @NotBlank
    private String dosagensPrecaucoes;
    @NotNull
    private Integer id_paciente;
    @NotNull
    private Integer id_medico;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }

    public String getMedicacaoReceitada() {
        return medicacaoReceitada;
    }

    public void setMedicacaoReceitada(String medicacaoReceitada) {
        this.medicacaoReceitada = medicacaoReceitada;
    }

    public String getDosagensPrecaucoes() {
        return dosagensPrecaucoes;
    }

    public void setDosagensPrecaucoes(String dosagensPrecaucoes) {
        this.dosagensPrecaucoes = dosagensPrecaucoes;
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
