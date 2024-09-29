# JavaToMarkdownConverter.java

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaToMarkdownConverter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: JavaToMarkdownConverter <source directory> <destination directory>");
            return;
        }

        Path sourceDir = Paths.get(args[0]);
        Path destDir = Paths.get(args[1]);

        if (!Files.isDirectory(sourceDir)) {
            System.out.println("Source directory does not exist or is not a directory.");
            return;
        }

        try {
            Files.createDirectories(destDir);
            traverseAndConvert(sourceDir, destDir);
            System.out.println("Conversion completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void traverseAndConvert(Path sourceDir, Path destDir) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    convertJavaToMarkdown(file, sourceDir, destDir);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void convertJavaToMarkdown(Path javaFile, Path sourceDir, Path destDir) throws IOException {
        String relativePath = sourceDir.relativize(javaFile).toString();
        String markdownFilePath = destDir.resolve(relativePath.replace(".java", ".md")).toString();
        
        // Create directories if they do not exist
        Files.createDirectories(Paths.get(markdownFilePath).getParent());

        try (BufferedReader reader = Files.newBufferedReader(javaFile);
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(markdownFilePath))) {
            
            writer.write("# " + relativePath + "\n\n");
            writer.write("```java\n");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\n");
            }

            writer.write("```\n");
        }
    }
}
```
