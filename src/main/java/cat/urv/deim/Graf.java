package cat.urv.deim;

import cat.urv.deim.exceptions.VertexNoTrobat;
import cat.urv.deim.exceptions.ArestaNoTrobada;
import cat.urv.deim.exceptions.ElementNoTrobat;

public class Graf<K extends Comparable<K> , V extends Comparable<V>, E extends Comparable<E>> implements IGraf<K, V, E> {

    private HashMapIndirecte<K, V> taulaHash;
    private LlistaGenerica<Aresta<K, E>> llistaArestes;

    public Graf(int mida) {
        taulaHash = new HashMapIndirecte<>(mida);
        llistaArestes = new LlistaNoOrdenada<>();
    }

    @Override
    public void inserirVertex(K key, V value) {
        taulaHash.inserir(key, value);
    }

    @Override
    public V consultarVertex(K key) throws VertexNoTrobat {

        try{
            return taulaHash.consultar(key);
        } catch (ElementNoTrobat e){
            throw new VertexNoTrobat();
        }

    }

    public boolean buscarVertex(K key) {

        try {
            return taulaHash.buscar(key);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void esborrarVertex(K key) throws VertexNoTrobat {

        try {
            taulaHash.buscar(key);
            taulaHash.esborrar(key);

            // borrar arestes asociades
            for (Aresta<K,E> aresta : llistaArestes) {
                if (aresta.getOrigen().equals(key) || aresta.getDesti().equals(key))
                    llistaArestes.esborrar(aresta);

            }
        } catch (Exception e) {
            throw new VertexNoTrobat();
        }

    }

    @Override
    public boolean esBuida() {
        return taulaHash.esBuida();
    }

    @Override
    public int numVertex() {
        return taulaHash.numElements();
    }

    @Override
    public ILlistaGenerica<K> obtenirVertexIDs() {
        return taulaHash.obtenirClaus();
    }

    @Override
    public void inserirAresta(K v1, K v2, E pes) throws VertexNoTrobat {

        if (!taulaHash.buscar(v1) || !taulaHash.buscar(v2))
            throw new VertexNoTrobat();

        if (!existeixAresta(v1, v2)){
            Aresta<K, E> aresta = new Aresta<>(v1, v2, pes);
            llistaArestes.inserir(aresta);
        }
    }

    @Override
    public void inserirAresta(K v1, K v2) throws VertexNoTrobat {
        inserirAresta(v1, v2, null);
    }

    @Override
    public boolean existeixAresta(K v1, K v2) throws VertexNoTrobat {

        for (Aresta<K, E> aresta : llistaArestes) {
            if (aresta.getOrigen().equals(v1) && aresta.getDesti().equals(v2) ||
                aresta.getOrigen().equals(v2) && aresta.getDesti().equals(v1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E consultarAresta(K v1, K v2) throws VertexNoTrobat, ArestaNoTrobada {

        if (!taulaHash.buscar(v1) || !taulaHash.buscar(v2))
            throw new VertexNoTrobat();

        for (Aresta<K, E> aresta : llistaArestes) {
            if (aresta.getOrigen().equals(v1) && aresta.getDesti().equals(v2) ||
                aresta.getOrigen().equals(v2) && aresta.getDesti().equals(v1)) {
                return aresta.getPes();
            }
        }

        throw new ArestaNoTrobada();
    }

    @Override
    public void esborrarAresta(K v1, K v2) throws VertexNoTrobat, ArestaNoTrobada {

        if (!taulaHash.buscar(v1) || !taulaHash.buscar(v2))
            throw new VertexNoTrobat();

        for (Aresta<K, E> aresta : llistaArestes) {
            if (aresta.getOrigen().equals(v1) && aresta.getDesti().equals(v2) ||
                aresta.getOrigen().equals(v2) && aresta.getDesti().equals(v1)) {
                    try {
                        llistaArestes.esborrar(aresta);
                        return;
                    } catch (ElementNoTrobat e) {

                    }
            }
        }

        throw new ArestaNoTrobada();

    }

    @Override
    public int numArestes() {
        return llistaArestes.numElements();
    }

    @Override
    public boolean vertexAillat(K v1) throws VertexNoTrobat {

        for (Aresta<K, E> arista : llistaArestes) {
            if (arista.getOrigen().equals(v1) || arista.getDesti().equals(v1))
                return false;
        }

        return true;
    }

    @Override
    public int numVeins(K v1) throws VertexNoTrobat {
        return obtenirVeins(v1).numElements();
    }

    public ILlistaGenerica<K> obtenirPersonesIDs() {
        return taulaHash.obtenirClaus();
    }

    @Override
    public LlistaGenerica<K> obtenirVeins(K v1) throws VertexNoTrobat {

        LlistaGenerica<K> veins = new LlistaNoOrdenada<>();

        for (Aresta<K, E> aresta : llistaArestes) {
            if (aresta.getOrigen().equals(v1)) {
                veins.inserir(aresta.getDesti());
            } else if (aresta.getDesti().equals(v1)) {
                veins.inserir(aresta.getOrigen());
            }
        }

        return veins;
    }

    // Mètodes opcionals:

    @Override
    public ILlistaGenerica<K> obtenirNodesConnectats(K v1) throws VertexNoTrobat {
        ILlistaGenerica<K> nodesConnectats = new LlistaOrdenada<>();
        return nodesConnectats;
    }

    @Override
    public ILlistaGenerica<K> obtenirComponentConnexaMesGran() {
        // Implementa la lògica per a trobar la Component Connexa més gran
        return null; // Per ara retornem null, cal implementar aquest mètode
    }
}
