package devInHouse.M2projeto2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MedicoDTO extends PessoaDTO{
    @NotNull
    @NotBlank
    private String crm;
    @NotNull
    @NotBlank
    private String especializacaoClinica;
    @Size(message = "Senha menor que 8 caracteres", min = 8)
    private String senha;
    private String senhaAtual;
    private String senhaNova;

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

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }
}
