package lexeme;

public class Punctuation implements WordPunct{
    private char data;

    public Punctuation(char data) {
        this.data = data;
    }

    public char get() {
        return data;
    }
}