package txtparsing;

/**
 *
 * @author Tonia Kyriakopoulou
 */
public class MyDoc {

    private String title;
    private String text;


    public MyDoc(String title, String text) {
        this.title = title;
        this.text = text;
    }


    public MyDoc() {
    }

    @Override
    public String toString() {
        String ret = "MyDoc{"
                + "\n\tTitle: " + title
                + "\n\tText: " + text;

        return ret + "\n}";
    }

    //---- Getters & Setters definition ----
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String caption) {
        this.text = text;
    }


}
