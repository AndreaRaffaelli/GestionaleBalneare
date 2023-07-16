package Servlet;

import java.io.IOException;
import java.time.LocalDate;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalendarioServlet extends HttpServlet {
    private LocalDate InizioStagione;
    private LocalDate FineStagione;

    @Override
    public void init() throws ServletException {
        InizioStagione = LocalDate.of(2023, 6, 1);
        FineStagione = LocalDate.of(2023, 9, 30);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");

        boolean periodoValido = valida(startDate, endDate);
        if (!periodoValido) {          
            // Il periodo non è valido, inoltra la richiesta a una JSP per mostrare un messaggio di errore
            request.setAttribute("tipoErrore", "Errore durante la validazione del periodo");
            request.setAttribute("messaggioErrore", "Il periodo specificato non è valido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errore.jsp");
            dispatcher.forward(request, response);
        }

    }

    private boolean valida(String dataInizioParam, String dataFineParam) {
		LocalDate dataInizio = LocalDate.parse(dataInizioParam);
		LocalDate dataFine = LocalDate.parse(dataFineParam);

        return (dataInizio.isAfter(InizioStagione) || dataInizio.isEqual(InizioStagione))
                    && (dataFine.isBefore(FineStagione) || dataFine.isEqual(FineStagione));
    }
}
