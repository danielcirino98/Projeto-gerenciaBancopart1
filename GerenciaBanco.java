/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/* Relatório da Aplicação de Gerenciamento Bancário:

Esta aplicação em Java oferece um sistema simples para gerenciamento bancário, permitindo que os usuários realizem operações como depósito, saque e consulta de saldo. Abaixo está uma análise detalhada do código:

1. Classes Principais:
   - `GerenciaBanco`: Esta é a classe principal que contém o método `main`. Ela gerencia a interação com o usuário, exibindo um menu inicial e permitindo que o usuário escolha entre diferentes opções de operações bancárias.
   
   - `Conta`: Esta classe representa uma conta bancária. Ela possui métodos para depositar, sacar e obter o saldo da conta.
   
   - `Cliente`: Esta classe representa um cliente do banco, contendo informações como nome, sobrenome e CPF. Também possui métodos para acessar e modificar essas informações.

2. Funcionalidades Principais:
   - Menu Inicial (`MenuInicial()`): Este método exibe um menu para o usuário, apresentando as opções disponíveis de operações bancárias.
   
   - Cadastro de Cliente (`cadastrarCliente()`): Este método permite que o usuário insira seu nome, sobrenome e CPF para criar um perfil de cliente.
   
   - Operações Bancárias no Método `main`: O método `main` gerencia as operações bancárias selecionadas pelo usuário. Ele executa um loop enquanto o usuário não escolher a opção de sair (opção 4), permitindo que o usuário deposite, saque ou verifique o saldo da conta.

3. Controle de Entrada de Dados:
   - O código utiliza um objeto `Scanner` para capturar a entrada do usuário.
   - A classe `Locale` é utilizada para garantir que o código interprete corretamente números decimais com o formato americano (ponto decimal em vez de vírgula).

*4. Lógica de Operações Bancárias:
   - Para depósitos, o código verifica se o valor inserido é válido (maior que zero) antes de atualizar o saldo.
  - Para saques, o código verifica se há saldo suficiente antes de permitir a operação.

5. Melhorias Potenciais:
   - Implementar validações adicionais, como limites de saque e depósito, e tratamento de erros para entradas inválidas.
   - Adicionar funcionalidades como transferências entre contas e histórico de transações. */




package com.mycompany.gerenciabanco;
import java.util.Scanner;
import java.util.Locale;






import java.util.Scanner;
import java.util.Locale;

public class GerenciaBanco {
    static Scanner scanner = new Scanner(System.in);

    public static void MenuInicial() {
        System.out.println("_________________________");
        System.out.println("Digite a opção desejada");
        System.out.println("1-Depósito");
        System.out.println("2-Saque");
        System.out.println("3-Exibir Saldo");
        System.out.println("4-Sair");
        System.out.println("________________________");
    }

    public static void main(String[] args) {
        scanner.useLocale(Locale.US);
        double saldo = 0.0;
        Cliente cliente = cadastrarCliente();

        MenuInicial();
        int opcao = scanner.nextInt();
        while (opcao != 4) {
            if (opcao == 1) {
                System.out.println("Digite o valor do depósito");
                double valorDeposito = scanner.nextDouble();
                if (valorDeposito < 0.0) {
                    System.out.println("Valor Inválido");
                } else {
                    saldo += valorDeposito;
                }
            } else if (opcao == 2) {
                System.out.println("Digite o valor de saque");
                double valorSaque = scanner.nextDouble();
                if (saldo - valorSaque < 0.0) {
                    System.out.println("Valor Inválido");
                } else {
                    saldo -= valorSaque;
                }
            } else if (opcao == 3) {
                System.out.println("Seu saldo é: " + saldo);
            }
            MenuInicial();
            opcao = scanner.nextInt();
        }
    }

    public static Cliente cadastrarCliente() {
        System.out.println("Digite seu nome:");
        String nome = scanner.next();
        System.out.println("Digite seu sobrenome:");
        String sobrenome = scanner.next();
        System.out.println("Digite seu CPF:");
        String cpf = scanner.next();

        return new Cliente(nome, sobrenome, cpf);
    }
}

class Conta {
    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public boolean depositar(double valorDeposito) {
        if (valorDeposito < 0.0) {
            return false;
        }
        this.saldo += valorDeposito;
        return true;
    }

    public boolean sacar(double valorSaque) {
        if (saldo - valorSaque < 0.0) {
            return false;
        }
        saldo -= valorSaque;
        return true;
    }

    public double getSaldo() {
        return this.saldo;
    }
}

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}



