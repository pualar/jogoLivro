package JogoLivro;
import java.io.*;
import java.util.*;

public abstract class Event {
    public Event(String description, Collection<Choice> choices) {
        this.description = description;
        this.choices = new ArrayList<>();

        int i = 1;
        for(Choice choice:choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }

    }

    public String history(File file) throws IOException{
    	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    	String line;
    	
    	while((line = bufferedReader.readLine()) != null){
    		if(line.contains(this.description)){
    			return line;
    		}
    	}
    	
        return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) return true;

        return false;
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) {
        for(Choice choice:this.choices) {
            if(choice.getNumber() == number) return choice;
        }

        return null;
    }

    public abstract void applyHistory(Character character);
    private String description;
    private Collection<Choice> choices;
}