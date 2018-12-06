package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.BetalingService;
import be.thomasmore.travelmore.service.BoekingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;

@ManagedBean
@SessionScoped
public class BoekingController {
    private Boeking nieuweBoeking = new Boeking();

    private static String USER_NAME = "team09travelmore";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Travelmore!1"; // GMail password

    @Inject
    private BoekingService boekingService;

    @Inject
    private BetalingService betalingService;

    @Inject
    private GebruikerController gebruikerController;

    public String boekReis(Reis reis){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Gebruiker ingelogd = (Gebruiker)session.getAttribute("user");
        if(ingelogd == null){
            return "reizenfilter";
        }
        nieuweBoeking.setReis(reis);
        nieuweBoeking.setAantalPersonen(1);
        nieuweBoeking.setGebruiker(ingelogd);

        return "boeking";
    }

    public String betaalReis(BetalingsType betalingsType){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Gebruiker ingelogd = (Gebruiker)session.getAttribute("user");
        if(ingelogd == null){
            return "reizenfilter";
        }
        Betaling betaling = new Betaling();
        Date date = new Date();
        betaling.setDatum(date);
        betaling.setBetalingstype(betalingsType);
        System.out.println("****************************************************");
        System.out.println(nieuweBoeking.getAantalPersonen());
        System.out.println(nieuweBoeking.getOpmerking());
        System.out.println(nieuweBoeking.getReis().getNaam());
        System.out.println("****************************************************");
        //nieuweBoeking.setBetaling(betaling);
        betalingService.insert(betaling);
        //boekingService.insert(nieuweBoeking);
        insertBoeking(nieuweBoeking);

        //stuur email
        String subject = "Jouw boeking " + nieuweBoeking.getReis().getNaam();
        String body = ingelogd.getNaam() + "\n"
                + "bedankt voor jouw bestelling!\n" +
                "Je bestelde reis: " + nieuweBoeking.getReis().getNaam() + "\n" +
                "Voor " + nieuweBoeking.getAantalPersonen() + " personen\n" +
                "Betaald met " + nieuweBoeking.getBetaling().getBetalingstype().getNaam() + "\n" +
                "Heeft een totale prijs van €" + nieuweBoeking.getReis().getKostprijs() * nieuweBoeking.getAantalPersonen() + ".\n" +
                "Jouw opmerking: " + nieuweBoeking.getOpmerking() + "\n" +
                "Een goede reis en tot de volgende keer!";
        String[] to = {ingelogd.getEmail()};
        sendFromGMail(USER_NAME, PASSWORD, to, subject, body);

        return "bedankt";
    }

    public void insertBoeking(Boeking boeking){
        Betaling betaling = betalingService.getLaatsteBetaling();
        boeking.setBetaling(betaling);
        boekingService.insert(boeking);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }
}
