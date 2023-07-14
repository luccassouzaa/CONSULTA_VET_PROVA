package veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Consulta> consultas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        //sempre re-executar o codigo perguntando qual sera a ação do sistema
        while (executando) {
            System.out.println("----- Sistema de Agendamento de Consultas -----");
            System.out.println("1. Adicionar Consulta");
            System.out.println("2. Visualizar Consultas");
            System.out.println("3. Editar Consulta");
            System.out.println("4. Deletar Consulta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            //switch case para decisao do usuario
            switch (opcao) {
                case 1:
                    adicionarConsulta();
                    break;
                case 2:
                    visualizarConsultas();
                    break;
                case 3:
                    editarConsulta();
                    break;
                case 4:
                    deletarConsulta();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    //metodo para adicionar a consulta
    private static void adicionarConsulta() {
        System.out.print("Digite o nome do animal: ");
        String nomeAnimal = scanner.next();
        System.out.print("Digite o nome do dono: ");
        String nomeDono = scanner.next();
        System.out.print("Digite a data e hora da consulta: ");
        String dataHora = scanner.next();

        Consulta consulta = new Consulta(nomeAnimal, nomeDono, dataHora);
        consultas.add(consulta);

        System.out.println("Consulta adicionada com sucesso!");
    }

    //metodo para visualizar a consulta
    private static void visualizarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas agendadas.");
        } else {
            System.out.println("----- Consultas Agendadas -----");
            for (Consulta consulta : consultas) {
                System.out.println("Animal: " + consulta.getNomeAnimal());
                System.out.println("Dono: " + consulta.getNomeDono());
                System.out.println("Data e Hora: " + consulta.getDataHora());
                System.out.println("------------------------");
            }
        }
    }

    //metodo para editar a consulta
    private static void editarConsulta() {
        System.out.print("Digite o nome do animal da consulta a ser editada: ");
        String nomeAnimal = scanner.next();

        Consulta consultaEncontrada = null;
        for (Consulta consulta : consultas) {
            if (consulta.getNomeAnimal().equalsIgnoreCase(nomeAnimal)) {
                consultaEncontrada = consulta;
                break;
            }
        }

        //condição case nao haja o nome encontrado e decisao para editar consulta selecionada
        if (consultaEncontrada == null) {
            System.out.println("Consulta não encontrada.");
        } else {
            System.out.print("Digite o novo nome do animal: ");
            String novoNomeAnimal = scanner.next();
            System.out.print("Digite o novo nome do dono: ");
            String novoNomeDono = scanner.next();
            System.out.print("Digite a nova data e hora da consulta: ");
            String novaDataHora = scanner.next();

            consultaEncontrada.setNomeAnimal(novoNomeAnimal);
            consultaEncontrada.setNomeDono(novoNomeDono);
            consultaEncontrada.setDataHora(novaDataHora);

            System.out.println("Consulta editada com sucesso!");
        }
    }

    //metodo para deletar a consulta
    private static void deletarConsulta() {
        System.out.print("Digite o nome do animal da consulta a ser deletada: ");
        String nomeAnimal = scanner.next();

        Consulta consultaEncontrada = null;
        for (Consulta consulta : consultas) {
            if (consulta.getNomeAnimal().equalsIgnoreCase(nomeAnimal)) {
                consultaEncontrada = consulta;
                break;
            }
        }

        //condição caso nao haja consultar para ser deletadas.
        if (consultaEncontrada == null) {
            System.out.println("Consulta não encontrada.");
        } else {
            consultas.remove(consultaEncontrada);
            System.out.println("Consulta deletada com sucesso!");
        }
    }
}
