package alex.com.br.desafioinfoprice.model;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("id")
    private String id;
    @SerializedName("urlImagem")
    private String urlImagem;
    @SerializedName("linkUrl")
    private String linkUrl;

    public Banner(String id, String urlImagem, String linkUrl) {
        this.id = id;
        this.urlImagem = urlImagem;
        this.linkUrl = linkUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
