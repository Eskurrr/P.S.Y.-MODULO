package data;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
    private String id;
    List<Integer> medidas;
    public Dispositivo(String id) {
        this.id = id;
        this.medidas = new ArrayList<Integer>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Integer> medidas) {
        this.medidas = medidas;
    }
}
