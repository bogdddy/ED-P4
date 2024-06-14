package cat.urv.deim;

public class NodeGraf {

    private NodeGraf segFila, segCol;
    private int vertex1, vertex2;
    private String etiq; // Etiqueta de la arista

    public NodeGraf(int vertex1, int vertex2, String etiq) {
        this.segFila = null;
        this.segCol = null;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.etiq = etiq;
    }

    public NodeGraf getSegFila() {
        return segFila;
    }

    public NodeGraf getSegCol() {
        return segCol;
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public String getEtiq() {
        return etiq;
    }

    public void setSegFila(NodeGraf segFila) {
        this.segFila = segFila;
    }

    public void setSegCol(NodeGraf segCol) {
        this.segCol = segCol;
    }

    public void setVertex1(int vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    public void setEtiq(String etiq) {
        this.etiq = etiq;
    }
}
