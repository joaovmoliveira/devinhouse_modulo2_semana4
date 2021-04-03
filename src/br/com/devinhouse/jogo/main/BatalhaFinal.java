package br.com.devinhouse.jogo.main;

import java.util.Scanner;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.enums.Motivacao;
import br.com.devinhouse.jogo.exceptions.OpcaoInvalidaException;
import br.com.devinhouse.jogo.personagens.Armadilha;
import br.com.devinhouse.jogo.personagens.Inimigo;
import br.com.devinhouse.jogo.personagens.Jogador;
import br.com.devinhouse.jogo.personagens.classesjogador.Arqueiro;
import br.com.devinhouse.jogo.personagens.classesjogador.Guerreiro;
import br.com.devinhouse.jogo.personagens.classesjogador.Mago;
import br.com.devinhouse.jogo.personagens.classesjogador.Paladino;
import br.com.devinhouse.jogo.personagens.inimigos.Alquimista;
import br.com.devinhouse.jogo.personagens.inimigos.Armeiro;
import br.com.devinhouse.jogo.personagens.inimigos.Lider;

public class BatalhaFinal {

	public static void main(String[] args) {
		System.out.println("Seja bem vindo(a) � BATALHA FINAL!");
		Scanner sc = new Scanner(System.in);
		Jogador jogador = null;
		boolean repetir = true;
		int intOpcao = 0;

		do {
			try {
				// TODO: solicitar ao jogador um nome para o personagem.
				System.out.println("Escolha um nome para o seu personagem:");
				String nomePersonagemJogador = sc.nextLine();

				// TODO: solicitar ao jogador um sexo para o personagem.
				// M ou F.
				System.out.println("Seu personagem � do sexo Masculino ou Feminino? (M/F):");
				char sexoPersonagemJogador = sc.nextLine().toUpperCase().charAt(0);
				if (sexoPersonagemJogador != 'M' && sexoPersonagemJogador != 'F') {
					throw new OpcaoInvalidaException("Insira M ou F para escolher o sexo.");
				}

				// TODO: solicitar ao jogador qual a classe do personagem.
				// Guerreiro, Paladino, Arqueiro, Mago.
				System.out.println("Selecione uma classe de personagem:");
				System.out.println("1 - Guerreiro,");
				System.out.println("2 - Paladino,");
				System.out.println("3 - Arqueiro,");
				System.out.println("4 - Mago.");
				System.out.println("Digite apenas o n�mero correspondente � classe escolhida:");

				intOpcao = escolherOpcao(4, sc);

				// TODO: solicitar ao jogador qual arma o personagem vai usar,
				// dentre as op��es dispon�veis para a classe selecionada.
				System.out.println("Selecione uma arma: ");
				switch (intOpcao) {
				case 1:
					System.out.println("1 - " + Arma.ESPADA.getNome());
					System.out.println("2 - " + Arma.MACHADO.getNome());
					break;
				case 2:
					System.out.println("1 - " + Arma.MARTELO.getNome());
					System.out.println("2 - " + Arma.CLAVA.getNome());
					break;
				case 3:
					System.out.println("1 - " + Arma.ARCO.getNome());
					System.out.println("2 - " + Arma.BESTA.getNome());
					break;
				case 4:
					System.out.println("1 - " + Arma.CAJADO.getNome());
					System.out.println("2 - " + Arma.LIVRO.getNome());
					break;
				}
				System.out.println("Digite apenas o n�mero correspondente � arma escolhida:");

				int intArma = escolherOpcao(2, sc);

				// TODO: instanciar um novo objeto da classe selecionada pelo jogador,
				// passando como argumentos os valores coletados.

				Arma armaEscolhida;
				switch (intOpcao) {
				case 1:
					armaEscolhida = intArma == 1 ? Arma.ESPADA : Arma.MACHADO;
					jogador = new Guerreiro(nomePersonagemJogador, sexoPersonagemJogador, armaEscolhida);
					break;
				case 2:
					armaEscolhida = intArma == 1 ? Arma.MARTELO : Arma.CLAVA;
					jogador = new Paladino(nomePersonagemJogador, sexoPersonagemJogador, armaEscolhida);
					break;
				case 3:
					armaEscolhida = intArma == 1 ? Arma.ARCO : Arma.BESTA;
					jogador = new Arqueiro(nomePersonagemJogador, sexoPersonagemJogador, armaEscolhida);
					break;
				case 4:
					armaEscolhida = intArma == 1 ? Arma.CAJADO : Arma.LIVRO;
					jogador = new Mago(nomePersonagemJogador, sexoPersonagemJogador, armaEscolhida);
					break;
				}
				repetir = false;
			} catch (NumberFormatException nfe) {
				System.err.println("Para escolha da classe ou arma, digite apenas n�meros.");
			} catch (OpcaoInvalidaException oie) {
				System.err.println(oie.getMessage());
			}
		} while (repetir);

		System.out.println("A noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo,\n"
				+ "e sob a luz do crep�sculo voc� est� prestes a entrar na fase final da sua miss�o.\n"
				+ "Voc� olha para o portal � sua frente, e sabe que a partir desse ponto, sua vida mudar� para sempre.");

		System.out.println("Mem�rias do caminho percorrido para chegar at� aqui invadem sua mente.\n"
				+ "Voc� se lembra de todos os inimigos j� derrotados para alcan�ar o covil do l�der maligno.\n"
				+ "Olha para seu equipamento de combate, j� danificado e desgastado depois de tantas lutas.\n"
				+ "Voc� est� a um passo de encerrar para sempre esse mal.");

		System.out.println("Buscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.");

		// TODO: pedir ao jogador para escolher a motiva��o do seu personagem.
		// por que o personagem est� nessa miss�o de destruir os inimigos?
		// Vingan�a ou Gl�ria?
		System.out.println("Escolha uma motiva��o para o personagem: ");
		System.out.println("1 - Vingan�a");
		System.out.println("2 - Gl�ria");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		if (intOpcao == 1) {
			jogador.setMotivacao(Motivacao.VINGANCA);
		} else {
			jogador.setMotivacao(Motivacao.GLORIA);
		}

		// TODO: if (motiva��o do jogador == VINGAN�A)
		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Imagens daquela noite tr�gica invadem sua mente.\n"
					+ "Voc� nem precisa se esfor�ar para lembrar, pois essas mem�rias est�o sempre presentes,\n"
					+ "mesmo que de pano de fundo, quando voc� tem outros pensamentos em foco, elas nunca o deixaram.\n"
					+ "Elas s�o o combust�vel que te fizeram chegar at� aqui.\n"
					+ "E voc� sabe que n�o ir� desistir at� ter vingado a morte\n"
					+ "daqueles que foram - e pra sempre ser�o - sua fonte de amor e desejo de continuar vivo.\n"
					+ "O maldito l�der finalmente pagar� por tanto mal causado na vida de tantos\n"
					+ "(e principalmente na sua).");
		} else {
			// TODO else
			System.out.println(
					"Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os abertos,\n"
							+ "bardos criando can��es sobre seus feitos her�icos, nobres te presenteando com j�ias e diversas riquezas,\n"
							+ "taberneiros se recusando a cobrar por suas bebedeiras e comilan�as.\n"
							+ "Desde j�, voc� sente o amor do p�blico, te louvando a cada passo que d� pelas ruas,\n"
							+ "depois de destruir o vil�o que tanto assombrou a paz de todos.\n"
							+ "Por�m, voc� sabe que ainda falta o �ltimo ato dessa hist�ria.\n"
							+ "Voc� se concentra na miss�o.\n"
							+ "A gl�ria o aguarda, mas n�o antes da �ltima batalha.");
		}

		System.out.println("Inspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas,\n"
				+ "suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado.\n"
				+ "Voc� avan�a pelo portal.");

		System.out.println("A escurid�o te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas.\n"
				+ "� sua frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso.\n"
				+ "Voc� s� pode ir � frente, ou desistir.");

		// TODO: perguntar ao jogador se o personagem segue em frente ou desiste
		System.out.println("O que voc� faz?");
		System.out.println("1 - Segue em frente");
		System.out.println("2 - Desiste");
		
		intOpcao = fazLoopDecisao(2, sc);

		// TODO: if (desiste)
		if (intOpcao == 2) {
			System.out.println("O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio.\n"
					+ "Voc� se volta para a noite l� fora, e corre em dire��o � seguran�a.");
			// TODO: encerrar a execu��o do programa: System.exit(0);
			System.exit(0);
		}

		System.out.println("Voc� caminha, atento a todos os seus sentidos, por v�rios metros,\n"
				+ "at� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha,\n"
				+ "vindo de dentro de uma porta aberta.");

		System.out.println("Voc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
				+ "e pondera sobre como passar pela porta.");
		// TODO: perguntar ao jogador se deseja passar pela porta:
		// ANDANDO CUIDADOSAMENTE, CORRENDO ou SALTANDO.
		System.out.println("Como voc� decide passar pela porta?");
		System.out.println("1 - Andando cuidadosamente");
		System.out.println("2 - Correndo");
		System.out.println("3 - Saltando para dentro");

		intOpcao = fazLoopDecisao(3, sc);

		// TODO: if SALTANDO
		if (intOpcao == 3) {
			System.out.println(
					"Voc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
		} else if (intOpcao == 2) {
			// TODO: else if CORRENDO
			System.out.println("Voc� respira fundo e desata a correr em dire��o � sala.\n"
					+ "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
					+ "mas n�o d� muita import�ncia e segue para dentro da sala, olhando ao redor � procura de inimigos.\n"
					+ "N�o tem ningu�m, mas voc� ouve sons de flechas batendo na pedra atr�s de voc�,\n"
					+ "e quando se vira, v� v�rias flechas no ch�o.\n"
					+ "Espiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
					+ "mas por sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
		} else {
			// TODO: else
			System.out.println("Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz.\n"
					+ "Quando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta.\n"
					+ "Voc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor.\n"
					+ "Flechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala, por�m uma delas te acerta na perna.");
			// TODO: instanciar objeto Armadilha e invocar m�todo de causar dano.
			Armadilha armadilha = new Armadilha();
			armadilha.atacar(jogador);
		}
		
		System.out.println("Voc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o fechadas.\n"
				+ "A porta � sua frente � a maior das quatro, com inscri��es em seu entorno em uma l�ngua que voc� n�o sabe ler,\n"
				+ "mas reconhece como sendo a l�ngua antiga utilizada pelo inimigo.\n"
				+ "Voc� se aproxima da porta e percebe que ela est� trancada por duas fechaduras douradas,\n"
				+ "e voc� entende que precisar� primeiro derrotar o que estiver nas outras duas portas laterais,\n"
				+ "antes de conseguir enfrentar o l�der.");

		System.out.println("Voc� se dirige para a porta � direita.");

		System.out.println("Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada.\n"
				+ "Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, voc� se depara com uma sala espa�osa,\n"
				+ "com v�rios equipamentos de batalha pendurados nas paredes e dispostos em arm�rios e mesas.\n"
				+ "Voc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados\n"
				+ "utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o.\n"
				+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s.\n"
				+ "Ali, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, est� um dos capit�es do inimigo.\n"
				+ "Um orque horrendo, de armadura, capacete e espada em punho, em posi��o de combate.\n"
				+ "Ele avan�a em sua dire��o.");
		// TODO: instanciar objeto Armeiro
		Armeiro armeiro = new Armeiro();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, armeiro, false, sc);

		System.out.println("Ap�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados.\n"
				+ "Olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.");

		// TODO: perguntar ao jogador se ele quer ou n�o pegar as armaduras novas.
		System.out.println("Voc� deseja pegar e usar as armaduras do inimigo? 1- Sim, 2- N�o");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: Se escolher pegar
		if (intOpcao == 1) {
			System.out.println("Voc� resolve usar os equipamentos do inimigo contra ele, e trocar algumas pe�as suas,\n"
					+ "que estavam danificadas, pelas pe�as de armaduras existentes na sala.\n"
					+ "De armadura nova, voc� se sente mais protegido para os desafios � sua frente.");
			// TODO: deve ser acrescentado +5 pontos de defesa para o jogador.
			jogador.aumentaPontosDeDefesa(5);
		} else {
			// TODO: se n�o
			System.out.println("Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.");
		}
		
		System.out.println(
				"Em uma mesa, voc� encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do l�der inimigo.\n"
						+ "Voc� pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

		System.out.println("Voc� retorna � sala anterior e se dirige � porta da esquerda.\n"
				+ "Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada.\n"
				+ "Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, voc� se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
				+ "existem v�rios potes e garrafas de vidro com conte�dos misteriosos e de cores diversas,\n"
				+ "e voc� entende que o capit�o que vive ali, realiza experimentos com diversos ingredientes,\n"
				+ "criando po��es utilizadas pelos soldados para aterrorizar a regi�o.");
		System.out.println("No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo.\n"
				+ "Um orque horrendo, de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.");
		// TODO: instanciar objeto Alquimista
		Alquimista alquimista = new Alquimista();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, alquimista, false, sc);

		System.out.println(
				"Ap�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo.\n"
						+ "Em uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado,\n"
						+ "pega a garrafa e pondera se deve beber um gole.");
		// TODO: perguntar ao jogador se ele quer ou n�o beber.
		System.out.println("Voc� deseja beber da po��o do inimigo? 1- Sim, 2- N�o");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: Se escolher beber
		if (intOpcao == 1) {
			System.out.println("Voc� se sente revigorado para seguir adiante!");
			// TODO: pontos de sa�de do jogador devem ser restaurados 100%
			jogador.curaTodasAsFeridas(Jogador.SAUDE_MAXIMA_JOGADOR);
		} else {
			// TODO: se n�o
			System.out.println("Voc� fica receoso de beber algo produzido pelo inimigo.");
		}
		
		System.out.println("Ao lado da porta, voc� v� uma chave dourada em cima de uma mesa,\n"
				+ "e sabe que aquela chave abre a outra fechadura da porta do l�der inimigo.\n"
				+ "Voc� pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

		System.out.println("De volta � sala das portas, voc� se dirige � porta final.\n"
				+ "Coloca as chaves nas fechaduras, e a porta se abre.\n"
				+ "Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente,\n"
				+ "e voc� percebe que est� muito pr�ximo do seu objetivo final.\n"
				+ "Segura sua arma com mais firmeza, foca no combate que voc� sabe que ir� se seguir, e adentra a porta.");

		System.out.println(
				"L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados �s paredes.");

		System.out.println(
				"Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.");

		// TODO: jogador deve decidir se ataca ou espera
		System.out.println("Voc� ataca ou aguarda o inimigo atacar primeiro? 1- Atacar, 2- Aguardar");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: iniciar loop de combate, dependendo da resposta do jogador, ele ataca primeiro
		Lider lider = new Lider();
		combate(jogador, lider, intOpcao == 1, sc);

		System.out.println("Voc� conseguiu!");
		
		// TODO: exibir mensagem de vit�ria de acordo com a motiva��o do jogador
		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Voc� obteve sua vingan�a.\n"
					+ "Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade.\n"
					+ "Voc� se vingou, tudo que sempre quis, est� feito.\n"
					+ "Agora voc� pode seguir sua vida.");
		} else {
			System.out.println("O �xtase em que voc� se encontra n�o cabe dentro de si.\n"
					+ "Voc� se ajoelha e grita de alegria.\n"
					+ "A gl�ria o aguarda, voc� a conquistou.");
		}
		
		System.out.println("Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
				+ "e todos voc�s saem em dire��o � noite, retornando � cidade.\n"
				+ "Seu dever est� cumprido.");
	}

	private static int escolherOpcao(int qtdOpcoes, Scanner sc) throws NumberFormatException, OpcaoInvalidaException {
		String strOpcao = sc.nextLine();
		int intOpcao = Integer.parseInt(strOpcao);
		if (intOpcao < 1 || intOpcao > qtdOpcoes) {
			throw new OpcaoInvalidaException("Insira um n�mero v�lido entre 1-" + qtdOpcoes + ".");
		}

		return intOpcao;
	}
	
	private static int fazLoopDecisao(int qtdOpcoes, Scanner sc) {
		boolean repetir = true;
		int intOpcao = 0;
		do {
			try {
				intOpcao = escolherOpcao(qtdOpcoes, sc);
				repetir = false;
			} catch (NumberFormatException nfe) {
				System.err.println("Para escolher, digite apenas n�meros.");
			} catch (OpcaoInvalidaException oie) {
				System.err.println(oie.getMessage());
			}
		} while (repetir);
		
		return intOpcao;
	}

	private static void combate(Jogador jogador, Inimigo inimigo, boolean jogadorAtaca, Scanner sc) {
		do {
			if (jogadorAtaca) {
				System.out.println("� a sua vez de atacar! Digite 1 para atacar ou 2 para fugir:");
				int intOpcao = fazLoopDecisao(2, sc);
				
				if (intOpcao == 2) {
					System.exit(0);
				}
				
				jogador.atacar(inimigo);
			} else {
				inimigo.atacar(jogador);
			}
			
			jogadorAtaca = !jogadorAtaca;
		} while (!jogador.estaMorto() && !inimigo.estaMorto());
		
		if (jogador.estaMorto()) {
			System.out.println("Voc� n�o estava preparado para a for�a do inimigo.");
			switch (jogador.getMotivacao()) {
			case VINGANCA:
				System.out.println(
						"N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.");
				break;
			case GLORIA:
				if (jogador.getSexo() == 'F') {
					System.out.println("A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por sua pr�xima hero�na.");
				} else {
					System.out.println("A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por seu pr�ximo her�i.");
				}
				break;
			}
			System.exit(0);
		}
		
		if (inimigo.estaMorto()) {
			System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
		}
	}

}
