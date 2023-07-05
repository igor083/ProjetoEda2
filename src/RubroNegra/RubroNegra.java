package RubroNegra;



public class RubroNegra<T> {
	private NodeRubroNegra<T> raiz;
	private int numRotacoes;
    
    public int getNumRotacoes() {
        return numRotacoes;
    }
	private void recolorir(NodeRubroNegra<T> node){
		node.setCor(NodeRubroNegra.VERMELHO);
		node.getEsq().setCor(NodeRubroNegra.PRETO);
		node.getDir().setCor(NodeRubroNegra.PRETO);
	}
	
	public boolean isPreto(NodeRubroNegra<T> node){
		if(node == null){
			return true;
		}
		else if(node.isCor() == NodeRubroNegra.PRETO){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isVermelho(NodeRubroNegra<T> node){
		return !isPreto(node);
	}
	
	public void add(int chave){
		raiz = add(raiz, chave);
		raiz.setCor(NodeRubroNegra.PRETO);
	}

	private NodeRubroNegra<T> add(NodeRubroNegra<T> raiz, int chave){
		if(raiz == null){
			NodeRubroNegra<T> node = new NodeRubroNegra<T>(chave);
			return node;
		}
		
		if(chave < raiz.getChave()){
			raiz.setEsq(add(raiz.getEsq(), chave));
		}
		else if(chave > raiz.getChave()){
			raiz.setDir(add(raiz.getDir(), chave));
		}
		
		if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			recolorir(raiz);
		}
		else if(!isPreto(raiz) && !isPreto(raiz.getDir())){
			raiz = rotacaoEsquerda(raiz);
		}
		else if(isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(NodeRubroNegra.PRETO);
			raiz.getDir().setCor(NodeRubroNegra.VERMELHO);
		}
		else if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getDir().getDir())){
			recolorir(raiz);
		}
		else if(!isPreto(raiz) && !isPreto(raiz.getEsq())){
			raiz = rotacaoDireita(raiz);
		}
		else if(isPreto(raiz.getEsq()) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())){
			raiz = rotacaoEsquerda(raiz);
			raiz.setCor(NodeRubroNegra.PRETO);
			raiz.getEsq().setCor(NodeRubroNegra.VERMELHO);
		}
		
		return raiz;
	}

	private NodeRubroNegra<T> rotacaoDireita(NodeRubroNegra<T> raiz){
	    NodeRubroNegra<T> aux = raiz.getEsq();
	    raiz.setEsq(raiz.getEsq().getDir());
	    aux.setDir(raiz);
	    numRotacoes++; // Incrementa o contador de rotações
	    return aux;
	}

	private NodeRubroNegra<T> rotacaoEsquerda(NodeRubroNegra<T> raiz) {
	    NodeRubroNegra<T> aux = raiz.getDir();
	    raiz.setDir(raiz.getDir().getEsq());
	    aux.setEsq(raiz);
	    numRotacoes++; // Incrementa o contador de rotações
	    return aux;
	}
}