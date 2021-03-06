package input_output;

import collections.map.AverageStudentGrade;
import collections.map.SubjectGrade;
import collections.map.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    private static final String FILE_NAME = "GradeBookByte.txt";
    private static final String BINARY_FILE = "Students.bin";
    private static final String BUFFERED_FILE = "Buffered.bin";

    public static void main(String[] args) throws IOException {

        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();

        Reader reader = new Reader();
        //reader.readFile(FILE_NAME);

        Writer writer = new Writer();
        writer.writeFile(grades, FILE_NAME);

        FileUtils utils = new FileUtils();
//        writer.writeWithFormatter();

//        processGrades(grades, writer, BINARY_FILE);
//        outputObjects(reader, BINARY_FILE);

//        reader.readFileInFull(FILE_NAME);

//        reader.nioReadFileWithBuffer(FILE_NAME);

//        writer.nioWriteWithBuffer(BUFFERED_FILE);

//        reader.nioReadWithStream(FILE_NAME);

//        writer.nioWriteWithStream(BUFFERED_FILE);

//        reader.nioReadWithChannel(FILE_NAME);

//        writer.nioWriteWithChannel(BUFFERED_FILE);

//        writer.writeWithRandomAccess(FILE_NAME);

        utils.processDir();

    }

    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {

        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }

        writer.writeObject(students, fileName);
    }

    private static void outputObjects(Reader reader, String fileName) {
        List<Student> students = reader.readObjects(fileName);
        for (Student student : students) {
            System.out.printf("%s %.2f %n", student.getStudentName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }
    }

}
