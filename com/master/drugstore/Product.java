package com.master.drugstore;

public class Product {
  private String code;
  private String name;
  private String description;
  private Float price;

  public Product(String code, String name, String description, Float price) {
    this.setCode(code);
    this.setName(name);
    this.setDescription(description);
    this.setPrice(price);
  }

  public String getCode () {
    return code;
  }

  public void setCode (String code) {
    this.code = code;
  }

  public String getDescription () {
    return description;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getName () {
    return name;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public Float getPrice () {
    return price;
  }

  public void setPrice (Float price) {
    this.price = price;
  }
}