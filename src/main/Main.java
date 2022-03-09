package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	private static HashMap<String, String> slangWords;
	private static Scanner scanner;

	public static void initData() {
		try {
			if (slangWords != null) {
				slangWords.clear();
			}
			slangWords = new HashMap<>();
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

	public static Integer menuMain() {
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

	public static void findSlangWord() {
//		scanner.nextLine();
		System.out.print("Nhập slang word muốn tìm kiếm: ");
		scanner.nextLine();
		String slangWord = scanner.nextLine();
		String result = slangWords.get(slangWord);
		if (result==null) {
			System.out.println("Không có từ này!");
		} else {
			System.out.println("Với: " + slangWord + " => ý nghĩa: " + result);
		}
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
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}
			case 6: {
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
