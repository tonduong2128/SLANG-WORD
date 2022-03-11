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
		System.out.println("--------------MENU----------- \n" + "1. Tim kiem theo slang word. \n"
				+ "2. Tim kiem theo definition. \n" + "3. Hien thi history, danh sach cac slang word da tim kiem. \n"
				+ "4. Add 1 slang words moi. \n" + "5. Edit 1 slang word. \n" + "6. Delete 1 slang word. \n"
				+ "7. Reset ve danh sach slang words goc. \n" + "8. Random 1 slang word. \n"
				+ "9. Do vui random slang word.\n" + "10. Do vui voi definition. \n" + "0. Thoat");
		Integer choose;
		System.out.print("Ban chon: ");

		choose = scanner.nextInt();
		while (choose < 0 || choose > 10) {
			System.out.print("Chon sai! Moi ban chon lai: ");
			choose = scanner.nextInt();
		}
		return choose;
	}

	private static void findSlangWord() {
//		scanner.nextLine();
		System.out.print("Nhap slang word muon tim kiem: ");
		scanner.nextLine();
		String slangWord = scanner.nextLine();
		String result = slangWords.get(slangWord);
		if (result == null) {
			System.out.println("Khong co slang word nay!");
		} else {
			historySlangWords.put(slangWord, result);
			System.out.println("Ky tu: " + slangWord + " => y nghia: " + result);
		}
	}

	private static void viewHistorySlangWords() {
		int stt = 1;
		for (Entry<String, String> slangWord : historySlangWords.entrySet()) {

			System.out.println(stt + ". Ky tu:" + slangWord.getKey() + " => y nghia: " + slangWord.getValue());
			stt++;
		}
		if (stt == 1) {
			System.out.println("Lich su trong!");
		}
	}

	private static void addNewSlangWords() {
		scanner.nextLine();
		System.out.print("Nhap slang word moi: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value != null) {
			System.out.println("Slang word nay da co roi ban muon ghi de lai chu.");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Ban chon: ");
			int choose = scanner.nextInt();
			while (choose < 1 || choose > 2) {
				System.out.print("Ban da nhap sai! Nhap lai!: ");
				choose = scanner.nextInt();
			}
			if (choose == 2) {
				return;
			}
		}
		System.out.print("Nhap y nghia cua slang word do: ");
		value = scanner.nextLine();
		slangWords.put(slangWord, value);

		System.out.println("Da them slang word moi!");
	}

	private static void editSlangWord() {
		scanner.nextLine();
		System.out.print("Nhap slang word muon chinh sua: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value == null) {
			System.out.println("Khong co slang word nay!");
			return;
		}
		System.out.println("Ky tu:" + slangWord + " => y nghia: " + value);
		System.out.println("Ban muon chinh sua:");
		System.out.println("1. Ky tu");
		System.out.println("2. Y nghia");
		System.out.print(" Ban chon:");
		int choose = scanner.nextInt();
		while (choose < 1 || choose > 2) {
			System.out.print("Ban da nhap sai! Nhap lai!: ");
			choose = scanner.nextInt();
		}
		scanner.nextLine();
		if (choose == 1) {
			System.out.print("Nhap ky tu moi: ");
			String newKey = scanner.nextLine();
			slangWords.put(newKey, slangWords.remove(slangWord));

		} else {
			System.out.print("Nhap y nghia moi: ");
			String newValue = scanner.nextLine();
			slangWords.replace(slangWord, newValue);

		}
		System.out.println("Slang word da duoc cap nhap!");
	}

	private static void deleteSlangWord() {
		scanner.nextLine();
		System.out.print("Nhap slang word muon chinh sua: ");
		String slangWord = scanner.nextLine();
		String value = slangWords.get(slangWord);
		if (value == null) {
			System.out.println("Khong co slang word nay!");
			return;
		}
		System.out.println("Ky tu:" + slangWord + " => y nghia: " + value);
		System.out.println("Ban co chac muon xoa slang word nay chu.");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		System.out.print("Ban chon: ");
		int choose = scanner.nextInt();
		while (choose < 1 || choose > 2) {
			System.out.print("Ban da nhap sai! Nhap lai!: ");
			choose = scanner.nextInt();
		}
		if (choose == 2) {
			return;
		}
		slangWords.remove(slangWord);
		System.out.println("Da xoa slang word nay");
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
				System.out.println("Nhan phim Enter de tiep tuc!");
				scanner.nextLine();
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				viewHistorySlangWords();
				System.out.println("Nhan phim Enter de tiep tuc!");
				scanner.nextLine();
				scanner.nextLine();
				break;
			}
			case 4: {
				addNewSlangWords();
				System.out.println("Nhan phim Enter de tiep tuc!");
				scanner.nextLine();
				break;
			}
			case 5: {
				editSlangWord();
				System.out.println("Nhan phim Enter de tiep tuc!");
				scanner.nextLine();
				break;
			}
			case 6: {
				deleteSlangWord();
				System.out.println("Nhan phim Enter de tiep tuc!");
				scanner.nextLine();
				scanner.nextLine();
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
