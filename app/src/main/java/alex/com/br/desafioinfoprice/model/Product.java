package alex.com.br.desafioinfoprice.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("urlImagem")
    private String urlImagem;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("precoDe")
    private Double precoDe;
    @SerializedName("precoPor")
    private Double precoPor;

    public Product(String id, String nome, String urlImagem, String descricao, Double precoDe, Double precoPor) {
        this.id = id;
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
        this.precoDe = precoDe;
        this.precoPor = precoPor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoDe() {
        return precoDe;
    }

    public void setPrecoDe(Double precoDe) {
        this.precoDe = precoDe;
    }

    public Double getPrecoPor() {
        return precoPor;
    }

    public void setPrecoPor(Double precoPor) {
        this.precoPor = precoPor;
    }
}
