package person;

@SuppressWarnings("serial")
public class AmbigiousPersonException extends Exception {

	String path1, path2;

	public AmbigiousPersonException(String path1, String path2) {
		this.path1 = path1;
		this.path2 = path2;
	}

	@Override
	public String toString() {
		return "AmbigiousPersonException [path1=" + path1 + ", path2=" + path2 + "]";
	}

	public String getPath1() {
		return path1;
	}

	public String getPath2() {
		return path2;
	}


}
