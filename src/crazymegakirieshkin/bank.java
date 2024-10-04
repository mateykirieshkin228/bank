package tme.crazymegakirieshkin;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class bank {
public void main() throws InterruptedException {
	print("src by t.me/crazymegakirieshkin");
	print("программа не хранит у себя ваши данные и не использует в своих целях");
	Scanner scan = new Scanner (System.in);
	String registration = scan.nextLine();
	if (registration.equals("зарегаться")) {
		print("hi, ты попал в тест приложуху банка, напиши свое имя");
		String name = scan.next();
		print("спасибо, теперь фамилию");
		String surname = scan.next();
		scan.nextLine();
		print("отлично, теперь отчество");
		String father = scan.next();
		scan.nextLine();
		print("молодчина, я сейчас напиши любые четыре цифры чтобы я их засчитал как серию паспорта");
		int seria = scan.nextInt();
		scan.nextLine();
		String strNumber1 = String.valueOf(seria);
		int seria_lenght = strNumber1.length();
		if (seria_lenght == 4) {
			print("принято, теперь напиши любые 6 цифр, как номер паспорта");
			int nomer = scan.nextInt();
			scan.nextLine();
			String strNumber = String.valueOf(nomer);
			int nomer_length = strNumber.length();
			if (nomer_length == 6) {
				print("данные записал, надеюсь все правильно, если нет то перезапускай программу");
				print("\nтвое ФИО - " + surname + " " + name + " " + father + "\nсерия паспорта - " + seria + "\nтвой номер паспорта - " + nomer + "\n");
				print("теперь пришло время для твоей карты \nсейчас будет сгенерирован номер твоей карты, это может занять несколько секунд\n");
				Random rand = new Random();
				int[] card_number = {
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),

				};
				print("генерация завершена, ваш номер карты: " + card_number);
				int month = rand.nextInt(12);
				int year = 20 + rand.nextInt(24, 99);
				print("срок годности карты - " + month + "/" + year);
				int[] cvv = {
						rand.nextInt(9),
						rand.nextInt(9),
						rand.nextInt(9),
				};
				print("твой cvv код - " + cvv);
				print("теперь придумай пинкод, он должен состоять из 4 цифры и не должен быть легким\n");
				int pincode = scan.nextInt();
				scan.nextLine();
				int pincode_len = String.valueOf(pincode).length();
				if (pincode == 1234 || pincode == 4321 || pincode == 1111 || pincode == 0000 || pincode == 2222 || pincode == 3333 || pincode == 4444 || pincode == 5555 || pincode == 6666 || pincode == 7777 || pincode == 8888 || pincode == 9999) {
					print("пинкод слишком легкин");
				} else {
					if (pincode_len == 4) {
						print("пинкод прошел проверку");
					} else {
						print("пинкод должен быть 4 цифры");
					}
				}
				print("вы в главном меню банка, выберите раздел");
				print("посмотреть свои данные - 'данные', выйти из профиля - 'выход'\nнастройки профиля - настройки\nпосле каждой команды(выполнения ее) будет вылет, привыкайте\n");
				String operation = scan.next();
				scan.nextLine();
				if (operation.equals("данные")) {
					print("ваши данные:\n ФИО - " + surname + " " + name + " " + father + "\nсерия и номер паспорта: " + seria + " " + nomer + "\nномер карты: " + card_number + "\nсрок годности карты: 00/00 \nCVV код: " + cvv + "\nпинкод: " + pincode + "\n");
				}
				else if (operation.equals("выход")) {
					print("пока");
				}
				else if (operation.equals("настройки")) {
					print("настройки будут позже");
					//ПОКА ЧТО НЕТУ, ФУНКЦИИ ДОСТУПНЫЕ: СМЕНИТЬ ПИНКОД, ОТГЕНЕРИРОВАТЬ НОМЕР КАРТЫ, ИЗМЕНИТЬ ИМЯ
				}
			}
			else {
				print("unknown error");
			}
		}
		else {
			print("номер паспорта должен быть длиной 6 символов");
		}
	}
	else {
		print("серия паспорта должна быть длиной 4 символа");
	}
	System.out.println("src ends work by t.me/crazymegakirieshkin");
}
	public static void print(String text) throws InterruptedException {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			TimeUnit.MILLISECONDS.sleep(50);
		}
	}
}