import java.util.ArrayList;
import java.util.List;

public class AlphabeticEnroller implements Enroller {
	private List<Student> students = new ArrayList<>();
	private SubjectInstance subjectInstance;

	public AlphabeticEnroller(SubjectInstance subjectInstance) {
		this.subjectInstance = subjectInstance;
	}

	@Override
	public void addStudent(Student student) {
		students.add(student);
	}

	@Override
	public void clear() {
		students.clear();
	}

	@Override
	public void process() {
		students.sort((Student s1, Student s2) -> s1.getLastName().compareTo(s2.getLastName()));
		students = students.subList(0, subjectInstance.getLimit());
	}

	@Override
	public void setSubjectInstance(SubjectInstance subjectInstance) {
		this.subjectInstance = subjectInstance;
	}

	public List<Student> getStudents() {
		return List.copyOf(students);
	}
}
