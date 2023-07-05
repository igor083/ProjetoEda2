package AVL;

public class ArvoreAVL<T> {
	private NodeAVL<T> raiz = null;
	private int numRotacoes = 0;
	
	
	public void inserir(int chave){
		this.raiz = inserir(this.raiz, chave);
	}
	
	private int altura(NodeAVL<T> raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	private NodeAVL<T> inserir(NodeAVL<T> raiz, int chave){
        if(raiz == null){
            NodeAVL<T> node = new NodeAVL<T>(chave);
            return node;
        }
        else if(raiz.getChave() > chave){
            raiz.setEsq(inserir(raiz.getEsq(), chave));
            
            if(altura(raiz.getEsq()) - altura(raiz.getDir()) == 2){
                if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir())){
                    raiz = rotacaoDireita(raiz);
                    numRotacoes++;
                }
                else{
                    raiz = rotacaoDuplaDireita(raiz);
                    numRotacoes += 2;
                }   
            }
        }
        else if(raiz.getChave() < chave){
            raiz.setDir(inserir(raiz.getDir(), chave));
            
            if(altura(raiz.getDir()) - altura(raiz.getEsq()) == 2){
                if(altura(raiz.getDir().getDir()) > altura(raiz.getDir().getEsq())){
                    raiz = rotacaoEsquerda(raiz);
                    numRotacoes++;
                }
                else{
                    raiz = rotacaoDuplaEsquerda(raiz);
                    numRotacoes += 2;
                }
            }
        }
        
        raiz.setAltura(((altura(raiz.getDir()) > altura(raiz.getDir())) ? altura(raiz.getDir()) : (altura(raiz.getEsq()))) + 1);
        
        return raiz;
    }
	private NodeAVL<T> rotacaoEsquerda(NodeAVL<T> node) {
		// TODO Auto-generated method stub
		NodeAVL<T> aux = node.getDir();
		
		node.setDir(node.getDir().getEsq());
		aux.setEsq(node);
		node.setAltura((altura(node.getDir()) > altura(node.getDir()) ? altura(node.getDir()) : (altura(node.getEsq())) + 1));
		aux.setAltura((altura(aux.getDir()) > altura(aux.getDir()) ? altura(aux.getDir()) : (altura(aux.getEsq())) + 1));
		
		return aux;
	}
	
	private NodeAVL<T> rotacaoDireita(NodeAVL<T> node) {
		// TODO Auto-generated method stub
		NodeAVL<T> aux = node.getEsq();
		
		node.setEsq(node.getEsq().getDir());
		aux.setDir(node);
		node.setAltura((altura(node.getDir()) > altura(node.getDir()) ? altura(node.getDir()) : (altura(node.getEsq())) + 1));
		aux.setAltura((altura(aux.getDir()) > altura(aux.getDir()) ? altura(aux.getDir()) : (altura(aux.getEsq())) + 1));
		
		return aux;
	}
	
	private NodeAVL<T> rotacaoDuplaDireita(NodeAVL<T> node) {
		// TODO Auto-generated method stub
		node.setEsq(rotacaoDuplaEsquerda(node));
		node = rotacaoDireita(node);
		
		return node;
	}
	
	private NodeAVL<T> rotacaoDuplaEsquerda(NodeAVL<T> node) {
		// TODO Auto-generated method stub
		node.setDir(rotacaoDireita(node));
		node = rotacaoDuplaEsquerda(node);
		
		return node;
	}
	public int getRotacoes() {
		return numRotacoes;
	}
}
