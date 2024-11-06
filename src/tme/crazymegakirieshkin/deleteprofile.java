package tme.crazymegakirieshkin;

import java.util.Scanner;
import java.io.File;

public class deleteprofile {
    public static void main(String[] args) {
        File file = new File("yourdata.txt");
        if (file.exists() == false) {
            System.out.println("вы не зарегестрированы в системе");
        } else if (file.exists() == true) {
            System.setProperty("file.encoding", "UTF-8");
            System.out.println("точно ли вы хотите удалить свою учетную запись? напишите да или нет");
            Scanner scan = new Scanner (System.in);
            String yesorno = scan.nextLine();
            if (yesorno.contains("да") || yesorno.contains("lf") || yesorno.contains("LF") || yesorno.contains("ДА")) {
                if (file.delete()) {
                    System.out.println("файл удален");
                } else {
                    System.out.println("ошибка удаления файла");
                }
            } else if (yesorno.contains("нет") || yesorno.contains("ytn") || yesorno.contains("YTN") || yesorno.contains("НЕТ")) {
                System.out.println("нет так нет");
            } else {
                System.out.println("напишите да или нет");
            }
        }
    }
}