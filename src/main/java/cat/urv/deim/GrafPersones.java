package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.VertexNoTrobat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class GrafPersones {

    Graf<Integer, Persona, Integer> graf;

    public GrafPersones(int mida) {
        graf = new Graf<>(mida);
    }

    public GrafPersones(int mida, String persones, String amistats) {
        graf = new Graf<>(mida);

        try (BufferedReader br = new BufferedReader(new FileReader(persones))) {
            String linia = "";
            while ((linia = br.readLine()) != null) {
                String[] data = linia.split(",");
                Persona persona = new Persona(Integer.valueOf(data[0]), Integer.valueOf(data[1]),
                    data[2], data[3], Integer.valueOf(data[4]), Integer.valueOf(data[5]));
                try {
                    inserirPersona(persona);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (amistats != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(amistats))) {
                String linia = "";
                while ((linia = br.readLine()) != null) {
                    String[] data = linia.split(",");
                    try {
                        Persona p1 = (Persona) graf.consultarVertex(Integer.valueOf(data[0]));
                        Persona p2 = (Persona) graf.consultarVertex(Integer.valueOf(data[1]));
                        inserirAmistat( p1, p2, Integer.valueOf(data[2]));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void inserirPersona(Persona p) {

        if (!graf.buscarVertex(p.getId_persona())){
            graf.inserirVertex(p.getId_persona(), p);
        }else {
            try {
                graf.esborrarVertex(p.getId_persona());
                graf.inserirVertex(p.getId_persona(), p);
            } catch (VertexNoTrobat e) {
                e.printStackTrace();
            }
        }
    }

    public Persona consultarPersona(int id) throws ElementNoTrobat {
        try {
            return graf.consultarVertex(id);
        } catch (VertexNoTrobat e) {
            return null;
        }
    }

    public void esborrarPersona(int id) throws ElementNoTrobat {
        try {
            graf.esborrarVertex(id);
        } catch (VertexNoTrobat e) {
            throw new ElementNoTrobat();
        }
    }

    public int numPersones() {
        return graf.numVertex();
    }

    public boolean esBuida() {
        return graf.numVertex() == 0;
    }

    public ILlistaGenerica<Integer> obtenirPersonesIDs() {
        return graf.obtenirPersonesIDs();
    }

    // Metodes per a guardar amistats

    public void inserirAmistat(Persona p1, Persona p2) throws ElementNoTrobat  {
        try {
            graf.inserirAresta(p1.getId_persona(), p2.getId_persona());
        } catch (VertexNoTrobat e) {
        }
    }

    public void inserirAmistat(Persona p1, Persona p2, int intensitat) throws ElementNoTrobat  {
        try {
            graf.inserirAresta(p1.getId_persona(), p2.getId_persona(), intensitat);
        } catch (VertexNoTrobat e) {
            throw new ElementNoTrobat();
        }
    }

    public void esborrarAmistat(Persona p1, Persona p2) throws ElementNoTrobat {
        try {
            graf.esborrarAresta(p1.getId_persona(), p2.getId_persona());
        } catch (Exception e) {
            throw new ElementNoTrobat();
        }
    }

    public boolean existeixAmistat(Persona p1, Persona p2) throws ElementNoTrobat {
        try {
            return graf.existeixAresta(p1.getId_persona(), p2.getId_persona());
        } catch (VertexNoTrobat e) {
            return false;
        }
    }

    public int intensitatAmistat(Persona p1, Persona p2) throws ElementNoTrobat {
        try {
            return graf.consultarAresta(p1.getId_persona(), p2.getId_persona());
        } catch (Exception e) {
            throw new ElementNoTrobat();
        }
    }

    public int numAmistats() {
        return graf.numArestes();
    }

    public int numAmistats(Persona p) throws ElementNoTrobat {
        try {
            return graf.numVeins(p.getId_persona());
        } catch (VertexNoTrobat e) {
            throw new ElementNoTrobat();
        }
    }

    public boolean teAmistats(Persona p) {
        try {
            return graf.numVeins(p.getId_persona()) != 0;
        } catch (VertexNoTrobat e) {
            return false;
        }
    }

    public ILlistaGenerica<Integer> obtenirAmistats(Persona p) throws ElementNoTrobat {
        try {
            return graf.obtenirVeins(p.getId_persona());
        } catch (VertexNoTrobat e) {
            throw new ElementNoTrobat();
        }

    }

    // Aquest metode busca totes les persones del grup d'amistats de p que tenen alguna connexio amb p
    // ja sigui directament, o be perque son amics d'amics, o amics de amics de amics, etc.
    // Retorna una llista amb els ID de les persones del grup
    public ILlistaGenerica<Integer> obtenirGrupAmistats(Persona p) throws ElementNoTrobat {
        return null;
    }

    // Aquest metode busca el grup d'amistats mes gran del graf, es a dir, el que te major nombre
    // de persones que estan connectades entre si. Retorna una llista amb els ID de les persones del grup
    public ILlistaGenerica<Integer> obtenirGrupAmistatsMesGran() {
        return null;
    }

}
