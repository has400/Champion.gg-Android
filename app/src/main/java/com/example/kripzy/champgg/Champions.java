package com.example.kripzy.champgg;

import java.security.PublicKey;

/**
 * Created by Kripzy on 14-May-16.
 */
public class Champions {
    private String Champion;
    private int Champimg;


    public Champions(String Champion, int Champimg) {

        this.Champimg=Champimg;
        this.Champion=Champion;}

        public String getChampion() {
            return Champion;
        }

        public int getChampimg() {
            return Champimg;
        }

        public void setChampion(String champion) {
        Champion = champion;
        }

        public void setChampimg(int champimg) {
        Champimg = champimg;
        }
}

