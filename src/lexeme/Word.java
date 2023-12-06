package lexeme;

public class Word implements WordPunct{
    private Letter[] data;

    public Word(Letter[] data) {
        this.data = data;
    }

    public Letter[] get() {
        return data;
    }
}