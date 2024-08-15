public class NewspaperFormatter {
    public static String formatNewspaper(String[][] paragraphs, int width) {
        StringBuilder result = new StringBuilder();
        
        // Add top border
        addBorder(result, width);
        
        for (String[] paragraph : paragraphs) {
            result.append("*");
            
            StringBuilder line = new StringBuilder();
            for (String chunk : paragraph) {
                if (line.length() + chunk.length() + 1 > width - 2) {
                    if (line.length() > 0) {
                        centerAlign(result, line.toString().trim(), width - 2);
                        result.append("*\n*");
                        line = new StringBuilder();
                    }
                }
                if (line.length() > 0) {
                    line.append(" ");
                }
                line.append(chunk);
            }
            if (line.length() > 0) {
                centerAlign(result, line.toString().trim(), width - 2);
            }
            result.append("*\n");
        }
        
        // Add bottom border
        addBorder(result, width);
        
        return result.toString();
    }
    
    private static void centerAlign(StringBuilder result, String text, int width) {
        int spaces = width - text.length();
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;
        result.append(" ".repeat(leftSpaces))
              .append(text)
              .append(" ".repeat(rightSpaces));
    }
    
    private static void addBorder(StringBuilder result, int width) {
        result.append("*".repeat(width)).append("\n");
    }
    
    public static void main(String[] args) {
        String[][] paragraphs = {
            {"This", "is", "the", "first", "paragraph."},
            {"Here's", "a", "second", "paragraph", "with", "more", "text."}
        };
        
        int width = 40;
        
        String formattedNewspaper = formatNewspaper(paragraphs, width);
        System.out.println(formattedNewspaper);
    }
}