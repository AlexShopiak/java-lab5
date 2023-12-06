package lexeme;

public class Sentence{
    private WordPunct[] data;

    public Sentence(WordPunct[] data) {
        this.data = data;
    }

    public WordPunct[] get() {
        return data;
    }
}