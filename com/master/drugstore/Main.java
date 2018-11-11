package com.master.drugstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static String FILENAME = "stock.txt";
  static ArrayList<String> content;
  static Scanner scanner;

  public static void main(String[] args) {
    
    try {
      // Reading the file
      content = readFile(FILENAME);

      // Logic to add new textline
      System.out.println("== Register a new product ==");
      scanner = new Scanner(System.in);
      System.out.println("Introduce el código del producto: ");
      String code = scanner.nextLine();
      scanner = new Scanner(System.in);
      System.out.println("Introduce el nombre del producto: ");
      String name = scanner.nextLine();
      scanner = new Scanner(System.in);
      System.out.println("Introduce una descripción: ");
      String description = scanner.nextLine();
      scanner = new Scanner(System.in);
      System.out.println("Introduce el precio del producto: ");
      Float price = scanner.nextFloat();

      // Creating a new Product
      Product product = new Product(code, name, description, price);
      // Generating output product information 
      String productInfo = "Code: " + product.getCode() + "\nName: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: " + product.getPrice() + "\n===============================================";
      // Adding the new text element
      content.add(productInfo);

      // Writing the file
      writeFile(FILENAME, content);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
  Function to read a file
  @param fileName {String}
  @return {ArrayList<String>} Returns the collection of texts found. 
  */
  public static ArrayList<String> readFile(String fileName) throws IOException {
    ArrayList<String> texts = new ArrayList<String>();
    String content = null;

    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    while ((content = br.readLine()) != null) {
      texts.add(content);
    }
    br.close();

    return texts;
  }
  
  /**
  Function to write data into the file
  @param fileName {String}
  @param texts {ArrayList<String>}
  */
  public static void writeFile (String fileName, ArrayList<String> texts) throws IOException {
    FileWriter writer = new FileWriter(FILENAME);
    BufferedWriter bwriter = new BufferedWriter(writer);
    for(int i = 0 ; i < texts.size() ; i++){
      bwriter.write(texts.get(i));
      bwriter.newLine();
    }
    bwriter.close();
    writer.close();
  }
}