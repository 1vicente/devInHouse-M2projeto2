package devInHouse.M2projeto2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Filter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

public class PessoaDTO {
    @NotBlank
    @NotNull
    private String nomeCompleto;
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[0-9]{2}(/|.)[0-3][0-9](/|.)[0-9]{4}$" ,message = "Opção inválida, use a data no formato (dd/MM/yyyy) 21/12/2012 ou 21-12-2012")
    private String dataNascimento;
    @CPF
    @NotBlank
    @NotNull
    private String cpf;
    @NotBlank
    @NotNull
    private String rg;
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[Ss]olteiro|[Cc]asado|[Ss]eparado|[Dd]ivorciado|[Vv]i[uú]vo$", message = "Opção inválida, use apenas 'solteiro, casado, divorciado ou viúvo'")
    private String estadoCivil;
    @NotBlank
    @NotNull
    private String telefone;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String naturalidade;
    @NotBlank
    @NotNull
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
}
