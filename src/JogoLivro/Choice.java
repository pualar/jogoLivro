package JogoLivro;
public abstract class Choice {
    public Choice(String description, Event event) {
        this.event = event;
        this.description = description;
    }

    public String getDescription() {
        return number + ": "+ this.description;
    }

    public void defineNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public Event getEvent() {
        return this.event;
    }
 

    public abstract void executeChoiceS(Character character);
    public abstract void executeChoiceD(Character character);

    private String description;
    private Event event;
    private int number;
}