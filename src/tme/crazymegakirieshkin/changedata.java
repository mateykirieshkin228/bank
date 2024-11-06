package tme.crazymegakirieshkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class changedata {
    public static void main(String[] args) {
        File file = new File("yourdata.txt");
        if (file.exists() == false) {
            System.out.println("вы не зарегестрированы в системе");
        } else if (file.exists() == true) {
            System.setProperty("file.encoding", "UTF-8");
            String undercat;
            String categ;
            int newInt;
            String newText;
            String strNumber1;
            System.out.println("выберите раздел данных где хотите произвести изменения");
            System.out.println("доступные: пинкод, паспорт, ФИО");
            Scanner scan = new Scanner(System.in);
            categ = scan.nextLine();
            if (categ.equals("паспорт")) {
                System.out.println("выберите что хотите изменить");
                System.out.println("серия, номер");
                undercat = scan.nextLine();
                if (undercat.contains("серия") || undercat.contains("СЕРИЯ")) {
                    System.out.println("введите новую серию соблюдая теже правила что и при регистрации:");
                    newInt = scan.nextInt();
                    scan.nextLine();
                    strNumber1 = String.valueOf(newInt);
                    int textlen = strNumber1.length();
                    if (textlen == 4) {
                        ReFiller(2, String.valueOf(newInt), 0);
                        System.out.println("значение записано");
                    } else {
                        System.out.println("длина серии не подходит под критерии");
                    }
                }
                else if (undercat.contains("номер") || undercat.contains("НОМЕР")) {
                    System.out.println("введите новый номер соблюдая теже правила что и при регистрации: ");
                    newInt = scan.nextInt();
                    scan.nextLine();
                    strNumber1 = String.valueOf(newInt);
                    int textlen = strNumber1.length();
                    if (textlen == 6) {
                        ReFiller(3, String.valueOf(newInt), 0);
                        System.out.println("значение записано");
                    } else {
                        System.out.println("длина номера не подходит под критерии");
                    }

                }
            } else if (categ.contains("пинкод") || categ.contains("ПИНКОД")) {
                System.out.println("введите новый пинкод соблюдая теже правила что и при регистрации: ");
                newInt = scan.nextInt();
                scan.nextLine();
                strNumber1 = String.valueOf(newInt);
                int textlen = strNumber1.length();
                if (newInt == 1234 || newInt == 4321 || newInt == 1111 || newInt == 0000 || newInt == 2222 || newInt == 3333 || newInt == 4444 || newInt == 5555 || newInt == 6666 || newInt == 7777 || newInt == 8888 || newInt == 9999) {
                    System.out.println("пинкод слишком легкий");
                } else if (textlen == 4) {
                    ReFiller(7, String.valueOf(newInt), 0);
                    System.out.println("значение записано");
                } else {
                    System.out.println("длина пинкода не подходит под критерии");
                }
            } else if (categ.contains("ФИО") || categ.contains("фио")) {
                System.out.println("выберите что хотите поменять");
                System.out.println("фамилия, имя, отчество");
                undercat = scan.nextLine();
                if (undercat.contains("ФАМИЛИЯ") || undercat.contains("фамилия")) {
                    System.out.println("введите новую фамилию: ");
                    newText = scan.nextLine();
                    ReFiller(1, newText, 0);
                    System.out.println("значение записано");
                } else if (undercat.contains("ИМЯ") || undercat.contains("имя")) {
                    System.out.println("введите новое имя: ");
                    newText = scan.nextLine();
                    ReFiller(1, newText, 1);
                    System.out.println("значение записано");
                } else if (undercat.contains("ОТЧЕСТВО") || undercat.contains("отчество")) {
                    System.out.println("введите новое отчество: ");
                    newText = scan.nextLine();
                    ReFiller(1, newText, 2);
                    System.out.println("значение записано");
                }
            }
        }
    }
    public static void ReFiller (int str_num, String newText, int elementIndex) {
        try {
            Path path = Paths.get("yourdata.txt");
            List<String> lines = Files.readAllLines(path);
            if (str_num < 1 || str_num > lines.size()) {
                throw new IllegalArgumentException("номера строки не существует");
            }
            String[] elements = lines.get(str_num - 1).split(" ");
            if (elementIndex < 0 || elementIndex >= elements.length) {
                throw new IllegalArgumentException("элемента не существует");
            }
            elements[elementIndex] = newText;
            lines.set(str_num - 1, String.join(" ", elements));
            Files.write(path, lines);
        } catch (IOException e) {
            System.err.println("ошибка при работе с файлом: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}