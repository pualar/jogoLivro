package JogoLivro;
import java.util.Collection;

public class BlankEvent extends Event{
    public BlankEvent(String description, Collection<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {

    }
}