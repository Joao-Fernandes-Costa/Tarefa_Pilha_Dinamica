import java.util.Scanner;
class CelulaPilha {
    private char dado;
    private CelulaPilha anterior;
    public CelulaPilha() {
    }
    public CelulaPilha(char dado, CelulaPilha anterior) {
        this.dado = dado;
        this.anterior = anterior;
    }
    public char getDado() {
        return this.dado;
    }
    public void setDado(char dado) {
        this.dado = dado;
    }
    public CelulaPilha getAnterior() {
        return this.anterior;
    }
    public void setAnterior(CelulaPilha anterior) {
        this.anterior = anterior;
    }
}
class StackDinamica {
    private CelulaPilha top;
    public StackDinamica() {
        this.top = null;
    }
    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        } else {
            return false;
        }
    }
    public void push(char dado) {
        CelulaPilha novaCelula = new CelulaPilha();
        novaCelula.setDado(dado);
        novaCelula.setAnterior(this.top);
        this.top = novaCelula;
    }
    public char pop() {
        if (!isEmpty()) {
            char dadoRemovido = this.top.getDado();
            this.top = this.top.getAnterior();
            return dadoRemovido;
        } else {
            return '\0';
        }
    }
}
public class tarefa_pilha_dinamica{
    public static boolean verificar(String expressao) {
        StackDinamica pilha = new StackDinamica();
        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pilha.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (pilha.isEmpty()) {
                    return false;
                }
                char topo = pilha.pop();
                if (c == ')' && topo != '(') {
                    return false;
                }
                if (c == '}' && topo != '{') {
                    return false;
                }
                if (c == ']' && topo != '[') {
                    return false;
                }
            }
        }
        return pilha.isEmpty(); //
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Verificador de Expressões (Baseado na Aula 15) ---");
        System.out.println("Digite uma expressão (ou 'sair' para terminar):");
        while (true) {
            System.out.print("\nExpressão: ");
            String linha = scanner.nextLine();
            if (linha.equalsIgnoreCase("sair")) {
                break;
            }
            if (verificar(linha)) {
                System.out.println("Resultado: Correto");
            } else {
                System.out.println("Resultado: Incorreto");
            }
        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}