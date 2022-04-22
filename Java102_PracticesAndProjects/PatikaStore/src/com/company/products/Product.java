package com.company.products;

import java.math.BigDecimal;

public class Product {

    private int id;
    private int storage;
    private int RAM;
    private int camera;

    private double productPrice;
    private double screenSize;
    private double batteryPower;

    private String productName;
    private String brand;
    private String productColor;

    private Product(ProductBuilder productBuilder){
        this.id = productBuilder.id;
        this.storage = productBuilder.storage;
        this.RAM = productBuilder.RAM;
        this.camera = productBuilder.camera;
        this.productPrice = productBuilder.productPrice;
        this.screenSize = productBuilder.screenSize;
        this.batteryPower = productBuilder.batteryPower;
        this.productName = productBuilder.productName;
        this.brand = productBuilder.brand;
        this.productColor = productBuilder.productColor;
    }



    public int getId() {
        return id;
    }

    public int getStorage() {
        return storage;
    }

    public int getRAM() {
        return RAM;
    }

    public int getCamera() {
        return camera;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductColor() {
        return productColor;
    }

    public static class ProductBuilder{
        private int id;
        private int storage;
        private int RAM;
        private int camera;

        private double productPrice;
        private double screenSize;
        private double batteryPower;

        private String productName;
        private String brand;
        private String productColor;

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public ProductBuilder RAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public ProductBuilder camera(int camera) {
            this.camera = camera;
            return this;
        }

        public ProductBuilder productPrice(Double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public ProductBuilder screenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public ProductBuilder batteryPower(double batteryPower) {
            this.batteryPower = batteryPower;
            return this;
        }

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductBuilder productColor(String productColor) {
            this.productColor = productColor;
            return this;
        }

        public Product buildProduct(){
            Product product = new Product(this);
            return product;
        }
    }
}
