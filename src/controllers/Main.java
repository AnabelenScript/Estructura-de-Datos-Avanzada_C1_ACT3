package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import models.HashTable.HashTable;
import models.LinkedList.LinkedList;
import models.LinkedList.Nodo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String csvFile = "C:\\Users\\ana05\\OneDrive\\Documentos\\Estructura avanzada\\TablasHash\\bussines.csv";
        String line = "";
        String splitBy = ",";
        int id = 1;
        int menu=0;
        boolean valida= false;
        HashTable hashTable = new HashTable(10);

        do {
            System.out.println("Bienvenido, seleccione la opcion que desee realizar");
            System.out.println(
                    "1) Cargar base de datos con Division 2) Cargar base de datos con Multiplicacion  3) Imprimir base de datos 4) Hacer búsqueda por Multiplicacion 5)Hacer busqueda por Division ");
            while (valida == false) {
                try {
                    menu = sc.nextInt();
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Intentelo de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            switch (menu) {
                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        while ((line = br.readLine()) != null) {
                            String[] business = line.split(splitBy);
                            String idStr = business[0].trim();
                            String name = business[1].trim();
                            String address = business[2].trim();
                            String city = business[3].trim();
                            String state = business[4].trim();
                            String data = "[" + idStr + "] Business [Name=" + name + ", Address=" + address + ", City=" + city + ", State=" + state + "]";
                            hashTable.addDivision(idStr, data);
                            System.out.println("[" + id + "] Added: " + data);
                            id++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    while ((line = br.readLine()) != null) {
                        String[] business = line.split(splitBy);
                        String idStr = business[0].trim();
                        String name = business[1].trim();
                        String address = business[2].trim();
                        String city = business[3].trim();
                        String state = business[4].trim();
                        String data = "[" + idStr + "] Business [Name=" + name + ", Address=" + address + ", City=" + city + ", State=" + state + "]";
                        hashTable.addMultiplicacion(idStr, data);
                        System.out.println("[" + id + "] Added: " + data);
                        id++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    break;
                case 3:
               LinkedList[] table = hashTable.getTable();
                    for (int i = 0; i < table.length; i++) {
                        System.out.print("Bucket " + i + ": ");
                        Nodo current = table[i].getHead();
                        while (current != null) {
                            System.out.print(current.value + " ");
                            current = current.next;
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                System.out.println("Ingrese el nombre del negocio que desea buscar:");
                sc.nextLine(); 
                String nameToSearch1 = sc.nextLine().trim();
                boolean found = hashTable.searchByNameUsingMultiplication(nameToSearch1);
                if (!found) {
                    System.out.println("El nombre '" + nameToSearch1 + "' no fue encontrado en la tabla hash usando hash Multiplication.");
                }
                break;

                case 5:
                System.out.println("Ingrese el nombre del negocio que desea buscar:");
                sc.nextLine();
                String nameToSearch2 = sc.nextLine().trim();
                boolean found2 = hashTable.searchByNameUsingDivision(nameToSearch2);
                if (!found2) {
                    System.out.println("El nombre '" + nameToSearch2 + "' no fue encontrado en la tabla hash usando hash Division.");
                }
                break;
                default:
                    break;
            }
        } while (menu != 6);
    }
}
