package com.example.demo;

public class Cellphone {

    public String code;
    public String brand;
    public String name;
    public String ram;
    public String storage;
    public String color;

    public Cellphone(String code, String brand, String name, String ram, String storage, String color) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}