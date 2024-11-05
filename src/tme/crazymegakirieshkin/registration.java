package tme.crazymegakirieshkin;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static tme.crazymegakirieshkin.functions.*;

public class registration {
    public static void main(String[] args) throws InterruptedException {
        File file;
        try {
            file = new File("yourdata.txt");
            if (file.createNewFile()) {
                System.out.println("File created");
                Scanner scan = new Scanner(System.in);
                Random rand = new Random();
                int month;
                int year;
                int pincode;
                System.out.println("hi, ты попал в тест приложуху банка, напиши свое имя");
                String name = scan.next();
                scan.nextLine();
                System.out.println("спасибо, теперь фамилию");
                String surname = scan.next();
                scan.nextLine();
                System.out.println("отлично, теперь отчество");
                String father = scan.next();
                scan.nextLine();
                System.out.println("молодчина, я сейчас напиши любые четыре цифры чтобы я их засчитал как серию паспорта");
                int seria = scan.nextInt();
                scan.nextLine();
                String strNumber1 = String.valueOf(seria);
                int seria_lenght = strNumber1.length();
                if (seria_lenght == 4) {
                    System.out.println("принято, теперь напиши любые 6 цифр, как номер паспорта");
                    int nomer = scan.nextInt();
                    scan.nextLine();
                    String strNumber = String.valueOf(nomer);
                    int nomer_length = strNumber.length();
                    if (nomer_length == 6) {
                        System.out.println("теперь пришло время для твоей карты \nсейчас будет сгенерирован номер твоей карты, это займет 10 секунд");
                        TimeUnit.SECONDS.sleep(10);
                        StringBuilder nonver_cardnum = new StringBuilder();
                        for (int i = 0; i < 16; i++) {
                            if ((i + 1) % 4 == 0 && i + 1 < nonver_cardnum.length()) {
                                nonver_cardnum.append(" ");
                            }
                            nonver_cardnum.append(rand.nextInt(10));
                        }
                        StringBuilder card_number = new StringBuilder();
                        for (int i = 0; i < nonver_cardnum.length(); i++) {
                            card_number.append(nonver_cardnum.charAt(i));
                            if ((i + 1) % 4 == 0 && i + 1 < nonver_cardnum.length()) {
                                card_number.append(" ");
                            }
                        }
                        System.out.println("генерация завершена, ваш номер карты: " + card_number);
                        month = rand.nextInt(12);
                        year = rand.nextInt(2024, 2100);
                        System.out.println("срок годности карты - " + month + "/" + year);
                        StringBuilder cvv = new StringBuilder();
                        for (int i = 0; i < 3; i++) {
                            cvv.append(rand.nextInt(10));
                        }
                        System.out.println("твой cvv код - " + cvv);
                        System.out.println("теперь придумай пинкод, он должен состоять из 4 цифр и не должен быть легким");
                        pincode = scan.nextInt();
                        scan.nextLine();
                        int pincode_len = String.valueOf(pincode).length();
                        if (pincode == 1234 || pincode == 4321 || pincode == 1111 || pincode == 0000 || pincode == 2222 || pincode == 3333 || pincode == 4444 || pincode == 5555 || pincode == 6666 || pincode == 7777 || pincode == 8888 || pincode == 9999) {
                            System.out.println("пинкод слишком легкий");
                        } else {
                            if (pincode_len == 4) {
                                FileFiller(surname + " " + name + " " + father);
                                FileFiller(String.valueOf(seria));
                                FileFiller(String.valueOf(nomer));
                                FileFiller(card_number.toString());
                                FileFiller(month + "/" + year);
                                FileFiller(cvv.toString());
                                FileFiller(String.valueOf(pincode));
                                System.out.println("регистрация завершена");
                            } else if (pincode_len < 4) {
                                System.out.println("пин код не достаточно длинный");
                            } else if (pincode_len > 4) {
                                System.out.println("пин код слишком длинный");
                            }
                        }
                    }
                }
            } else{System.out.println("вы уже зарегестрированы в системе и имеете файл yourdata.txt, если вы хотите изменить данные или удалить их откройте другие файлы в папке назначения");}
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}