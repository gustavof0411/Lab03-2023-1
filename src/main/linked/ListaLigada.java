package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar {

    private No cabeca;

    public ListaLigada() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        No procura = this.cabeca;
        while (procura != null) {
            if (procura.getValor() == valor) {
                return true;
            }
            procura = procura.getProximo();
        }
        return false;
    }
    

    @Override
    public int buscaIndice(int valor) {
        if (this.cabeca != null) {
            int indicesProcurados = 0;
            No procura = this.cabeca;
    
            while (procura != null) {
                if (indicesProcurados == valor) {
                    return procura.getValor();
                }
                procura = procura.getProximo();
                indicesProcurados++;
            }
        }
        return 0;
    }
    

    @Override
    public int minimo() {
        if (this.cabeca != null) {
            No pesquisa = this.cabeca;
            int minimo = pesquisa.getValor();
            while (pesquisa!= null) {
                if (pesquisa.getValor() < minimo) {
                    minimo = pesquisa.getValor();
                }
                pesquisa = pesquisa.getProximo();            
            }
            return minimo;
        }
            return -1;
    }

    @Override
    public int maximo() {
        if (this.cabeca != null) {
            No pesquisa = this.cabeca;
            int maximo = pesquisa.getValor();
            while (pesquisa!= null) {
                if (pesquisa.getValor() > maximo) {
                    maximo = pesquisa.getValor();
                }
                pesquisa = pesquisa.getProximo();
            }
            return maximo;
        }
            return -1;
    }

    @Override
    public int predecessor(int valor) {
        if (this.cabeca == null) {
            return -1;
        }
    
        No procura = this.cabeca;
        No predecessor = null;
    
        while (procura != null && procura.getValor() != valor) {
            predecessor = procura;
            procura = procura.getProximo();
        }
    
        if (procura == null) {
            return -1;
        }
        if (predecessor == null) {
            return -1;
        }
    
        return predecessor.getValor();
    }

    @Override
    public int sucessor(int valor) {
        if (this.cabeca == null) {
            return -1;
        }
    
        No procura = this.cabeca;
    
        while (procura != null && procura.getValor() != valor) {
            procura = procura.getProximo();
        }
    
        if (procura == null || procura.getProximo() == null) {
            return -1; 
        }
    
        return procura.getProximo().getValor();
    }
    

    @Override
    public void insereElemento(int valor) {
                if (this.cabeca != null) {
            No pesquisa = this.cabeca;
                while (pesquisa.getProximo() != null) {
                    pesquisa = pesquisa.getProximo();
                }
                pesquisa.setProximo(new No(valor));
        
        } else {
            this.cabeca = new No(valor);
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No novo = new No(valor);
    
        if (buscaIndice == 0) {
            novo.setProximo(this.cabeca);
            this.cabeca = novo;
            return;
        }
    
        No atual = this.cabeca;
        int contador = 0;
    
        while (atual != null && contador < buscaIndice - 1) {
            atual = atual.getProximo();
            contador++;
        }
    
        if (atual == null) {
            return;
        }
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
    }
    
    
    
    

    @Override
    public void insereInicio(int valor) {
        if (cabeca == null) {
            this.cabeca = new No(valor);
        } else {
            No no = new No(valor);
            no.setProximo(this.cabeca);
            this.cabeca = no;
        }
    }

    @Override
    public void insereFim(int valor) {
        if (this.cabeca != null) {
            No pesquisa = this.cabeca;
                while (pesquisa.getProximo() != null) {
                    pesquisa = pesquisa.getProximo();
                }
                pesquisa.setProximo(new No(valor));
        
        } else {
            this.cabeca = new No(valor);
        }
    }

    @Override
    public void remove(int valor) {
            if (this.cabeca != null) {
                No pesquisa = this.cabeca;
                while (pesquisa != null && pesquisa.getProximo() != null) {
                    if (pesquisa.getProximo().getValor() == valor) {
                        if (pesquisa.getProximo().getProximo() == null) {
                            pesquisa.setProximo(null);
                        } else {
                            pesquisa.setProximo(pesquisa.getProximo().getProximo());
                        }
                    }
                    pesquisa = pesquisa.getProximo();
                }
            }
        }
        

    @Override
    public void removeIndice(int indice) {
        if (this.cabeca == null || indice < 0) {
            return;
        }
    
        if (indice == 0) {
            this.cabeca = this.cabeca.getProximo();
            return;
        }
    
        No procura = this.cabeca;
        No anterior = null;
        int contador = 0;
    
        while (procura != null && contador < indice) {
            anterior = procura;
            procura = procura.getProximo();
            contador++;
        }
    
        if (procura == null) {
            return;
        }
        anterior.setProximo(procura.getProximo());
    }
    

    @Override
    public void removeInicio() {
        if (this.cabeca != null) {
            if (this.cabeca.getProximo() != null) {
                this.cabeca = cabeca.getProximo();
            } else {
                this.cabeca =null;
            }
        }
    }

    @Override
    public void removeFim() {
        if (this.cabeca != null) {
            if (this.cabeca.getProximo() == null) {
                this.cabeca = null;
            } else {
                No pesquisa = null;
                No procura = this.cabeca;
                while (procura.getProximo() != null) {
                    pesquisa = procura;
                    procura = procura.getProximo();
                }
                pesquisa.setProximo(null);
            }
        }
    }
    
}
