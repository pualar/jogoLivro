package JogoLivro;
import java.io.*;
import java.util.*;

public class Book {

    public Book(String description, Event eventInitial, Player player) {
        this.eventInitial = eventInitial;
        this.description = description;
        this.player = player;

        this.resetHistory();
    }
    
//    File arquivo = new File("texto.txt");

    public void resetHistory() {
        this.eventActually = this.eventInitial;
    }

    public String showHistory(File file) throws IOException {
        return this.eventActually.history(file);
    }

    public boolean isTheEnd() {
        return this.eventActually.isEndEvent();
    }

    public String showHistoryBook(){
        return this.description;
    }

    public boolean nextEvent(int number) {
        Choice choice = this.selectChoice(number);

        if(choice != null) {
            choice.executeChoiceS(player);
            choice.executeChoiceD(player);

            if(player.isAlive()) {
                this.eventActually = choice.getEvent();
                this.eventActually.applyHistory(player);
            }
            else {
                Event gameOver = new BlankEvent("Game Over", new ArrayList<Choice>());
                this.eventActually = gameOver;
            }

            return true;
        }

        return false;
    }

    public Choice selectChoice(int number) {
        return this.eventActually.findChoice(number);
    }

    public Collection<Choice> nextEvents() {
        return this.eventActually.nextEvents();
    }

    private Event eventActually;
    private Event eventInitial;
    private String description;
    private Player player;
}
