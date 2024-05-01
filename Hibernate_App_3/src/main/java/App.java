import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.model.Passport;
import org.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Person person = session.get(Person.class,1);
            session.remove(person);

            //   person.setPassport(passport); хорошая практика для кэша, но можно сделать и так: public void setPassport(Passport passport) {
//                                                                                                   this.passport = passport;
//                                                                                                   passport.setPerson(this);
//                                                                                               } благодаля этому не подаюем человека в конструкторе, она овтоматом просоеденяется в сеттере.

//            session.save(person);


            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}