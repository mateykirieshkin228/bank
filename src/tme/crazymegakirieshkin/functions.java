package tme.crazymegakirieshkin;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class functions {
	public static void main(String[] args) throws InterruptedException, IOException {
	System.out.println("этот файл ничего не делает, он нужен для корректной работы других файлов");
}
	public static void FileFiller(String text) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("yourdata.txt", true))) {
			writer.write(text);
			writer.newLine();
		} catch (IOException e) {
			System.out.println("не записал хз почему");
			e.printStackTrace();
		}
	}
	public static String[] FileReader() throws IOException {
		String str = new String(Files.readAllBytes(Paths.get("yourdata.txt")));
		return str.split("\n");
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