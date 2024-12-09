package br.com.catolica.RadioFM.Main;
import br.com.catolica.RadioFM.Models.*;
import br.com.catolica.RadioFM.Enum.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacao estacao = new Estacao("Rádio Top", "100.1 FM");

        Programa programa1 = new Programa("Show de Música", "10:00", GeneroProgramacao.MUSICA, "Músicas de diversos gêneros");
        Musica musica1 = new Musica("Imagine", "John Lennon", 4, GeneroMusica.ROCK);
        programa1.adicionarMusica(musica1);

        Ouvinte ouvinte1 = new Ouvinte("Carlos", 30, CargoPessoa.OUVINTE);
        Apresentador apresentador1 = new Apresentador("Joana", 25, CargoPessoa.APRESENTADOR);
        Administrador admin1 = new Administrador("Ana", 35, CargoPessoa.ADMINISTRADOR, estacao);

        estacao.adicionarPrograma(programa1);
        estacao.adicionarOuvinte(ouvinte1);

        ouvinte1.favoritarPrograma(programa1);
        apresentador1.apresentarPrograma(programa1);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("[1] Gerenciar Programas");
                System.out.println("[2] Gerenciar Ouvintes");
                System.out.println("[3] Alterar Estação");
                System.out.println("[4] Controlar Transmissão");
                System.out.println("[5] Interagir com Ouvintes");
                System.out.println("[6] Listar Programas");
                System.out.println("[7] Exibir Informações do Programa");
                System.out.println("[8] Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("\n[1] Adicionar Programa");
                        System.out.println("[2] Remover Programa");
                        System.out.print("Escolha uma opção: ");
                        int subOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (subOpcao == 1) {
                            System.out.print("Digite o nome do programa: ");
                            String nomePrograma = scanner.nextLine();
                            System.out.print("Digite o horário: ");
                            String horario = scanner.nextLine();
                            Programa programa = new Programa(nomePrograma, horario, GeneroProgramacao.MUSICA, "Descrição");
                            admin1.adicionarPrograma(programa);
                        } else if (subOpcao == 2) {
                            System.out.print("Digite o nome do programa a ser removido: ");
                            String nomeRemover = scanner.nextLine();
                            admin1.removerPrograma(nomeRemover);
                        }
                        break;
                    case 2:
                        System.out.println("\n[1] Adicionar Ouvinte");
                        System.out.println("[2] Remover Ouvinte");
                        System.out.print("Escolha uma opção: ");
                        int subOpcaoOuvinte = scanner.nextInt();
                        scanner.nextLine();
                        if (subOpcaoOuvinte == 1) {
                            System.out.print("Digite o nome do ouvinte: ");
                            String nomeOuvinte = scanner.nextLine();
                            Ouvinte ouvinte = new Ouvinte(nomeOuvinte, 25, CargoPessoa.OUVINTE);
                            admin1.adicionarOuvinte(ouvinte);
                        } else if (subOpcaoOuvinte == 2) {
                            System.out.print("Digite o nome do ouvinte a ser removido: ");
                            String nomeRemoverOuvinte = scanner.nextLine();
                            Ouvinte ouvinteRemover = new Ouvinte(nomeRemoverOuvinte, 25, CargoPessoa.OUVINTE);
                            admin1.removerOuvinte(ouvinteRemover);
                        }
                        break;
                    case 3:
                        System.out.print("Digite o novo nome da estação: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite a nova frequência: ");
                        String novaFrequencia = scanner.nextLine();
                        admin1.configurarEstacao(novoNome, novaFrequencia);
                        break;
                    case 4:
                        System.out.println("\n[1] Iniciar Transmissão");
                        System.out.println("[2] Pausar Transmissão");
                        System.out.println("[3] Interromper Transmissão");
                        System.out.print("Escolha uma opção: ");
                        int subOpcaoTransmissao = scanner.nextInt();
                        scanner.nextLine();
                        if (subOpcaoTransmissao == 1) {
                            admin1.iniciarTransmissao();
                        } else if (subOpcaoTransmissao == 2) {
                            admin1.pausarTransmissao();
                        } else if (subOpcaoTransmissao == 3) {
                            admin1.interromperTransmissao();
                        }
                        break;
                    case 5:
                        System.out.println("\nDigite o nome do ouvinte para interagir: ");
                        String nomeOuvinteInteracao = scanner.nextLine();

                        if (nomeOuvinteInteracao.equalsIgnoreCase(ouvinte1.getNome())) {
                            System.out.print("Digite a mensagem para enviar: ");
                            String mensagem = scanner.nextLine();
                            apresentador1.enviarMensagem(mensagem);
                        } else {
                            System.out.println("Ouvinte não encontrado!");
                        }
                        break;

                    case 6:
                        admin1.listarProgramas();
                        break;

                    case 7:
                        apresentador1.exibirInformacoesDoPrograma();
                        break;

                    case 8:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Por favor, insira um número válido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 8);

        scanner.close();
    }
}
