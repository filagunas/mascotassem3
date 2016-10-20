package com.filagunas.mascotas;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by FERNANDOIVAN on 12/10/2016.
 */

public class Mascota implements Parcelable, Comparable<Mascota>{
    private String mascota;
    private String raza;
    private int foto;
    private int likes;

    @Override
    public String toString() {
        return "Mascota{" +
                "likes=" + likes +
                ", mascota='" + mascota + '\'' +
                '}';
    }

    public Mascota(int foto, String mascota , String raza, int likes) {
        this.foto = foto;
        this.mascota = mascota;
        this.raza = raza;
        this.likes = likes;

    }

    protected Mascota(Parcel in) {
        mascota = in.readString();
        raza = in.readString();
        foto = in.readInt();
        likes = in.readInt();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mascota);
        dest.writeString(raza);
        dest.writeInt(foto);
        dest.writeInt(likes);
    }

    @Override
    public int compareTo(Mascota o) {
        int result = 0;

            if (this.likes>o.likes){

               result=-1;}
                else if (this.likes<o.likes)       {
                result=1;
        }

        return result;
            }
        }

