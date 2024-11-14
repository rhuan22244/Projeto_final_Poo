public class ArvoreBuscaBinaria {
    private No raiz;

    public ArvoreBuscaBinaria() {
        raiz = null;
    }

    public void inserir (int valor){
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No raiz, int valor){
        if(raiz == null){
            raiz = new No(valor); //atribui um novo nó oara a raiz
            return raiz;
        }

        if  (valor < raiz.valor){
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor){
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }

        return raiz;

    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz,valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) return false;

        if(no.valor == valor){
            return true;
        }

        if (valor < no.valor){
            return buscarRecursivo(no.esquerda, valor);
        }else{
            return buscarRecursivo(no.direita, valor);
        }
    }

    private No buscarMenor(No raiz){
        while (raiz.esquerda != null){
            raiz = raiz.esquerda;
        }
        return raiz;
    }

    public void imprimirEmOrdem(){
        System.out.print("Em ordem: ");
        imprimirEmOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRec(No no){
        if (no != null){
            imprimirEmOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRec(no.direita);
        }
    }

    public void remover(int valor){
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No raiz, int valor){
        if (raiz == null) return null;

        if (valor < raiz.valor){
            raiz.esquerda = removerRecursivo(raiz.esquerda, valor);
        }else if (valor > raiz.valor){
            raiz.direita = removerRecursivo(raiz.direita, valor);
        }else{
            //Caso 1: Nó folha - sem folha
            if(raiz.direita == null && raiz.esquerda == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            else if(raiz.esquerda == null) {
                return raiz.direita;
            }else if (raiz.direita == null) {
                return raiz.esquerda;
            }
            // Caso 3: Nó com dois filhos
            else{
                No sucessor = buscarMenor(raiz.direita); // buscar o sucessor
                raiz.valor = sucessor.valor; //Substitiu pelo sucessor
                raiz.direita = removerRecursivo(raiz.direita, sucessor.valor);
            }
        }

        return null;
    }
}
