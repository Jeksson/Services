import com.jekss.entityes.*;
import com.jekss.service.serv.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by jekss on 11.10.15.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserServ userServ;
    @Resource
    private RoleServ roleServ;
    @Resource
    private SalesServ salesServ;
    @Resource
    private CompanyServ companyServ;
    @Resource
    private CityServ cityServ;
    @Resource
    private AdressCompanyServ adressCompanyServ;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }


    //@Test
    public void testSaveRole() throws Exception{
        Role role = new Role();
        role.setRole("RoleUser");
       roleServ.addRole(role);
    }

    //@Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setName("Vlad");
        user.setLogin("vlad");
        user.setPassword("password");
        user.setRole(roleServ.getByIdRole(1));
        userServ.addUser(user);
    }

    @Test
    public void getByAllUser(){
        List<User>userList = userServ.getAll();
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()){
            User user = (User) iterator.next();
            System.out.println(user.getName() + " " +user.getRole());
        }
    }
    //@Test
    public void getByIdUser(){
        User user = userServ.getById(2);
        System.out.println(user.getName() + " " +user.getRole().toString());
    }
    @Test
    public void getUserByLogin(){
        User user = userServ.getByLogin("jeksson");
        System.out.println(user.getName());

    }
    //@Test
    public void addSales(){
        Sales sales = new Sales();
        sales.setSalesName("IT");
        salesServ.addSales(sales);
    }
    //@Test
    public void addCompany(){
        Company company = new Company();
        company.setNameCompany("PrivatBank");
        company.setSales(salesServ.getById(3));
        company.setUser(userServ.getById(1));
        companyServ.addCompany(company);
    }
    //@Test
    public void addCity(){
        City city = new City();
        city.setCityName("Marganest");
        city.setRegion("Dnepr");
        city.setTerritory("Vostok");
        cityServ.addCity(city);
    }

    //@Test
    public void addAdressComp(){
        AdressCompany adressCompany = new AdressCompany("Zapad", 25, 22, cityServ.getById(1), companyServ.getById(25));
        adressCompanyServ.addAdressCompany(adressCompany);
    }
    //@Test
    public void getCompanyByCity(){
        City city = cityServ.getById(1);
        Set<AdressCompany> adressCompanySet = city.getAdressCompanySet();
        Iterator iterator = adressCompanySet.iterator();
        while (iterator.hasNext()){
            AdressCompany adressCompany = (AdressCompany) iterator.next();
            System.out.println(adressCompany.getCompany());
        }
    }
    //@Test
    public void getCompanyByUser(){
        User user = userServ.getById(1);
        Set<Company> companySet = user.getCompanies();
        Iterator iterator = companySet.iterator();
        while (iterator.hasNext()){
            Company company = (Company) iterator.next();
            System.out.println(company);
        }
    }
    //@Test
    public void getAllCompany(){
        List<Company> companyList = companyServ.allCompany();
        Iterator iterator = companyList.iterator();
        while (iterator.hasNext()){
            Company company = (Company) iterator.next();
            System.out.println(company.toString());
        }
    }
}

