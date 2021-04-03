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
		System.out.println("Seja bem vindo(a) à BATALHA FINAL!");
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
				System.out.println("Seu personagem é do sexo Masculino ou Feminino? (M/F):");
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
				System.out.println("Digite apenas o número correspondente à classe escolhida:");

				intOpcao = escolherOpcao(4, sc);

				// TODO: solicitar ao jogador qual arma o personagem vai usar,
				// dentre as opções disponíveis para a classe selecionada.
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
				System.out.println("Digite apenas o número correspondente à arma escolhida:");

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
				System.err.println("Para escolha da classe ou arma, digite apenas números.");
			} catch (OpcaoInvalidaException oie) {
				System.err.println(oie.getMessage());
			}
		} while (repetir);

		System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
				+ "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
				+ "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

		System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
				+ "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
				+ "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
				+ "Você está a um passo de encerrar para sempre esse mal.");

		System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

		// TODO: pedir ao jogador para escolher a motivação do seu personagem.
		// por que o personagem está nessa missão de destruir os inimigos?
		// Vingança ou Glória?
		System.out.println("Escolha uma motivação para o personagem: ");
		System.out.println("1 - Vingança");
		System.out.println("2 - Glória");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		if (intOpcao == 1) {
			jogador.setMotivacao(Motivacao.VINGANCA);
		} else {
			jogador.setMotivacao(Motivacao.GLORIA);
		}

		// TODO: if (motivação do jogador == VINGANÇA)
		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
					+ "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
					+ "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
					+ "Elas são o combustível que te fizeram chegar até aqui.\n"
					+ "E você sabe que não irá desistir até ter vingado a morte\n"
					+ "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
					+ "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
					+ "(e principalmente na sua).");
		} else {
			// TODO else
			System.out.println(
					"Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
							+ "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
							+ "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
							+ "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
							+ "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
							+ "Porém, você sabe que ainda falta o último ato dessa história.\n"
							+ "Você se concentra na missão.\n"
							+ "A glória o aguarda, mas não antes da última batalha.");
		}

		System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
				+ "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
				+ "Você avança pelo portal.");

		System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
				+ "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
				+ "Você só pode ir à frente, ou desistir.");

		// TODO: perguntar ao jogador se o personagem segue em frente ou desiste
		System.out.println("O que você faz?");
		System.out.println("1 - Segue em frente");
		System.out.println("2 - Desiste");
		
		intOpcao = fazLoopDecisao(2, sc);

		// TODO: if (desiste)
		if (intOpcao == 2) {
			System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
					+ "Você se volta para a noite lá fora, e corre em direção à segurança.");
			// TODO: encerrar a execução do programa: System.exit(0);
			System.exit(0);
		}

		System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
				+ "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
				+ "vindo de dentro de uma porta aberta.");

		System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
				+ "e pondera sobre como passar pela porta.");
		// TODO: perguntar ao jogador se deseja passar pela porta:
		// ANDANDO CUIDADOSAMENTE, CORRENDO ou SALTANDO.
		System.out.println("Como você decide passar pela porta?");
		System.out.println("1 - Andando cuidadosamente");
		System.out.println("2 - Correndo");
		System.out.println("3 - Saltando para dentro");

		intOpcao = fazLoopDecisao(3, sc);

		// TODO: if SALTANDO
		if (intOpcao == 3) {
			System.out.println(
					"Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
		} else if (intOpcao == 2) {
			// TODO: else if CORRENDO
			System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
					+ "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
					+ "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
					+ "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
					+ "e quando se vira, vê várias flechas no chão.\n"
					+ "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
					+ "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
		} else {
			// TODO: else
			System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
					+ "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
					+ "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
					+ "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
			// TODO: instanciar objeto Armadilha e invocar método de causar dano.
			Armadilha armadilha = new Armadilha();
			armadilha.atacar(jogador);
		}
		
		System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
				+ "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
				+ "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
				+ "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
				+ "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
				+ "antes de conseguir enfrentar o líder.");

		System.out.println("Você se dirige para a porta à direita.");

		System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
				+ "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, você se depara com uma sala espaçosa,\n"
				+ "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
				+ "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
				+ "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
				+ "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
				+ "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
				+ "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
				+ "Ele avança em sua direção.");
		// TODO: instanciar objeto Armeiro
		Armeiro armeiro = new Armeiro();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, armeiro, false, sc);

		System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
				+ "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

		// TODO: perguntar ao jogador se ele quer ou não pegar as armaduras novas.
		System.out.println("Você deseja pegar e usar as armaduras do inimigo? 1- Sim, 2- Não");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: Se escolher pegar
		if (intOpcao == 1) {
			System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
					+ "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
					+ "De armadura nova, você se sente mais protegido para os desafios à sua frente.");
			// TODO: deve ser acrescentado +5 pontos de defesa para o jogador.
			jogador.aumentaPontosDeDefesa(5);
		} else {
			// TODO: se não
			System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
		}
		
		System.out.println(
				"Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
						+ "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

		System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
				+ "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
				+ "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
				+ "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
				+ "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
				+ "criando poções utilizadas pelos soldados para aterrorizar a região.");
		System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
				+ "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");
		// TODO: instanciar objeto Alquimista
		Alquimista alquimista = new Alquimista();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, alquimista, false, sc);

		System.out.println(
				"Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
						+ "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
						+ "pega a garrafa e pondera se deve beber um gole.");
		// TODO: perguntar ao jogador se ele quer ou não beber.
		System.out.println("Você deseja beber da poção do inimigo? 1- Sim, 2- Não");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: Se escolher beber
		if (intOpcao == 1) {
			System.out.println("Você se sente revigorado para seguir adiante!");
			// TODO: pontos de saúde do jogador devem ser restaurados 100%
			jogador.curaTodasAsFeridas(Jogador.SAUDE_MAXIMA_JOGADOR);
		} else {
			// TODO: se não
			System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
		}
		
		System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
				+ "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
				+ "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

		System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
				+ "Coloca as chaves nas fechaduras, e a porta se abre.\n"
				+ "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
				+ "e você percebe que está muito próximo do seu objetivo final.\n"
				+ "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");

		System.out.println(
				"Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");

		System.out.println(
				"Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");

		// TODO: jogador deve decidir se ataca ou espera
		System.out.println("Você ataca ou aguarda o inimigo atacar primeiro? 1- Atacar, 2- Aguardar");
		
		intOpcao = fazLoopDecisao(2, sc);
		
		// TODO: iniciar loop de combate, dependendo da resposta do jogador, ele ataca primeiro
		Lider lider = new Lider();
		combate(jogador, lider, intOpcao == 1, sc);

		System.out.println("Você conseguiu!");
		
		// TODO: exibir mensagem de vitória de acordo com a motivação do jogador
		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Você obteve sua vingança.\n"
					+ "Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade.\n"
					+ "Você se vingou, tudo que sempre quis, está feito.\n"
					+ "Agora você pode seguir sua vida.");
		} else {
			System.out.println("O êxtase em que você se encontra não cabe dentro de si.\n"
					+ "Você se ajoelha e grita de alegria.\n"
					+ "A glória o aguarda, você a conquistou.");
		}
		
		System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
				+ "e todos vocês saem em direção à noite, retornando à cidade.\n"
				+ "Seu dever está cumprido.");
	}

	private static int escolherOpcao(int qtdOpcoes, Scanner sc) throws NumberFormatException, OpcaoInvalidaException {
		String strOpcao = sc.nextLine();
		int intOpcao = Integer.parseInt(strOpcao);
		if (intOpcao < 1 || intOpcao > qtdOpcoes) {
			throw new OpcaoInvalidaException("Insira um número válido entre 1-" + qtdOpcoes + ".");
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
				System.err.println("Para escolher, digite apenas números.");
			} catch (OpcaoInvalidaException oie) {
				System.err.println(oie.getMessage());
			}
		} while (repetir);
		
		return intOpcao;
	}

	private static void combate(Jogador jogador, Inimigo inimigo, boolean jogadorAtaca, Scanner sc) {
		do {
			if (jogadorAtaca) {
				System.out.println("É a sua vez de atacar! Digite 1 para atacar ou 2 para fugir:");
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
			System.out.println("Você não estava preparado para a força do inimigo.");
			switch (jogador.getMotivacao()) {
			case VINGANCA:
				System.out.println(
						"Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
				break;
			case GLORIA:
				if (jogador.getSexo() == 'F') {
					System.out.println("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroína.");
				} else {
					System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
				}
				break;
			}
			System.exit(0);
		}
		
		if (inimigo.estaMorto()) {
			System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
		}
	}

}
