package lexeme;

class Punctuation implements WordPunct{
    private String mark;

    Punctuation(String input) {
        this.mark = input;
    }

    @Override
    public String join() {
        return mark;
    }
}