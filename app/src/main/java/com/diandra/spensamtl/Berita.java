package com.diandra.spensamtl;

public class Berita {
    public String image, judul, link;

    public Berita(String image, String judul, String link) {
        this.image = image;
        this.judul = judul;
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
