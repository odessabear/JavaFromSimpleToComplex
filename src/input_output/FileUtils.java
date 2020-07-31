package input_output;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {

    public static void main(String[] args) throws IOException {
        //    printIOFileDetails("BankAccount.txt");
        printNioFileDetails("GradeBookByte.txt");
    }

    public static void printIOFileDetails(String path) throws IOException {
        File file = new File(path);

//      Get path details

        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Relative path: " + file.getPath());
        System.out.println("Free space in MBytes: " + file.getFreeSpace() / 1000000);
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("Is absolute path" + file.isAbsolute());

        System.out.println("Current directory: " + System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is a directory. Printing content: ");
            String[] list = file.list();
            if (list != null) {
                for (String element : list) {
                    System.out.println(element);
                }
            }
        } else {
            System.out.println("It is a file");
            System.out.println("Creating a new file " + file.createNewFile());
            //    Permissions

            System.out.println("Can read - " + file.canRead());
            System.out.println("Can write - " + file.canWrite());
            System.out.println("Can execute - " + file.canExecute());
            System.out.println("File is hidden - " + file.isHidden());
            System.out.println("Last modified - " + file.lastModified());
            System.out.println("Deleting file " + file.delete());

            Path filePath = file.toPath();
            System.out.println(filePath);
        }
    }


    public static void printNioFileDetails(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);
        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);

        System.out.println("File name: " + path2.getFileName());

        Path absolutePath = path.toAbsolutePath();
        System.out.println("Root dir: " + absolutePath.getRoot());
        System.out.println("Absolute path: " + absolutePath);
        System.out.println("Parent dir: " + absolutePath.getParent());
        System.out.println("Name count: " + absolutePath.getNameCount());
        System.out.println("Sub-path: " + absolutePath.subpath(0, 3));

        Path path3 = Paths.get("../../");
        try {
            System.out.println("real path " + path3.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("file exists: " + Files.exists(path2));
        System.out.println("File doesn't exist: " + Files.notExists(path2));
        System.out.println("Is readable: " + Files.isReadable(path2));
        System.out.println("Is Writable: " + Files.isWritable(path2));
        System.out.println("Is Executable: " + Files.isExecutable(path2));

        try {
            System.out.println("Is the same file: " + Files.isSameFile(path, path1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path parentPath = absolutePath.getParent();
        Path filesPath = parentPath.resolve("files");

        if (Files.notExists(filesPath)) {
            Files.createDirectory(filesPath);
        }

        Files.copy(absolutePath, filesPath.resolve("out.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    public void processDir() throws IOException {
        Path dir = Paths.get("temp");
        if (Files.notExists(dir)) {
            Files.createDirectory(dir);
        }
        Files.createDirectories(Paths.get("temp/a/b/c"));

        //Files.createTempDirectory(dir, "tmp");

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();

        for (Path rootDir : rootDirectories) {
            System.out.println(rootDir);
        }

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(dir, filter)) {
            for (Path p : paths) {
                System.out.println(p);
            }
        }
    }

}
