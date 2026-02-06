package se.iths.josefine.projekttvabyggmiljoer.e2e;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class balanceE2ETest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext browserContext;
    Page page;
    Response response;

    @BeforeAll
    static void setUpBeforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowserAfterAll() {
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterEach
    void closeContextAfterEach() {
        browserContext.close();
    }

    @Test
    void reachablePageTest() {
        response = page.navigate("http://localhost:8080/balance");
        // Kod 200 etyder att allt gick bra i testet, servern svarar korrekt utan fel
        assertEquals(200, response.status());
    }

    @Test
    void pageGetCorrectTitleTest() {
        page.navigate("http://localhost:8080/balance");
        assertTrue(page.locator("h1").textContent().contains("Saldo"));
    }

    @Test
    void getCorrectBalanceTest() {
        page.navigate("http://localhost:8080/balance");
        assertTrue(page.content().contains("0 kr"));
    }
}
