package input_output;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Set;

public class FileAttributes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("temp");

        System.out.println("Size : " + Files.size(path));
        System.out.println("Modification Date : " + Files.getLastModifiedTime(path));
        System.out.println("Is writable : " + Files.isWritable(path));

        FileStore fileStore = Files.getFileStore(path);
        System.out.println("Type : " + fileStore.type());
        System.out.println("==============================");
        System.out.println();

        validateView(fileStore, BasicFileAttributeView.class);
        validateView(fileStore, DosFileAttributeView.class);
        validateView(fileStore, PosixFileAttributeView.class);
        validateView(fileStore, AclFileAttributeView.class);
        validateView(fileStore, UserDefinedFileAttributeView.class);
        validateView(fileStore, FileOwnerAttributeView.class);

        System.out.println("==============================");
        System.out.println();

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("Creation Time : " + dosFileAttributes.creationTime());
        System.out.println("Is hidden : " + dosFileAttributes.isHidden());
        System.out.println("Is system : " + dosFileAttributes.isSystem());

        System.out.println("==============================");
        System.out.println();

//        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rwx------");
//        FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(posixFilePermissions);
//        Files.createFile(Paths.get("file1.txt"), fileAttributes);

        UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("alexander.mikhailov");
        AclFileAttributeView view = Files.getFileAttributeView(path,AclFileAttributeView.class);
        AclEntry entry = AclEntry.newBuilder().setType(AclEntryType.ALLOW)
                .setPrincipal(user)
                .setPermissions(AclEntryPermission.READ_DATA)
                .build();
        List<AclEntry> acl = view.getAcl();
        acl.add(entry);
        view.setAcl(acl);
    }

    private static void validateView(FileStore fileStore, Class<? extends FileAttributeView> viewClass) {
        boolean supports = fileStore.supportsFileAttributeView(viewClass);
        System.out.println("Supports " + viewClass.getSimpleName() + " - " + supports);
    }
}
