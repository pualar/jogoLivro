package JogoLivro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Engine{
		
    public static void main(String[] args) throws IOException {
    	
    	File arquivo = new File("./src/HistoriaJogo.txt");
    	
    	Book book = Engine.createBook();
    	
    	
    	if( ! arquivo.exists() ){
    	    System.out.println("até aqui não foi criado um arquivo");
    	}
    	    	
        System.out.println(book.showHistoryBook());
        
        
        Scanner in = new Scanner(System.in);
    
        do {
            System.out.println(book.showHistory(arquivo));

//            System.out.println("Escolha:  ");

            for(Choice choice:book.nextEvents()) {
                System.out.println(choice.getDescription());
            }

            int i;
            
            do {
            	
                i = in.nextInt();
            } 
            
            while(!book.nextEvent(i));
        } 
        
        while(!book.isTheEnd());
                
    }
    
    public static Book createBook() {
        //(cr, stress)
        Player jogador = new Player(100, 10);
        
        Enemy ficaremCasa = new Enemy(10, 0);
        
        Enemy estudarDeNoite = new Enemy(-2, 2);
        
        //pros dias q ficar duas aulas
        Enemy perde5desempenhoGanha1stress = new Enemy (5, 1);
        
        Enemy ficar2horas = new Enemy(-2, 2);
        Enemy ficar4horas = new Enemy(0, 3);
        
        Enemy perde5desempenho = new Enemy(5, 0);
        
        Enemy ganha1desempenho1stress = new Enemy(-1, 1);
        
        Enemy ganha1desempenho = new Enemy(-1, 0);
        Enemy ganha2desempenho = new Enemy(-2, 0);
        Enemy ganha4desempenho = new Enemy(-4, 0);
        
        Enemy perde5stress = new Enemy(0, -5);
        Enemy perde1stress = new Enemy(0, -2);
        
        Enemy ganha1stress = new Enemy (0, 2);
        Enemy ganha2stress = new Enemy (0, 5);
        Enemy ganha4stress = new Enemy (0, 7);
        
        Enemy empty = new Enemy(0, 0);
        
        
        System.out.println("> Seu desempenho inicial: " + jogador.getcr()+"%");
        System.out.println("> Seu nível de estresse inicial: " + jogador.getStress()+"%");
                   	
        Collection<Choice> escolhas = new ArrayList<Choice>();
        Collection<Choice> continuar = new ArrayList<Choice>();
        Collection<Choice> itens = new ArrayList<Choice>();
        
        Event acabou = new BlankEvent("acabou", escolhas);
        
        continuar = new ArrayList<Choice>();
        Choice continuee = new BattleChoice("Continuar", acabou, empty);
        continuar.add(continuee);
        Event dia10 = new BlankEvent("Parabéns!\nSe você chegou até aqui,\nsignifica que tem garra para chegar até o final do período de maneira equilibrada!!", continuar);
        
        
        
        //////////////////////////////////////
        /////////////// DIA 9 ////////////////
        //////////////// terca feira /////////
        //////////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_9 = new BattleChoice("Estou bem cansado, vou dormir mesmo.", dia10, empty);
        escolhas.add(voltarCasa22_9);
        Event prxEvdia9_4 = new BlankEvent("Amanhã ainda é terça-feira", escolhas);    
        //decidiu voltar pra casa depois de uma hora de happy hour
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa_9 = new BattleChoice("Pois é, as provas estão chegando...", prxEvdia9_4, ganha2stress);
        escolhas.add(voltarCasa_9);
        Event prxEvdia9_2 = new BlankEvent("Por hoje é só", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_9 = new BlankChoice("Continuar.", prxEvdia9_2);
        continuar.add(continuar8_9);
        Event prxEvdia9_1_2 = new BlankEvent("espaireceu", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_9 = new BlankChoice("Continuar.", prxEvdia9_2);
        continuar.add(continuar6_9);
        Event prxEvdia9_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_9 = new BattleChoice("Não, só vou assistir duas aulas.", prxEvdia9_1_2, ganha1stress);
        Choice naoo_9 = new BattleChoice("Sim, ficarei para as quatro.", prxEvdia9_1_1, ganha2stress);
        escolhas.add(simm_9);
        escolhas.add(naoo_9);
        Event prxEvdia9_1 = new BlankEvent("está pronto para assistir", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_9 = new BlankChoice("Continuar.", prxEvdia9_1);
        continuar.add(continuar5_9);
        Event prxEvdia9 = new BlankEvent("você chegou a tempo", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_9 = new BattleChoice("To a fim de assistir minhas series", prxEvdia9_4, perde5desempenho);
        Choice estudar_9 = new BattleChoice("Vou aproveitar e passar a limpo algumas coisas", prxEvdia9_4, ganha1stress);
        escolhas.add(assistirSerie_9);
        escolhas.add(estudar_9);
        Event proxEventodia9 = new BlankEvent("ficar de bobeira", escolhas);
        continuar = new ArrayList<Choice>();
        Choice continuar11 = new BattleChoice("Que boa notícia!", prxEvdia9, empty);
        continuar.add(continuar11);
        Event eventoNoticia = new BlankEvent("Já pode baixá-lo", continuar);        
        //dia nove
        escolhas = new ArrayList<Choice>();
        Choice ficar_9 = new BattleChoice("Ficar em casa.", proxEventodia9, ficaremCasa);
        Choice ir_9 = new BattleChoice("Ir para a faculdade.", eventoNoticia, empty);        
        escolhas.add(ficar_9);
        escolhas.add(ir_9);
        Event dia9 = new BlankEvent("Dia 9:" , escolhas);
        
        
        
        //////////////////////////////////////
        /////////////// DIA 8 ////////////////
        //////////////// SEGUNDA FEIRA ///////
        //////////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_8 = new BattleChoice("Estou bem cansado, vou dormir mesmo.", dia9, empty);
        escolhas.add(voltarCasa22_8);
        Event prxEvdia8_4 = new BlankEvent("Amanhã ainda é terça-feira", escolhas);    
        //decidiu voltar pra casa depois de uma hora de happy hour
        //decidiu ficar mais um pouco
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa2_8 = new BattleChoice("Continuar.", prxEvdia8_4, ganha2stress);
        escolhas.add(voltarCasa2_8);
        Event prxEvdia8_2_2 = new BlankEvent("O trânsito parecia infinito hoje", escolhas);
        //decidiu sair c a galera
        escolhas = new ArrayList<Choice>();
        Choice sairAmigos_8 = new BattleChoice("Também estou cansado, quero dormir.", prxEvdia8_2_2, perde1stress);
        Choice voltarCasa_8 = new BattleChoice("É bom que dá tempo de revisar a matéria de hoje.", prxEvdia8_2_2, ganha2stress);
        escolhas.add(sairAmigos_8);
        escolhas.add(voltarCasa_8);
        Event prxEvdia8_2 = new BlankEvent("O jeito é voltar para casa.", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_8 = new BlankChoice("Continuar.", prxEvdia8_2);
        continuar.add(continuar8_8);
        Event prxEvdia8_1_2 = new BlankEvent("esfriar a cabeça", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_8 = new BlankChoice("Continuar.", prxEvdia8_2);
        continuar.add(continuar6_8);
        Event prxEvdia8_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_8 = new BattleChoice("Não vou aguentar ficar pra tudo.", prxEvdia8_1_2, ganha2stress);
        Choice naoo_8 = new BattleChoice("Vou assistir a todas, mas no intervalo vou comprar um salgado.", prxEvdia8_1_1, ganha4stress);
        escolhas.add(simm_8);
        escolhas.add(naoo_8);
        Event prxEvdia8_1 = new BlankEvent("Mas agora é hora de ir pra aula", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_8 = new BattleChoice("Continuar.", prxEvdia8_1, ganha2stress);
        continuar.add(continuar5_8);
        Event prxEvdia8 = new BlankEvent("Perdeu o almoço.", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_8 = new BattleChoice("Po, tô querendo jogar um Lolzin... Ficar à toa.", prxEvdia8_4, perde5desempenho);
        Choice estudar_8 = new BattleChoice("Tenho que ficar em dia com a materia pra nao me enrolar!", prxEvdia8_4, ganha1desempenho1stress);
        escolhas.add(assistirSerie_8);
        escolhas.add(estudar_8);
        Event proxEventodia8 = new BlankEvent("ficar de bobeira", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar_8 = new BattleChoice("Ficarei em casa.", proxEventodia8, ficaremCasa);
        Choice ir_8 = new BattleChoice("Vou para a faculdade.", prxEvdia8, ganha2stress);        
        escolhas.add(ficar_8);
        escolhas.add(ir_8);
        Event dia8 = new BlankEvent("Dia 8:", escolhas);   
        
        
        //////////////////////////////////////
        /////////////// DIA 7 ////////////////
        ///////////// DOMINGO ////////////////
        //////////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_7 = new BattleChoice("Vou dormir.", dia8, empty);
        escolhas.add(voltarCasa22_7);
        Event prxEvdia7_4 = new BlankEvent("Amanhã é segunda-feira", escolhas);    

        continuar = new ArrayList<Choice>();
        Choice continuar5_7 = new BlankChoice("Continuar.", prxEvdia7_4);
        continuar.add(continuar5_7);
        Event prxEvdia7 = new BlankEvent("Gostei de ver!", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_7 = new BattleChoice("Perdi a noção do tempo! Só me resta dormir agora.", prxEvdia7_4, perde5desempenho);
        Choice estudar_7 = new BattleChoice("Passou muito rápido! Mas ainda dá pra dar uma estudadinha básica.", prxEvdia7, ganha1stress);
        escolhas.add(assistirSerie_7);
        escolhas.add(estudar_7);
        Event proxEventodia7 = new BlankEvent("tios e primos", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar_7 = new BattleChoice("Sim! Comer na casa da vó!", proxEventodia7, ficaremCasa);        
        escolhas.add(ficar_7);
        Event dia7 = new BlankEvent("Dia 7:" , escolhas);   

     
        
        
		//////////////////////////////////////
		/////////////// DIA 6 ////////////////
//		/////////////// SÁBADO ///////////////
		//////////////////////////////////////
		
		escolhas = new ArrayList<Choice>();
		Choice voltarCasa22_6 = new BattleChoice("Estou bem cansado, vou dormir mesmo.", dia7, empty);
		escolhas.add(voltarCasa22_6);
		Event prxEvDia6_4 = new BlankEvent("Amanhã ainda é terça-feira", escolhas);    
		//decidiu voltar pra casa depois de uma hora de happy hour
		escolhas = new ArrayList<Choice>();
		Choice ficarMais_6 = new BattleChoice("Continuar.", prxEvDia6_4, empty);
		escolhas.add(ficarMais_6);
		Event prxEvDia6_2_1 = new BlankEvent("Boa escolha", escolhas);
		//decidir se vai ver série ou dormir
		escolhas = new ArrayList<Choice>();
		Choice sairAmigos_6 = new BattleChoice("Vou dar uma estudada antes de dormir..", prxEvDia6_2_1, perde1stress);
		Choice voltarCasa_6 = new BattleChoice("Vou ficar vendo série até pegar no sono.", prxEvDia6_4, ganha2stress);
		escolhas.add(sairAmigos_6);
		escolhas.add(voltarCasa_6);
		Event prxEvDia6_12 = new BlankEvent("Chegou em casa, mas é meio tarde", escolhas);
		//ir com os pais
		continuar = new ArrayList<Choice>();
		Choice continuar8_6 = new BattleChoice("Continuar.", prxEvDia6_12, empty);
		continuar.add(continuar8_6);
		Event prxEvDia6_1_2 = new BlankEvent("Dar uma voltinha não vai te matar!", continuar);
		//
		continuar = new ArrayList<Choice>();
		Choice continuar18_6 = new BattleChoice("Pois é, mereço um descanso Vou ficar vendo série até dormir.", prxEvDia6_4, empty);
		continuar.add(continuar8_6);
		Event prxEvDia6_2 = new BlankEvent("Já fez muita coisa hoje, não esta cansado?!!", continuar);	
		//nao ir com os pais
		continuar = new ArrayList<Choice>();
		Choice continuar6_6 = new BattleChoice("Continuar.", prxEvDia6_2, empty);
		continuar.add(continuar6_6);
		Event prxEvDia6_1_1 = new BlankEvent("Muito bem. Abrir mão de certas coisas pode ser benéfico no futuro.", continuar);
		//seus pais te chamram pra sair
		escolhas = new ArrayList<Choice>();
		Choice simm_6 = new BattleChoice("Opa, era disso que estava precisando. Vamos!", prxEvDia6_1_2, ficar4horas);
		Choice naoo_6 = new BattleChoice("Puts, tô cheio de coisa pra fazer... Nem vou.", prxEvDia6_1_1, estudarDeNoite);
		escolhas.add(simm_6);
		escolhas.add(naoo_6);
		Event prxEvDia6_1 = new BlankEvent("passeio no shopping.", escolhas);
		//se for pra facul
		continuar = new ArrayList<Choice>();
		Choice continuar5_6 = new BlankChoice("Continuar.", prxEvDia6_1);
		continuar.add(continuar5_6);
		Event prxEvDia6 = new BlankEvent("melhoras/manter seu desempenho", continuar);
		//
		escolhas = new ArrayList<Choice>();
		Choice continue_6 = new BattleChoice("Valeu, tia!", prxEvDia6, ganha4desempenho);
		escolhas.add(continue_6);
		Event prxEvDia6_32 = new BlankEvent("usava para estudar", escolhas);
		//se ficar em casa
		escolhas = new ArrayList<Choice>();
		Choice assistirSerie_6 = new BlankChoice("Continuar.", prxEvDia6_32);
		escolhas.add(assistirSerie_6);
		Event proxEventoDia6 = new BlankEvent("Aparentemente", escolhas);
		//dia um
		escolhas = new ArrayList<Choice>();
		Choice ficar_6 = new BlankChoice("Descobrir o que é.", proxEventoDia6);
		escolhas.add(ficar_6);
		Event dia6 = new BlankEvent("Dia 6:" , escolhas);   

        
        
        //////////////////////////////////////
        /////////////// DIA 5  ///////////////
		//////////// SEXTA FEIRA /////////////
        //////////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_5 = new BattleChoice("Estou bem cansado, vou dormir.", dia6, empty);
        escolhas.add(voltarCasa22_5);
        Event proxEvDia5_4 = new BlankEvent("Final de semana a vista!", escolhas);    
        //decidiu sair c a galera
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa1_5 = new BattleChoice("Melhor ir embora.", dia6, empty);
//        Choice voltarCasa1_5 = new BattleChoice("Pô, tá meio tarde... Acho que já vou.", proxEvDia5_2_3, ganha2stress);
        escolhas.add(voltarCasa1_5);
        Event proxEvDia5_2_1 = new BlankEvent("Já está quase amanhecendo.", escolhas);
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice sairAmigos_5 = new BattleChoice("Claro! Sextou!", proxEvDia5_2_1, perde1stress);
        Choice voltarCasa_5 = new BattleChoice("Não tô muito no clima... Vou pra casa mesmo.", proxEvDia5_4, ganha2stress);
        escolhas.add(sairAmigos_5);
        escolhas.add(voltarCasa_5);
        Event proxEvDia5_2 = new BlankEvent("Por hoje chega de aula", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_5 = new BlankChoice("Continuar.", proxEvDia5_2);
        continuar.add(continuar8_5);
        Event proxEvDia5_1_2 = new BlankEvent("cobra presença?", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_5 = new BlankChoice("Continuar.", proxEvDia5_2);
        continuar.add(continuar6_5);
        Event proxEvDia5_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_5 = new BattleChoice("Não, só vou assistir duas aulas.", proxEvDia5_1_2, ganha1stress);
        Choice naoo_5 = new BattleChoice("Sim, ficarei para as quatro.", proxEvDia5_1_1, ganha2stress);
        escolhas.add(simm_5);
        escolhas.add(naoo_5);
        Event proxEvDia5_1 = new BlankEvent("está pronto para assistir", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_5 = new BlankChoice("Continuar.", proxEvDia5_1);
        continuar.add(continuar5_5);
        Event proxEvDia5 = new BlankEvent("você chegou a tempo", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_5 = new BattleChoice("To a fim de assistir minhas series", proxEvDia5_4, perde5desempenho);
        Choice estudar_5 = new BattleChoice("Vou aproveitar e passar a limpo algumas coisas", proxEvDia5_4, ganha1stress);
        escolhas.add(assistirSerie_5);
        escolhas.add(estudar_5);
        Event proxEventoDia5 = new BlankEvent("ficar de bobeira", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar_5 = new BattleChoice("Ficar em casa.", proxEventoDia5, ficaremCasa);
        Choice ir_5 = new BattleChoice("Ir para a faculdade.", proxEvDia5, ganha2stress);        
        escolhas.add(ficar_5);
        escolhas.add(ir_5);
        Event dia5 = new BlankEvent("Dia 5:" , escolhas);   
        
        //////////////////////////////////////
        /////////////// DIA 4 ////////////////
        //////////// QUINTA FEIRA ////////////
        //////////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_4 = new BattleChoice("Aleluia! Mas agora vou descansar mesmo.", dia5, empty);
        escolhas.add(voltarCasa22_4);
        Event proxEvDia4_4 = new BlankEvent("é sexta-feira", escolhas);    
        //decidiu voltar pra casa depois de uma hora de happy hour
        escolhas = new ArrayList<Choice>();
        Choice dormirDireto_4 = new BattleChoice("Acho que vou deitar, tô cansadão!", dia5, empty);
        Choice dormirDireto_2_4 = new BattleChoice("Vou usar esse tempinho que sobrou pra dar uma lida na matéria.", proxEvDia4_4, estudarDeNoite);
        escolhas.add(dormirDireto_4);
        escolhas.add(dormirDireto_2_4);
        Event proxEvDia4_2_3 = new BlankEvent("Chegou em casa mais cedo hoje!", escolhas);
        //decidiu ficar mais um pouco
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa2_4 = new BattleChoice("Continuar.", proxEvDia4_4, ganha2stress);
        escolhas.add(voltarCasa2_4);
        Event proxEvDia4_2_2 = new BlankEvent("Já está tarde. Melhor", escolhas);      
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa_4 = new BattleChoice("Pois é, não querem fazer nada. Vou para casa.", proxEvDia4_2_3, ganha2stress);
        escolhas.add(voltarCasa_4);
        Event proxEvDia4_2 = new BlankEvent("um pouco desanimados, não é", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_4 = new BlankChoice("Continuar.", proxEvDia4_2);
        continuar.add(continuar8_4);
        Event proxEvDia4_1_2 = new BlankEvent("cobra presença", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_4 = new BlankChoice("Continuar.", proxEvDia4_2);
        continuar.add(continuar6_4);
        Event proxEvDia4_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_4 = new BattleChoice("Não, só vou assistir duas aulas.", proxEvDia4_1_2, ficar2horas);
        Choice naoo_4 = new BattleChoice("Sim, ficarei para as quatro.", proxEvDia4_1_1, ficar4horas);
        escolhas.add(simm_4);
        escolhas.add(naoo_4);
        Event proxEvDia4_1 = new BlankEvent("Preparado para as quatro horas de aula?", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_4 = new BlankChoice("Continuar.", proxEvDia4_1);
        continuar.add(continuar5_4);
        Event proxEvDia4 = new BlankEvent("você chegou a tempo", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_4 = new BattleChoice("To a fim de assistir minhas series", proxEvDia4_4, perde5desempenho);
        Choice estudar_4 = new BattleChoice("Vou passar a limpo algumas coisas", proxEvDia4_4, ganha1stress);
        escolhas.add(assistirSerie_4);
        escolhas.add(estudar_4);
        Event proxEventodia4 = new BlankEvent("responsabilidade?", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar_4 = new BattleChoice("Ficar em casa.", proxEventodia4, ficaremCasa);
        Choice ir_4 = new BattleChoice("Ir para a faculdade.", proxEvDia4, ganha2stress);        
        escolhas.add(ficar_4);
        escolhas.add(ir_4);
        Event dia4 = new BlankEvent("Dia 4:" , escolhas);   

        
        
        ///////////////////////////////////
        //////////// DIA 3 ////////////////
        //////// QUARTA FEIRA /////////////
        ///////////////////////////////////
        
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_3 = new BattleChoice("Estou bem cansado mesmo, vou dormir!", dia4, empty);
        escolhas.add(voltarCasa22_3);
        Event proxEvdia3_4 = new BlankEvent("Amanhã é quinta-feira", escolhas);    
        //decidiu voltar pra casa depois de uma hora de happy hour
        escolhas = new ArrayList<Choice>();
        Choice dormirDireto_3 = new BattleChoice("Pois é, estou destruído, não vou nem conseguir estudar.", dia4, empty);
        escolhas.add(dormirDireto_3);
        Event proxEvdia3_2_3 = new BlankEvent("O trânsito parecia infinito.", escolhas);
        //decidiu ficar mais um pouco
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa2_3 = new BattleChoice("Continuar.", proxEvdia3_4, ganha2stress);
        escolhas.add(voltarCasa2_3);
        Event proxEvdia3_2_2 = new BlankEvent("Já está tarde. Melhor ir para casa.", escolhas);
        //decidiu sair c a galera
        escolhas = new ArrayList<Choice>();
        Choice ficarMais_3 = new BattleChoice("Já que a galera tá pedindo... Vou ficar mais um pouco.", proxEvdia3_2_2, perde1stress);
        Choice voltarCasa1_3 = new BattleChoice("Pô, tá meio tarde... Acho que já vou.", proxEvdia3_2_3, ganha2stress);
        escolhas.add(voltarCasa1_3);
        escolhas.add(ficarMais_3);
        Event proxEvdia3_2_1 = new BlankEvent("Já se passaram mais de dez minutinhos...", escolhas);
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice sairAmigos_3 = new BattleChoice("Vou ficar só 10 minutinhos.", proxEvdia3_2_1, perde1stress);
        Choice voltarCasa_3 = new BattleChoice("Não, vou embora, quero estudar antes de dormir.", proxEvdia3_4, ganha2stress);
        escolhas.add(sairAmigos_3);
        escolhas.add(voltarCasa_3);
        Event proxEvdia3_2 = new BlankEvent("Por hoje chega de aula", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_3 = new BlankChoice("Continuar.", proxEvdia3_2);
        continuar.add(continuar8_3);
        Event proxEvdia3_1_2 = new BlankEvent("esfriar a cabeça", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_3 = new BlankChoice("Continuar.", proxEvdia3_2);
        continuar.add(continuar6_3);
        Event proxEvdia3_1_1 = new BlankEvent("Muito bem, aprendizado", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_3 = new BattleChoice("Não, só vou assistir duas aulas.", proxEvdia3_1_2, ganha1stress);
        Choice naoo_3 = new BattleChoice("Sim, ficarei para as quatro.", proxEvdia3_1_1, ficar4horas);
        escolhas.add(simm_3);
        escolhas.add(naoo_3);
        Event proxEvdia3_1 = new BlankEvent("está pronto para assistir", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_3 = new BlankChoice("Continuar.", proxEvdia3_1);
        continuar.add(continuar5_3);
        Event proxEvDia3 = new BlankEvent("quase perdeu o almoço hoje...", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_3 = new BattleChoice("Diversão. Vou relaxar um pouco.. Vou ter muito tempo para estudar.", proxEvdia3_4, perde5desempenho);
        Choice estudar_3 = new BattleChoice("Responsabillidades! Quero ficar tranquilo para aproveitar no fim de semana.", proxEvdia3_4, ganha1desempenho1stress);
        escolhas.add(assistirSerie_3);
        escolhas.add(estudar_3);
        Event proxEventoDia3 = new BlankEvent(" Diversão ou responsabilidade?", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar_3 = new BattleChoice("Ficar em casa.", proxEventoDia3, ficaremCasa);
        Choice ir_3 = new BattleChoice("Ir para a faculdade.", proxEvDia3, ganha2stress);        
        escolhas.add(ficar_3);
        escolhas.add(ir_3);
        Event dia3 = new BlankEvent("Dia 3:" , escolhas);  
        
        
        //////////////////////////////////////
        /////////////// DIA 2 ////////////////
        //////////// TERÇA FEIRA /////////////
        //////////////////////////////////////
        
      
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22_2 = new BattleChoice("Aleluia! Agora vou deitar.", dia3, empty);
        escolhas.add(voltarCasa22_2);
        Event proxEvdia2_4 = new BlankEvent("amanhã é quarta-feira", escolhas);    
        //decidiu voltar
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa2_2 = new BattleChoice("Bem lembrado, já estou indo.", proxEvdia2_4, ganha2stress);
        escolhas.add(voltarCasa2_2);
        Event proxEvdia2_2_2 = new BlankEvent("Não ia ficar só um pouco?", escolhas);
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice sairAmigos_2 = new BattleChoice("Vou sim! Mas só um pouco.", proxEvdia2_2_2, perde1stress);
        Choice voltarCasa_2 = new BattleChoice("Vou nada, estou cansado. Vou embora.", proxEvdia2_4, ganha2stress);
        escolhas.add(sairAmigos_2);
        escolhas.add(voltarCasa_2);
        Event proxEvdia2_2 = new BlankEvent("querendo se reunir depois", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8_2 = new BlankChoice("Continuar.", proxEvdia2_2);
        continuar.add(continuar8_2);
        Event proxEvdia2_1_2 = new BlankEvent("espaireceu", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6_2 = new BlankChoice("Continuar.", proxEvdia2_2);
        continuar.add(continuar6_2);
        Event proxEvdia2_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm_2 = new BattleChoice("Pois é, vou ficar para assistir tudo.", proxEvdia2_1_1, ficar4horas);
        Choice naoo_2 = new BattleChoice("Tava bom mesmo, mas vou assistir só as primeiras.", proxEvdia2_1_2, ficar2horas);
        escolhas.add(simm_2);
        escolhas.add(naoo_2);
        Event proxEvdia2_1 = new BlankEvent("Depois desse almoço", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5_2 = new BlankChoice("Continuar.", proxEvdia2_1);
        continuar.add(continuar5_2);
        Event proxEvdia2 = new BlankEvent("trânsito estava pesado", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie_2 = new BattleChoice("Diversão, to precisando relaxar.", proxEvdia2_4, perde5desempenho);
        Choice estudar_2 = new BattleChoice("Responsabilidade, tenho coisas para fazer.", proxEvdia2_4, ganha1stress);
        escolhas.add(assistirSerie_2);
        escolhas.add(estudar_2);
        Event proxEventodia2 = new BlankEvent("Diversão ou responsabilidade", escolhas);
        //dia dois
        escolhas = new ArrayList<Choice>();
        Choice ficar_2= new BattleChoice("Ficar em casa.", proxEventodia2, ficaremCasa);
        Choice ir_2 = new BattleChoice("Ir para a faculdade.", proxEvdia2, ganha2stress);        
        escolhas.add(ficar_2);
        escolhas.add(ir_2);
        Event dia2 = new BlankEvent("Dia 2:" , escolhas);        
  
        
        //////////////////////////////////////
        /////////////// DIA 1 ////////////////
        /////////// SEGUNDA FEIRA ////////////
        //////////////////////////////////////
        
        //voltou pra casa depois de duas horas de happy hour
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa22 = new BattleChoice("Estou bem cansado, vou dormir mesmo.", dia2, empty);
        escolhas.add(voltarCasa22);
        Event proxEvDia1_4 = new BlankEvent("Amanhã ainda é terça-feira", escolhas);    
        //decidiu voltar pra casa depois de uma hora de happy hour
        escolhas = new ArrayList<Choice>();
        Choice dormirDireto = new BattleChoice("Estou bem cansado da viagem. Acho que vou dormir", dia2, empty);
        escolhas.add(dormirDireto);
        Event proxEvDia1_2_3 = new BlankEvent("Depois de algumas horas de viagem, você chegou em casa.", escolhas);
        //decidiu ficar mais um pouco
        escolhas = new ArrayList<Choice>();
        Choice voltarCasa2 = new BattleChoice("Continuar.", proxEvDia1_4, ganha2stress);
        escolhas.add(voltarCasa2);
        Event proxEvDia1_2_2 = new BlankEvent("bem tarde", escolhas);
        //decidiu sair c a galera
        escolhas = new ArrayList<Choice>();
        Choice ficarMais = new BattleChoice("Já que a galera tá pedindo... Vou ficar mais um pouco.", proxEvDia1_2_2, perde1stress);
        Choice voltarCasa1 = new BattleChoice("Pô, tá meio tarde... Acho que já vou.", proxEvDia1_2_3, ganha2stress);
        escolhas.add(voltarCasa1);
        escolhas.add(ficarMais);
        Event proxEvDia1_2_1 = new BlankEvent("E aí, vai fechar", escolhas);
        //decidir se sai ou se vai p casa
        escolhas = new ArrayList<Choice>();
        Choice sairAmigos = new BattleChoice("Acho que vou sair com a galera, me enturmar.", proxEvDia1_2_1, perde1stress);
        Choice voltarCasa = new BattleChoice("Estou cansado, vou embora.", proxEvDia1_4, ganha2stress);
        escolhas.add(sairAmigos);
        escolhas.add(voltarCasa);
        Event proxEvDia1_2 = new BlankEvent("happy hour", escolhas);
        //se escolher ir pra duas aulas 
        continuar = new ArrayList<Choice>();
        Choice continuar8 = new BlankChoice("Continuar.", proxEvDia1_2);
        continuar.add(continuar8);
        Event proxEvDia1_1_2 = new BlankEvent("espaireceu", continuar);
        //se escolher ficar pras quatro aulas
        continuar = new ArrayList<Choice>();
        Choice continuar6= new BlankChoice("Continuar.", proxEvDia1_2);
        continuar.add(continuar6);
        Event proxEvDia1_1_1 = new BlankEvent("decisão sensata", continuar);
        //ficar pra aula ou sair
        escolhas = new ArrayList<Choice>();
        Choice simm = new BattleChoice("Não, só vou assistir duas aulas.", proxEvDia1_1_2, ficar2horas);
        Choice naoo = new BattleChoice("Sim, ficarei para as quatro.", proxEvDia1_1_1, ficar4horas);
        escolhas.add(simm);
        escolhas.add(naoo);
        Event proxEvDia1_1 = new BlankEvent("está pronto para assistir", escolhas);
        //se for pra facul
        continuar = new ArrayList<Choice>();
        Choice continuar5= new BlankChoice("Continuar.", proxEvDia1_1);
        continuar.add(continuar5);
        Event proxEvDia1 = new BlankEvent("você chegou a tempo", continuar);
        //se ficar em casa
        escolhas = new ArrayList<Choice>();
        Choice assistirSerie = new BattleChoice("To a fim de assistir minhas series", proxEvDia1_4, perde5desempenho);
        Choice estudar = new BattleChoice("Vou aproveitar e passar a limpo algumas coisas", proxEvDia1_4, ganha1stress);
        escolhas.add(assistirSerie);
        escolhas.add(estudar);
        Event proxEventoDia1 = new BlankEvent("ficar de bobeira", escolhas);
        //dia um
        escolhas = new ArrayList<Choice>();
        Choice ficar= new BattleChoice("Ficar em casa.", proxEventoDia1, ficaremCasa);
        Choice ir = new BattleChoice("Ir para a faculdade.", proxEvDia1, ganha2stress);        
        escolhas.add(ficar);
        escolhas.add(ir);
        Event dia1 = new BlankEvent("Dia 1:" , escolhas);
        
        
        
        
        
        continuar = new ArrayList<Choice>();
        Choice continuar4 = new BlankChoice("Continuar", dia1);
        continuar.add(continuar4);
        Event eventoInitial = new BlankEvent("welcome to hell!", continuar);
        
        
        continuar = new ArrayList<Choice>();
        Choice continuar3 = new BlankChoice("Continuar", eventoInitial);
        continuar.add(continuar3);
        Event eventoIntroducao3 = new BlankEvent("um ótimo rendimento com", continuar);
        
        
        continuar = new ArrayList<Choice>();
        Choice continuar2 = new BlankChoice("Continuar", eventoIntroducao3);
        continuar.add(continuar2);
        Event eventoIntroducao2 = new BlankEvent("já começaram a marcar as provas", continuar);
                
        
        continuar = new ArrayList<Choice>();
        Choice continuar1 = new BlankChoice("Continuar", eventoIntroducao2);
        continuar.add(continuar1);
        Event eventoIntroducao = new BlankEvent("primeira semana de aulas", continuar);
        

        Book livro = new Book("\nUniversitáiro Cansado\n", eventoIntroducao, jogador);

        return livro;
    }	
}