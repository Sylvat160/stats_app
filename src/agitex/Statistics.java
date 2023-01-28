package agitex;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<String, Float> averageSalaries;

    public Statistics() {
        this.averageSalaries = new HashMap<>();
    }

    public void calculateAverageSalaries(FileReader fileReader) {
        // Code pour parcourir la liste des clients et calculer les moyennes
        // de salaires par profession
    }

    public Map<String, Float> getAverageSalaries() {
        return this.averageSalaries;
    }
}
