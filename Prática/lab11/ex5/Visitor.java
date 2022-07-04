package ex5;

import java.nio.file.*;
import java.util.concurrent.atomic.AtomicLong;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class Visitor{

    private Path c;
    private boolean recursivo;

    public Visitor(String f, boolean recursivo){
        this.c = Paths.get(f);
        this.recursivo = recursivo;
    }

    public AtomicLong totalMemory() throws IOException{
        AtomicLong total = new AtomicLong(0);
        Files.walkFileTree(c, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                String path=file.toString();
                String pathString="";
                for(int i=0;i<path.length();i++){
                    if(path.charAt(i)=='\\'){
                        pathString+="->";
                    }
                    else{
                        pathString+=path.charAt(i);
                    }
                }
                System.out.println(pathString+": "+attrs.size()+" kB");
                total.addAndGet(file.toFile().length());
                return FileVisitResult.CONTINUE;
            }
        });
        return total;
    }



}