package devInHouse.M2projeto2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name ="medicos")
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String crm;
    @Column(name = "especializacao_clinica")
    private String especializacaoClinica;
    @Column(length = 32)
    @Size(min = 8, max = 32)
    private String senha;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacaoClinica() {
        return especializacaoClinica;
    }

    public void setEspecializacaoClinica(String especializacaoClinica) {
        this.especializacaoClinica = especializacaoClinica;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
