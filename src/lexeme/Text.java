package lexeme;

public class Text{
    private Sentence[] data;

    public Text(Sentence[] data) {
        this.data = data;
    }

    public Sentence[] get() {
        return data;
    }
}