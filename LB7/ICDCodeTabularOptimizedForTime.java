import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {
	Map<String, String> descriptionMap = new HashMap<>();

	public ICDCodeTabularOptimizedForTime(String path) {
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(path), "utf-8");

			for (int i = 0; i < 87; i++)
				scanner.nextLine();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.matches("[A-Z][0-9]{2}.*")) {
					//! do poprawienia
					descriptionMap.put(line.split(" ")[0],
							Arrays.copyOfRange(line.split(" "), 1, line.split(" ").length).toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getDescription(String ICD) throws IndexOutOfBoundsException {
		if (descriptionMap.containsKey(ICD)) {
			return descriptionMap.get(ICD);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}
