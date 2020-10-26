import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YelpTests {
    public static WebDriver driver = new ChromeDriver();
    public static String url_base = "https://www.yelp.com//";
    YelpMethods yelpMethods = new YelpMethods();
    String buscar = " Restaurants Pizza";

    @Before
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/alejandrovasquez/Documents/Proyectos Oktana/chromedriver");
    }
    @Test(testName = "Complete Yelp 1st Test")
    public void yelpFirstTest() throws Exception {
        String filtro_1 = "Filters";
        String opcion_1 = "$$";
        String filtro_2 = "Distance";
        String opcion_2 = "Biking";
        String review_1; String review_2; String review_3;
        String link;String address; String telephone;
        driver.manage().window().maximize();
        driver.get(url_base);
        yelpMethods.clickSeccionSearch(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.enviarBusqueda(driver,buscar);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.contarResultadosIniciales(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Aplicando Filtros
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.clickFiltroBoton(driver,filtro_1,opcion_1);
        yelpMethods.clickFiltroRadioButton(driver,filtro_2,opcion_2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        //Resultados Totales
        yelpMethods.contarEstrellasPrimerResultado(driver);
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.contarResultadosTotales(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        yelpMethods.validarResultados(driver);
        yelpMethods.waitForLoad(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Ingresando al Primer Resultado
        yelpMethods.clickPrimerResultado(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Recuperando la información clave
        link = yelpMethods.recuperarLink(driver);
        telephone = yelpMethods.recuperarTelefono(driver);
        address = yelpMethods.recuperarDireccion(driver);
        System.out.println("\nBusiness Information:\n");
        System.out.println("Website: "+link+"\n");
        System.out.println("Telephone: "+telephone+"\n");
        System.out.println("Address: "+address+"\n");
        //Recuperando las Opiniones
        review_1 = yelpMethods.recuperarOpinion(driver,"1");
        review_2 = yelpMethods.recuperarOpinion(driver,"2");
        review_3 = yelpMethods.recuperarOpinion(driver,"3");
        System.out.println("\nFirst Review: \n"+review_1);
        System.out.println("\nSecond Review: \n"+review_2);
        System.out.println("\nThird Review: \n"+review_3);
        //driver.close();
    }

    @Test(testName = "Complete Yelp 2nd Test")
    public void yelpSecondTest() throws Exception {
        String filtro_1 = "Features";
        String opcion_1 = "Good for Kids";
        String filtro_2 = "Distance";
        String opcion_2 = "Driving";
        String review_1; String review_2; String review_3;
        String link;String address; String telephone;
        driver.manage().window().maximize();
        driver.get(url_base);
        yelpMethods.clickSeccionSearch(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.enviarBusqueda(driver,buscar);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.contarResultadosIniciales(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Aplicando Filtros
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.clickFiltroCheck(driver,filtro_1,opcion_1);
        yelpMethods.clickFiltroRadioButton(driver,filtro_2,opcion_2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        //Resultados Totales
        yelpMethods.contarEstrellasPrimerResultado(driver);
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.contarResultadosTotales(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        yelpMethods.validarResultados(driver);
        yelpMethods.waitForLoad(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Ingresando al Primer Resultado
        yelpMethods.clickPrimerResultado(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Recuperando la información clave
        link = yelpMethods.recuperarLink(driver);
        telephone = yelpMethods.recuperarTelefono(driver);
        address = yelpMethods.recuperarDireccion(driver);
        System.out.println("\nBusiness Information:\n");
        System.out.println("Website: "+link+"\n");
        System.out.println("Telephone: "+telephone+"\n");
        System.out.println("Address: "+address+"\n");
        //Recuperando las Opiniones
        review_1 = yelpMethods.recuperarOpinion(driver,"1");
        review_2 = yelpMethods.recuperarOpinion(driver,"2");
        review_3 = yelpMethods.recuperarOpinion(driver,"3");
        System.out.println("\nFirst Review: \n"+review_1);
        System.out.println("\nSecond Review: \n"+review_2);
        System.out.println("\nThird Review: \n"+review_3);
        //driver.close();
    }

    @Test(testName = "Complete Yelp 3rd Test")
    public void yelpThirdTest() throws Exception {
        String filtro_1 = "Filters";
        String opcion_1 = "$$$$";
        String filtro_2 = "Distance";
        String opcion_2 = "Driving";
        String review_1; String review_2; String review_3;
        String link;String address; String telephone;
        driver.manage().window().maximize();
        driver.get(url_base);
        yelpMethods.clickSeccionSearch(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.enviarBusqueda(driver,buscar);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        yelpMethods.contarResultadosIniciales(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Aplicando Filtros
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.clickFiltroBoton(driver,filtro_1,opcion_1);
        yelpMethods.clickFiltroRadioButton(driver,filtro_2,opcion_2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yelpMethods.waitForLoad(driver);
        //Resultados Totales
        yelpMethods.contarEstrellasPrimerResultado(driver);
        yelpMethods.scrollearAlInicio(driver);
        yelpMethods.contarResultadosTotales(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        yelpMethods.validarResultados(driver);
        yelpMethods.waitForLoad(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Ingresando al Primer Resultado
        yelpMethods.clickPrimerResultado(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Recuperando la información clave
        link = yelpMethods.recuperarLink(driver);
        telephone = yelpMethods.recuperarTelefono(driver);
        address = yelpMethods.recuperarDireccion(driver);
        System.out.println("\nBusiness Information:\n");
        System.out.println("Website: "+link+"\n");
        System.out.println("Telephone: "+telephone+"\n");
        System.out.println("Address: "+address+"\n");
        //Recuperando las Opiniones
        review_1 = yelpMethods.recuperarOpinion(driver,"1");
        review_2 = yelpMethods.recuperarOpinion(driver,"2");
        review_3 = yelpMethods.recuperarOpinion(driver,"3");
        System.out.println("\nFirst Review: \n"+review_1);
        System.out.println("\nSecond Review: \n"+review_2);
        System.out.println("\nThird Review: \n"+review_3);
        driver.close();
    }
}
