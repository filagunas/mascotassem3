package com.filagunas.mascotas;


/**
 * Created by FERNANDOIVAN on 12/10/2016.
 */

public class Mascota {
    private String mascota;
    private String raza;
    private int foto;
    private int likes;

    public Mascota(int foto, String mascota , String raza, int likes) {
        this.foto = foto;
        this.mascota = mascota;
        this.raza = raza;
        this.likes = likes;

    }

    public int  incremetarlikes(){
        return ++this.likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRaza() {
        return raza;
    }



    public int getLike() {
        return likes;
    }

    public void setLike(int likes) {
        this.likes = likes;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

}

