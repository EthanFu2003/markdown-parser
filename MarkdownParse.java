//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//a
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

//change to markdownparse for makefile
public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket == -1) {
                break;
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket == -1) {
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen == -1) {
                break;
            }
            if (closeBracket + 1 != openParen) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen == -1) {
                break;
            }

            if (openBracket != 0 && markdown.charAt(openBracket - 1) == '!') {
                currentIndex = closeParen + 1;
                continue;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex);
        }
//adding comment
//adding yet another comment
        return toReturn;
    }
//adding a comment for git command testing
//hi
//adding another comment for git command testing
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
