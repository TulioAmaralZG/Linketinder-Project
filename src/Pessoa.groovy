import org.codehaus.groovy.ast.expr.GStringExpression

interface Pessoa {
    String getNome();
    void setNome(String nome);

    String getEmail();
    void setEmail(String email);

    String getRG();
    void setRG(String rg);

    String getIdade();
    void setIdade(String idade);

    String getEstado();
    void setEstado();

    String getCEP();
    void setCEP(String cep);

    String getDescricao();
    void setDescricao(String descricao);

    List<String> getCompetencias();
    void setCompetencias(List<String> competencia);

    void exibirUsuario();

}