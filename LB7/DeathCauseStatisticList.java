import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DeathCauseStatisticList {
	public Map<String, DeathCauseStatistic> causeStatisticMap = new HashMap<>();

	public Set<String> getKeys() {
		return causeStatisticMap.keySet();
	}

	public void repopulate(String path) {
		causeStatisticMap.clear();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(path), "utf-8");

			scanner.nextLine();
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				DeathCauseStatistic data = DeathCauseStatistic.fromCsvLine(line);
				causeStatisticMap.put(data.getICD(), data);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
