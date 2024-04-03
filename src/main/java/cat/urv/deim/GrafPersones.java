package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.VertexNoTrobat;
import cat.urv.deim.exceptions.ArestaNoTrobada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class GrafPersones {

    // Metodes per a guardar persones

    public void inserirPersona(Persona p) {
    }

    public Persona consultarPersona(int id) throws ElementNoTrobat {
    }

    public void esborrarPersona(int id) throws ElementNoTrobat {
    }

    public int numPersones() {
    }

    public boolean esBuida() {
    }

    public ILlistaGenerica<Integer> obtenirPersonesIDs() {
    }

    // Metodes per a guardar amistats

    public void inserirAmistat(Persona p1, Persona p2) throws ElementNoTrobat  {
    }


    public void inserirAmistat(Persona p1, Persona p2, int intensitat) throws ElementNoTrobat  {
    }

    public void esborrarAmistat(Persona p1, Persona p2) throws ElementNoTrobat  {
    }

    public boolean existeixAmistat(Persona p1, Persona p2) throws ElementNoTrobat {
    }

    public int intensitatAmistat(Persona p1, Persona p2) throws ElementNoTrobat {
    }

    public int numAmistats() {
    }

    public int numAmistats(Persona p) throws ElementNoTrobat {
    }

    public boolean teAmistats(Persona p) {
    }


    public ILlistaGenerica<Integer> obtenirAmistats(Persona p) throws ElementNoTrobat {
    }

    // Aquest metode busca totes les persones del grup d'amistats de p que tenen alguna connexio amb p
    // ja sigui directament, o be perque son amics d'amics, o amics de amics de amics, etc.
    // Retorna una llista amb els ID de les persones del grup
    public ILlistaGenerica<Integer> obtenirGrupAmistats(Persona p) throws ElementNoTrobat {
    }

    // Aquest metode busca el grup d'amistats mes gran del graf, es a dir, el que te major nombre
    // de persones que estan connectades entre si. Retorna una llista amb els ID de les persones del grup
    public ILlistaGenerica<Integer> obtenirGrupAmistatsMesGran() {
    }

}
