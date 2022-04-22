package com.company.brand;

import java.util.LinkedHashMap;

public class Brand{
    private Long id;
    private String brandName;
    private static String[] brand = new String[9];
    private static LinkedHashMap<String, Integer> brands = new LinkedHashMap<>();

    public Brand(Long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public static void addBrand(String brandName, int index){
        brand[index] = brandName;
        brands.put(brandName, (index+1));
    }

    public static void compare(String[] brand){
       for(int i = 0; i < brand.length; i++){
           String first = brand[i];
           int index = i;
           for(int j = i + 1; j < brand.length; j++){
               int result = first.compareTo(brand[j]);
               if (result >0) {
                   first = brand[j];
                   index = j;
               }
           }

           String temp = brand[i];
           brand[i] = first;
           brand[index] = temp;
       }
    }

    public static void print(){
        compare(brand);
        System.out.println("Markalarımız \n" + "------------------");
        for (String brands : brand){
            System.out.println(brands);
        }
        System.out.println("------------------");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
