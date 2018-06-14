package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import westbahn.*;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	private static EntityManagerFactory sessionFactory;
	@PersistenceContext
	private static EntityManager entitymanager;
	static SimpleDateFormat dateForm = new SimpleDateFormat("dd.MM.yyyy");
	static SimpleDateFormat timeForm = new SimpleDateFormat("dd.MM.yyyy mm:hh");

    private static List<Bahnhof> bahnhoefe;
    private static List<Strecke> strecken;
    private static List<Ticket> tickets;
    private static List<Benutzer> benutzer;
    private static List<Zug> zuege;
    private static List<Reservierung> reservierungen;

    private Main() {
		super();
	}

	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		try {
			log.info("Starting \"Mapping Perstistent Classes and Associations\" (task1)");
			/*Testen der Datenbank */
			sessionFactory = Persistence.createEntityManagerFactory("westbahnPU");
            entitymanager= sessionFactory.createEntityManager();

            BasicConfigurator.configure();


			/*Fuchs
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
			SessionFactory factory=cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.persist(b1);
			t.commit();
			session.close();
            */

			fillDB(entitymanager);
			task01();
			log.info("Starting \"Working with JPA-QL and the Hibernate Criteria API\" (task2)");

			task02a();
			task02b();
			task02c();
			//getBahnhof();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fillDB(EntityManager em) throws ParseException {
		em = sessionFactory.createEntityManager();

        bahnhoefe = new ArrayList<Bahnhof>();
        strecken = new ArrayList<Strecke>();
        tickets = new ArrayList<Ticket>();
        benutzer = new ArrayList<Benutzer>();
        zuege = new ArrayList<Zug>();
        reservierungen = new ArrayList<Reservierung>();

        em.getTransaction().begin();
        Bahnhof b1 = new Bahnhof("WienHbf", 0, 0, 0, true);
        Bahnhof b2 = new Bahnhof("Salzburg", 30, 200, 40, true);
        Bahnhof b3 = new Bahnhof("Linz", 20, 120, 30, false);
        Bahnhof b4 = new Bahnhof("Rom",50,300,200,true);
        bahnhoefe.add(b1);
        bahnhoefe.add(b2);
        bahnhoefe.add(b3);
        bahnhoefe.add(b4);

        for (Bahnhof b : bahnhoefe)
            em.persist(b);

        em.getTransaction().commit();

        em.getTransaction().begin();
        Strecke WienSalzburg = new Strecke(b1,b2);
        Strecke SalzburgLinz = new Strecke(b2,b3);
        Strecke LinzRom = new Strecke(b3,b4);
        Strecke WienRom = new Strecke(b1,b4);
        strecken.add(WienSalzburg);
        strecken.add(SalzburgLinz);
        strecken.add(LinzRom);
        strecken.add(WienRom);

        for (Strecke s : strecken)
            em.persist(s);

        em.getTransaction().commit();

        // Tickets erstellen und Zahlungsarten
        em.getTransaction().begin();
        Zahlung maestro = new Maestro();
        Zahlung kreditkarte = new Kreditkarte();
        Zahlung praemien = new Praemienmeilen();

        Einzelticket et1 = new Einzelticket(strecken.get(0),maestro,TicketOption.FAHRRAD);
        Einzelticket et2 = new Einzelticket(strecken.get(1),praemien,TicketOption.FAHRRAD);
        Einzelticket et3 = new Einzelticket(strecken.get(3),maestro,TicketOption.GROSSGEPAECK);
        Zeitkarte z1 = new Zeitkarte(strecken.get(2),kreditkarte,new Date(),ZeitkartenTyp.MONATSKARTE);
        tickets.add(et1);
        tickets.add(et2);
        tickets.add(et3);
        tickets.add(z1);

        for (Ticket t : tickets)
            em.persist(t);

        em.getTransaction().commit();

        //Benutzer erstellen
        em.getTransaction().begin();
        Benutzer bn1 = new Benutzer("Herbert","Maier","hmaier@student.tgm.ac.at","Test","066439483842",0L,tickets.get(0));
        Benutzer bn2 = new Benutzer("Hans","Sarpei","hsarpei@gmail.com","Test2","06673928473",0L,tickets.get(1));
        Benutzer bn3 = new Benutzer("Tim","Wiese","twiese@mail.com","Passwort","066382948328",0L,tickets.get(2));
        benutzer.add(bn1);
        benutzer.add(bn2);
        benutzer.add(bn3);
        for (Benutzer b : benutzer)
            em.persist(b);

        em.getTransaction().commit();

        //Zug erstellen
        em.getTransaction().begin();
        Zug zug1 = new Zug(new Date(),30,10,60,bahnhoefe.get(0),bahnhoefe.get(1));
        zuege.add(zug1);
        for (Zug z : zuege)
            em.persist(z);

        em.getTransaction().commit();

        //Reservierungen
        /*
        em.getTransaction().begin();
        Reservierung r1 = new Reservierung(new Date(),10,15,StatusInfo.ONTIME,zuege.get(0),strecken.get(0),benutzer.get(0),maestro);
        reservierungen.add(r1);
        for (Reservierung r : reservierungen)
            em.persist(r);
        em.flush();
        em.getTransaction().commit();
        */
		System.out.println("Session finished");

		
	}
	
	public static void task01() throws ParseException, InterruptedException {
		
		
	}
	public static void task02a() throws ParseException {
        /*Query q = entitymanager.createNamedQuery("Reservierung.getReservationEmail");
        q.setParameter("eMail", "hmaier@student.tgm.ac.at");
        List<Reservierung> result = q.getResultList();

        for (Reservierung r : result){
            System.out.println(r.getBenutzer().getNachName());
        }
        */
	}

	public static void task02b() throws ParseException {
        Query q = entitymanager.createNamedQuery("getUsersWMonthTicket");
        List<Benutzer> result = q.getResultList();

        for (Benutzer r : result){

            System.out.println(r.getNachName()+" "+r.getVorName() + " ist Besitzer einer Monatskarte");
        }

	}

	/* Liste alle Tickets für eine bestimmte Strecke aus (durch Anfangs- und Endbahnhof definiert), wo keine Reservierungen durchgeführt wurden.
	    Funktioniert nicht wegen Reservierungsjoin in Ticket
	 */
	public static void task02c() throws ParseException {
        /*
        Query q = entitymanager.createNamedQuery("TicketsOfRouteNoReserve");
        q.setParameter("strecke",strecken.get(0).getID());
        List<Ticket> result = q.getResultList();

        for (Ticket t : result){

            System.out.println(t.getID());
        }
        */

	}

}
