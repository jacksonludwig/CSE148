package p2WriteBinary;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("numbers");
		DataOutputStream dos = new DataOutputStream(fos); // a wrapper (more capability)

		/*
		 * dos.writeChar('a'); // 2 bytes dos.writeDouble(1.5); // 8 bytes
		 * dos.writeBoolean(true); // 1 bit (requires 1 byte) dos.writeUTF("hey"); // 5
		 * bytes (stores differently than others, changes)
		 */
		
		int[] numbers = { 1230948752, 234725345, 332904857, 44562456, 52562456, 62564562, 252456247, 25262458, 25462459,
				24566210 };
		for (int num : numbers) {
			dos.writeInt(num);
		}

		// dos.flush(); pushes from cache/memory into HDD/SSD/etc.
		dos.close(); // includes the flush method, so you can use this if you're going
		// to close anyway

		System.out.println("done writing");
	}

}
