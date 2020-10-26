import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class YelpMethods {
    public void elementVisible(WebDriver driver, WebElement element){
        WebDriverWait w = new WebDriverWait(driver,40);
        w.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(pageLoadCondition);
    }

    public void clickSeccionSearch(WebDriver driver){
        WebElement mySearch = driver.findElement(By.xpath("//form//div[@class='arrange_unit']//child::div[@class='pseudo-input_wrapper']//input[@id='find_desc']"));
        mySearch.click();
        WebElement mySugerencia = driver.findElement(By.xpath("//form//div[@class='arrange_unit']//div[@class='main-search_suggestions suggestions-list-container search-suggestions-list-container']//ul//li[@data-suggest-query='Restaurants']"));
        mySugerencia.click();
    }

    public void enviarBusqueda(WebDriver driver,String buscar)throws InterruptedException {
        WebElement barraBusqueda = driver.findElement(By.xpath("//label[@for='search_description']//child::input[@name='find_desc']"));
        elementVisible(driver,barraBusqueda);
        barraBusqueda.click();
        Thread.sleep(500);
        barraBusqueda.sendKeys(buscar);
        WebElement botonBusqueda = driver.findElement(By.xpath("//div[@class='lemon--div__09f24__1mboc arrange-unit__09f24__1gZC1 border-color--default__09f24__R1nRO']//button[@value='submit']"));
        botonBusqueda.click();
    }

    public void validarResultados(WebDriver driver) throws InterruptedException {
        String xpath = "//h3[text()='All Results']";
        WebElement cabeceraResultados = driver.findElement(By.xpath(xpath));
        elementVisible(driver,cabeceraResultados);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cabeceraResultados);
        Thread.sleep(500);
        Assert.assertTrue(cabeceraResultados.getText().contentEquals("All Results"));
    }

    public void clickPrimerResultado(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        String xpath = "(//h3[text()='All Results']//following::li//child::h4//child::span[text()])[1]//a";
        WebElement cabeceraResultado1 = driver.findElement(By.xpath(xpath));
        System.out.println("The first result was: "+cabeceraResultado1.getText());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", cabeceraResultado1);
    }

    public void scrollearAlInicio(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,-4500)");
    }

    public void clickFiltroBoton(WebDriver driver,String filtro, String opcion){
        WebElement labelFilter = driver.findElement(By.xpath(String.format("//div[@style='top: auto;']//p[text()='%s']",filtro)));
        labelFilter.click();
        WebElement opcionFilter = driver.findElement(By.xpath(String.format("(//div[@style='top: auto;']//p[text()='%s']//following::span[text()= '%s']//ancestor::button)[1]",filtro,opcion)));
        opcionFilter.click();
        System.out.println("Parameter: "+filtro+"  |  Criteria: "+opcion);
    }

    public void clickFiltroCheck(WebDriver driver,String filtro, String opcion){
        WebElement labelFilter = driver.findElement(By.xpath(String.format("//div[@style='top: auto;']//p[text()='%s']",filtro)));
        labelFilter.click();
        WebElement opcionFilter = driver.findElement(By.xpath(String.format("(//div[@style='top: auto;']//p[text()='%s']//following::span[text()='%s'])[1]",filtro,opcion)));
        opcionFilter.click();
        System.out.println("Parameter: "+filtro+"  |  Criteria: "+opcion);
    }

    public void clickFiltroRadioButton(WebDriver driver,String filtro, String opcion){
        WebElement labelFilter = driver.findElement(By.xpath(String.format("//div[@style='top: auto;']//p[text()='%s']",filtro)));
        labelFilter.click();
        WebElement opcionFilter = driver.findElement(By.xpath(String.format("//div[@style='top: auto;']//p[text()='%s']//following::span[contains(text(),'%s')]",filtro,opcion)));
        opcionFilter.click();
        System.out.println("Parameter: "+filtro+"  |  Criteria: "+opcion);
    }

    public String recuperarLink(WebDriver driver){
        WebElement link = driver.findElement(By.xpath("(//div[@class='lemon--div__373c0__1mboc stickySidebar--fullHeight__373c0__1szWY arrange-unit__373c0__o3tjT arrange-unit-grid-column--4__373c0__33Wpc border-color--default__373c0__3-ifU']//div//p//a[@role='link'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        Assert.assertTrue(link.isDisplayed());
        return link.getText();
    }

    public String recuperarTelefono(WebDriver driver){
        WebElement telefono = driver.findElement(By.xpath("//div[@class='lemon--div__373c0__1mboc stickySidebar--fullHeight__373c0__1szWY arrange-unit__373c0__o3tjT arrange-unit-grid-column--4__373c0__33Wpc border-color--default__373c0__3-ifU']//div//p[text()='Phone number']//following::p[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", telefono);
        Assert.assertTrue(telefono.isDisplayed());
        return telefono.getText();
    }

    public String recuperarDireccion(WebDriver driver){
        WebElement direccion = driver.findElement(By.xpath("//section//h4[text()='Location & Hours']//following::div[@class='lemon--div__373c0__1mboc pseudoIsland__373c0__Fak5q']//address"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", direccion);
        Assert.assertTrue(direccion.isDisplayed());
        return direccion.getText();
    }

    public String recuperarOpinion(WebDriver driver, String numero) throws InterruptedException {
        WebElement barraBusqueda = driver.findElement(By.xpath(String.format("(//section//h4[text()='Recommended Reviews']//following::div[@aria-live='polite']//ul[@class='lemon--ul__373c0__1_cxs undefined list__373c0__3GI_T']//li//div//p//span[@class='lemon--span__373c0__3997G raw__373c0__3rcx7'])[%s]",numero)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", barraBusqueda);
        Thread.sleep(500);
        return barraBusqueda.getText();
    }

    public void contarEstrellasPrimerResultado(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Search results from the first page: ");
        System.out.println("Result    |    Number of Stars(Rating)\n");
        int i=0;
        //1. Conseguir los resultados de la página mostrada
        do{
            try{
                i++;
                WebElement resultadoBusqueda = driver.findElement(By.xpath(String.format("(//h3[text()='All Results']//following::li//child::h4//child::span[text()])[%s]",i)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resultadoBusqueda);
                WebElement estrellaResultado = driver.findElement(By.xpath(String.format("(//h3[text()='All Results']//following::li//child::h4//child::span//following::span//child::div[@role='img'])[%s]",i)));
                System.out.println(resultadoBusqueda.getText() + "  |  "+estrellaResultado.getAttribute("aria-label"));
            }catch (NoSuchElementException ex){
                System.out.println("\nThe number of results shown in the first page was less than: "+i);
            }
        }while(i<=10);
        System.out.println("\nThe number of search results was: "+(i-1));
    }

    public void contarResultadosIniciales(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("\nSearch results from the first page: \n");
        int i=0;
        //Conseguir los resultados de la página mostrada
        do{
            try{
                i++;
                WebElement resultadoBusqueda = driver.findElement(By.xpath(String.format("(//h3[text()='All Results']//following::li//child::h4//child::span[text()])[%s]",i)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resultadoBusqueda);
            }catch (NoSuchElementException ex){
                System.out.println("\nThe number of results shown in the first page was less than: "+i);
            }
        }while(i<=10);
        System.out.println("\nThe number of search results was: "+(i-1));
    }

    public void contarResultadosTotales(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Search results from the first page: \n");
        int i=0;
        //1. Conseguir los resultados de la página mostrada
        do{
            try{
                i++;
                WebElement resultadoBusqueda = driver.findElement(By.xpath(String.format("(//h3[text()='All Results']//following::li//child::h4//child::span[text()])[%s]",i)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resultadoBusqueda);
                System.out.println(resultadoBusqueda.getText());
            }catch (NoSuchElementException ex){
                System.out.println("\nThe number of results shown in the first page was less than: "+i);
            }
        }while(i<=10);
        System.out.println("\nThe number of search results was: "+(i-1));
        //2. Contar el número de páginas de resultados
        WebElement numeroDePaginas = driver.findElement(By.xpath("//div//div[@aria-label='Pagination navigation']//div[@class='lemon--div__09f24__1mboc border-color--default__09f24__R1nRO text-align--center__09f24__31irQ']//span"));
        System.out.println("\nTotal page results: "+numeroDePaginas.getText());
        String strOut = numeroDePaginas.getText();
        int length = 0; int subOf = 0;
        length = strOut.length();
        if(length==7){
            subOf = length - 2;
        }else if(length==6){
            subOf = length - 1;
        }else if(length==8){
            subOf = length - 3;
        }
        String result = strOut.substring(subOf, length);
        int j= Integer.parseInt(result);
        int r = i-1;
        //3. Multiplicar
        System.out.println("\nThe total number of search results was: "+(r*j));
    }

}
