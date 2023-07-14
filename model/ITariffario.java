package modello;

import java.util.Date;
import java.time.Period;

// Interfaccia ITariffario
public interface ITariffario {
    int getPrezzo(Periodo periodo);
}