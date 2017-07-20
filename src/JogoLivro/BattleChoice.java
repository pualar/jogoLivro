package JogoLivro;
public class BattleChoice extends Choice {
    public BattleChoice(String description, Event event, Enemy enemy) {
        super(description, event);

        this.enemy = enemy;
    }

    @Override
    public void executeChoiceS(Character character) {
        character.battleStress(this.enemy);
    }

    @Override
    public void executeChoiceD(Character character){
    	character.battleDesempenho(this.enemy);
    }

    private Enemy enemy;
}
