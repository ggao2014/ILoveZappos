package com.example.ggrockstar.ilovezappos;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by GGRockstar on 07/02/2017.
 */
public class Product {
    String brand;
    String color;
    String type;
    String price;
    public Product(){
        this.brand = "Nike";
        this.color = "Black";
        this.type = "Shoes";
        this.price = "100";
    }
    public Product getProduct() {
        return null;
    }

    public void setUser(Product product) {

    }
    public void setProduct(Product product){
        this.color = product.color;
        this.price = product.price;
        this.type = product.type;
        this.brand = product.brand;
    }

    public Drawable getImage() {
        return null;
    }

    public void setImage(Drawable image) {

    }

    public String getNote() {
        return null;
    }

    public void setNote(String note) {

    }
    public Product(String brand, String color, String type, String price) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.price = price;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getColor(){
        return this.color;
    }
    public String getType(){
        return this.type;
    }
    public String getPrice(){
        return this.price;
    }
    public static Product search(String searchterm) throws FileNotFoundException {
        Product[] data = new Product[52];
        Scanner in = new Scanner(new File("data.txt"));
        for (int i = 0; i < 52; i++) {
            String str = in.nextLine();
            data[i] = split(str);
        }
        String[] str = searchterm.split(":");
        String type = str[0];
        String search = str[1];
        return searchcases(data, type, search);
    }
    public static Product split(String str) {
        String strr = str.trim();
        String[] product = strr.split(" ");
        Product pr = new Product(product[0], product[1], product[2], product[3]);
        return pr;
    }
    public static Product searchcases(Product[] data, String type, String sear) {
        switch (type) {
            case "brand":
                for (int i = 0; i < 52; i++) {
                    if (data[i].brand.equals(sear)) {        //if found, return; if not, return default
                        return data[i];
                    }
                }
            case "color":
                for (int i = 0; i < 52; i++) {
                    if (data[i].color.equals(sear)) {        //if found, return; if not, return default
                        return data[i];
                    }
                }
            case "type":
                for (int i = 0; i < 52; i++) {
                    if (data[i].type.equals(sear)) {        //if found, return; if not, return default
                        return data[i];
                    }
                }
            case "price":
                for (int i = 0; i < 52; i++) {
                    if (data[i].price.equals(sear)) {        //if found, return; if not, return default
                        return data[i];
                    }
                }
        }
        return data[0];
    }

}
