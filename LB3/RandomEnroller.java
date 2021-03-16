import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// korzystam z wbudowanego shuffle, bo nie ma co wymyślać koła na nowo

public class RandomEnroller implements Enroller {
	private List<Student> students = new ArrayList<>();
	private SubjectInstance subjectInstance;

	public RandomEnroller(SubjectInstance subjectInstance) {
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
		Collections.shuffle(students);
	}

	@Override
	public void setSubjectInstance(SubjectInstance subjectInstance) {
		this.subjectInstance = subjectInstance;
	}

	public List<Student> getStudents() {
		return students;
	}
}
