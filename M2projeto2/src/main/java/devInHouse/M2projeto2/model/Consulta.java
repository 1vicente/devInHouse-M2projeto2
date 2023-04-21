package devInHouse.M2projeto2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="consultas")
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String motivo;
    @Column
    private String data;
    @Column(name = "descricao_problema")
    private String descProblema;
    @Column(name = "medicacao_receitada")
    private String medicacaoReceitada;
    @Column(name = "dosagens_precaucoes")
    private String dosagensPrecaucoes;
    @ManyToOne
    private Paciente idPaciente;

    @ManyToOne
    private Medico idMedico;
    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

}
