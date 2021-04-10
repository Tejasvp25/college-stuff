/*
 * Name : Tejas Vijay Patil
 * Roll No : xxxxxx
 * Gr No : xxxxxxxx
 * Div : SY-C (C3 Batch)
 * 
 * */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

class SpellCheck {
	public static void main(String[] args) {
		Hashtable<String, List<String>> spelldict = new Hashtable<String, List<String>>();
		Scanner sc = new Scanner(System.in);
		String ip = "";
		int choice = 0;
		while (choice != 4) {
			System.out.println(
					"\n1.Add to Dictionary\n2.Get Word From Dictionary\n3.Delete From Dictionary\n\nEnter 4 to Exit\n");
			switch (choice = sc.nextInt()) {
				case 1:
					System.out.println("Enter String to Add : ");
					ip = sc.next();
					SpellCheck.addString(ip, spelldict);
					break;
				case 2:
					System.out.println("Enter String to Retrieve : ");
					ip = sc.next();
					SpellCheck.getString(ip, spelldict);
					break;
				case 3:
					System.out.println("Enter String to Delete : ");
					ip = sc.next();
					SpellCheck.removeString(ip, spelldict);
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Input");
			}

		}
		sc.close();
	}

	static void addString(String str, Hashtable map) {
		Character c = str.charAt(0);

		List<String> list = (List<String>) map.get(c);
		if (list == null) {
			list = new ArrayList<String>();
		}
		if (!list.contains(str)) {
			list.add(str);
			map.put(c, list);
		}
		System.out.print(map);
	}

	static void getString(String str, Hashtable map) {
		char c = str.charAt(0);

		List<String> list = (List<String>) map.get(c);
		if (list == null) {
			System.out.println("Does not exist !\n");
			return;
		}
		if (!list.contains(str)) {
			List<String> templist = new ArrayList<String>();
			int str_len = str.length();

			System.out.println("Did you mean ?\n");

			for (String s : list) {
				if (s.length() < str_len)
					continue;
				if (s.substring(0, str_len).equals(str)) {
					templist.add(s);
				}
			}
			if (templist.size() == 0) {
				templist = list;
			}
			System.out.println(templist);
		} else {
			System.out.println("Correct Spelling\n");
		}
	}

	static void removeString(String str, Hashtable map) {
		Character c = str.charAt(0);

		List<String> list = (List<String>) map.get(c);
		if (list == null) {
			System.out.println("Does not exist !\n");
			return;
		}
		if (list.contains(str)) {
			list.remove(str);
			map.put(c, list);
			System.out.println("Deleted!\n");
			System.out.println(list);
			return;
		}
		System.out.println("Does not exist !\n");

	}
}