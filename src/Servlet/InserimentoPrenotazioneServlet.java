package Servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Oggetto;
import modello.Periodo;
import modello.Posizione;
import modello.Prenotazione;
import utility.Archivio;



public class InserimentoPrenotazioneServlet extends HttpServlet {

	// private Gson gson;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig conf) throws ServletException
	{ }
	
	@Override	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
        String nameSurname = request.getParameter("name-surname");
        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");
        String position = request.getParameter("position");
		int nPosizione= Integer.parseInt(position);
		String objectData = request.getParameter("object-data");
              


		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate parsedStartDate = LocalDate.parse(startDate);
		LocalDate parsedEndDate = LocalDate.parse(endDate);


        System.out.println("Nome e cognome: " + nameSurname);
        System.out.println("Data inizio: " + startDate);
        System.out.println("Data fine: " + endDate);
        System.out.println("Posizione: " + position);
        System.out.println("Oggetti inseriti: " + objectData);

        
        // Inoltra la richiesta alla CalendarioServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calendarioServlet"); // Assumi che il nome della mappatura sia "/calendario" per la CalendarioServlet
        request.setAttribute("dataInizio", parsedStartDate);
        request.setAttribute("dataFine", parsedEndDate);
        dispatcher.include(request, response);

		System.out.println("Continuo");

		Periodo newPeriodo= Periodo.nuovoPeriodo(parsedStartDate, parsedEndDate);

		Archivio a= Archivio.getInstace();
		Posizione p = a.getPlanimetria().getPosizione(nPosizione);
		boolean isOccupato = p.isOccupato(newPeriodo);

		if(isOccupato){
			request.setAttribute("tipoErrore", "Errore durante l'inserimento della prenotazione");
            request.setAttribute("messaggioErrore", "La posizione selezionata non è disponibile per il periodo selezionato.");
            dispatcher = request.getRequestDispatcher("/errore.jsp");
            dispatcher.forward(request, response);
		}
		Prenotazione newPrenotazione = new Prenotazione();
		String[] righe = objectData.split(System.lineSeparator());
		for(String riga : righe)
		{
			String[] parts = riga.split("-");
			String nomeO = parts[0].trim(); // Nome (prima parte)
			String quantitaPart = parts[1].trim(); // Seconda parte (contenente "Quantita: 2")

			// Estrazione del numero dalla seconda parte
			String quantitaStr = quantitaPart.substring(quantitaPart.indexOf(":") + 1).trim();
			int quantita = Integer.parseInt(quantitaStr);
			Oggetto oggetto = a.getOggetto(nomeO);
			newPrenotazione.addOggetto(oggetto, quantita);
		}
		

		a.addPrenotazione(newPrenotazione);
		
	}
	

	

}
