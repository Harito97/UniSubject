package com.oop.library;

public class Library {
    Rent[] rents;

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent(){
        long longest = 0;
        Rent longestRent = null;
        for (Rent rent : rents){
            if (rent.getBegin() == null && rent.getEnd() == null){
                continue;
            }
            long time = rent.getEnd().getTime() - rent.getBegin().getTime();
            if (time > longest){
                longest = time;
                longestRent = rent;
            }
        }
        return longestRent;
    }
}
