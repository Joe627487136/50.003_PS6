package Week8;

import java.util.Vector;

public class FirstExample {
	public static Object getLast(Vector list) {
		Vector v2 = (Vector)list.clone();
		int lastIndex = v2.size()-1;
		return v2.get(lastIndex);
	}

	public static void deleteLast(Vector list) {
	      int lastIndex = list.size()-1;
	      list.remove(lastIndex);
	}	
	
	public static boolean contains(Vector list, Object obj) {
		Vector v2 = (Vector)list.clone();
		for (int i = 0; i < v2.size(); i++) {
			if (v2.get(i).equals(obj)) {
				return true;
			}
		}

		return false;
	}
}
