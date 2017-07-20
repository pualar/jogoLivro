package JogoLivro;

public class Character {

    public Character(int cr, int stress) {
        this.cr = cr;
        this.stress = stress;
    }

    public void battleStress(Character enemy) {
        this.Estressar(enemy.getStress());
       // enemy.Estressar(this.getStress());
        System.out.println("\n----------------\nSeu estresse: " + this.stress+"%");
    }
    
    public void battleDesempenho(Character enemy){
    	this.lessDesempenho(enemy.getcr());
//    	enemy.lessDesempenho(this.getcr());
    	System.out.println("Seu desempenho: " + this.getcr()+"%"+"\n----------------\n");
    }

    public boolean isAlive() {
        if(this.cr > 50 && this.stress < 100){
            return true;
        }
        if(this.stress >= 100){
        	System.out.println("Game Over\nSeu nível de estresse está muito alto.\nTente controlá-lo nas próximas vezes.\nBoa sorte!");
        }
        if(this.cr < 50){
        	System.out.println("Game Over\nSeu desempenho está inferior ao necessário para continuar\nTente Novamente.");
        }
        return false;
    }

    public void Estressar(int stress) {
        this.stress += stress;
    }
    
    public void lessDesempenho(int cr){
    	this.cr -= cr;
    }
    
    public int getcr(){
    	return this.cr;
    }

    public int getStress() {
        return this.stress;
    }

    private int cr;
    private int stress;
}
