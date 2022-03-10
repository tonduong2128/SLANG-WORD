package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	private static HashMap<String, String> slangWords;
	private static Scanner scanner;
	private static Map<String, String> historySlangWords;

	private static void initData() {
		if (slangWords != null) {
			slangWords.clear();
		}
		slangWords = new HashMap<>();
		historySlangWords = new HashMap<>();
		try {
			Scanner sc = new Scanner(new File("slang.txt"));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				int indexSeparate = line.indexOf("`");
				if (indexSeparate != -1) {
					slangWords.put(line.substring(0, indexSeparate), line.substring(indexSeparate + 1, line.length()));
				}
			}
		} catch (FileNotFoundException e) {
		}
	}

	private static Integer menuMain() {
		System.out.println("--------------MENU----------- \n" + "1. Tìm kiếm theo slang word. \n"
				+ "2. Tìm kiếm theo definition. \n" + "3. Hiển thị history, danh sách các slang word đã tìm kiếm. \n"
				+ "4. Add 1 slang words mới. \n" + "5. Edit 1 slang word. \n" + "6. Delete 1 slang word. \n"
				+ "7. Reset về danh sách slang words gốc. \n" + "8. Random 1 slang word. \n"
				+ "9. Đố vui random slang word.\n" + "10. Đố vui với definition. \n" + "0. Thoát");
		Integer choose;
		System.out.print("Bạn chọn: ");

		choose = scanner.nextInt();
		while (choose < 0 || choose > 10) {
			System.out.print("Chọn sai! Mời bạn chọn lại: ");
			choose = scanner.nextInt();
		}
		return choose;
	}

	private static void findSlangWord() {
//		scanner.nextLine();
		System.out.print("Nhập slang word muốn tìm kiếm: ");
		scanner.nextLine();
		String slangWord = scanner.nextLine();
		String result = slangWords.get(slangWord);
		if (result == null) {
			System.out.println("Không có từ này!");
		} else {
			historySlangWords.put(slangWord, result);
			System.out.println("Ký tự: " + slangWord + " => ý nghĩa: " + result);
		}
	}

	private static void viewHistorySlangWords() {
		int stt = 1;
		for (Entry<String, String> slangWord : historySlangWords.entrySet()) {

			System.out.println(stt + ". Ký tự:" + slangWord.getKey() + " => ý nghĩa: " + slangWord.getValue());
			stt++;
		}
		if (stt == 1) {
			System.out.println("Lịch sử trống!");
		}
	}

	private static void addNewSlangWords() {
		scanner.nextLine();
		System.out.print("Nhập slang word mới: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value != null) {
			System.out.println("Slang word này đã có bạn muốn ghi đè lại chứ.");
			System.out.println("1. Có");
			System.out.println("2. Không");
			System.out.print("Bạn chọn: ");
			int choose = scanner.nextInt();
			while (choose < 1 || choose > 2) {
				System.out.print("Bạn đã nhập sai! Nhập lại!: ");
				choose = scanner.nextInt();
			}
			if (choose == 2) {
				return;
			}
		}
		System.out.print("Nhập ý nghĩa của slang word đó: ");
		value = scanner.nextLine();
		slangWords.put(slangWord, value);

		System.out.println("Đã thêm slang word mới");
	}

	private static void editSlangWord() {
		scanner.nextLine();
		System.out.print("Nhập slang word muốn chỉnh sửa: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value == null) {
			System.out.println("Không có slang word này!");
			return;
		}
		System.out.println(". Ký tự:" + slangWord + " => ý nghĩa: " + value);
		System.out.print("Nhập ý nghĩa mới: ");
		String newValue = scanner.nextLine();
		slangWords.replace(slangWord, newValue);
		System.out.println("Slang word đã được cập nhập!");
	}

	private static void deleteSlangWord() {
		scanner.nextLine();
		System.out.print("Nhập slang word muốn chỉnh sửa: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value == null) {
			System.out.println("Không có slang word này!");
			return;
		}
		System.out.println("Bạn chắc chắng muốn xóa slang word này chứ");
		System.out.println("1. Có");
		System.out.println("2. Không");
		System.out.print("Bạn chọn: ");
		int choose = scanner.nextInt();
		while (choose < 1 || choose > 2) {
			System.out.print("Bạn đã nhập sai! Nhập lại!: ");
			choose = scanner.nextInt();
		}
		if (choose == 2) {
			return;
		}
		slangWords.remove(slangWord);
		System.out.println("Đã xóa slang word trên");
	}

	public static void main(String[] args) {
		initData();
		scanner = new Scanner(System.in);
		int choose = -1;
		while (choose != 0) {
			choose = menuMain();
			switch (choose) {
			case 1: {
				findSlangWord();
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				viewHistorySlangWords();
				break;
			}
			case 4: {
				addNewSlangWords();
				break;
			}
			case 5: {
				editSlangWord();
				break;
			}
			case 6: {
				deleteSlangWord();
				break;
			}
			case 7: {
				break;
			}
			case 8: {
				break;
			}
			case 9: {
				break;
			}
			case 10: {
				break;
			}
			case 0: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choose);
			}
		}
	}
}
