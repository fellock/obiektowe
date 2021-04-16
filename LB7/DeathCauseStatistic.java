import java.util.Arrays;

public class DeathCauseStatistic {
	private String ICD;
	private int[] deaths;

	public DeathCauseStatistic(String iCD, int[] deaths) {
		ICD = iCD;
		this.deaths = deaths;
	}

	public String getICD() {
		return ICD;
	}

	public static DeathCauseStatistic fromCsvLine(String line) {
		String[] stringArray = line.split(",");
		String ICD = stringArray[0].stripTrailing();

		String[] deathStrings = Arrays.copyOfRange(stringArray, 2, 22);
		int[] deathInts = new int[20];

		for (int i = 0;i < 20;i++){
			if (deathStrings[i].equals("-")) {
				deathInts[i] = 0;
			} else {
				deathInts[i] = Integer.parseInt(deathStrings[i]);
			}
		}

		return new DeathCauseStatistic(ICD, deathInts);
	}
}
