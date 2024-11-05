package tme.crazymegakirieshkin;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import static tme.crazymegakirieshkin.functions.*;

public class seeyourdata {
    public static void main(String[] args) {
        File file = new File("yourdata.txt");
        if (file.exists() == false) {
            System.out.println("вы не зарегестрированы в системе");
        } else if (file.exists() == true) {
            Scanner scan = new Scanner (System.in);
            System.out.println("какую дату хотите вывести?");
            System.out.println("ФИО, паспорт, карта");
            String request = scan.nextLine();
            try {
                String[] lines = FileReader();
                if (request.contains("ФИО") || request.contains("фио") || request.contains("ABJ") || request.contains("abj")) {
                    String[] fio = lines[0].split(" ");
                    System.out.println(fio[0] + " " + fio[1] + " " + fio[2]);
                } else if (request.contains("паспорт") || request.contains("ПАСПОРТ") || request.contains("GFCGJHN") || request.contains("gfcgjhn")) {
                    System.out.println("серия: " + lines[1] + "\nномер: " + lines[2]);
                } else if (request.contains("карта") || request.contains("КАРТА") || request.contains("RFHNF") || request.contains("rfhnf")) {
                    System.out.println("номер: " + lines[3] + "\nсрок годности: " +  lines[4] + "\nCVV: " + lines[5] + "\nПинкод: " + lines[6]);
                } else {
                    System.out.println("такого запроса не существует");
                }
            } catch (IOException e) {
                System.err.println("ошибка при чтении файла: " + e.getMessage());
            }
        }
    }
}