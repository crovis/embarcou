/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author clovis
 */
public class NewEmptyJUnitTest {
    public static WebDriver driver;
   
    
    public NewEmptyJUnitTest() {
    }    
    
    @BeforeClass
    public static void setUpClass() {
      driver= new FirefoxDriver();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    

    
    @Test
    public void buscarTeste7(){
        driver.get("http://localhost:8080/Embarcou/gasgyagsygas");
        
        String erro404 = driver.findElement(By.id("erro404")).getText();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        //driver.get("http://localhost:8080/Embarcou/admin/");
        
        assertEquals(erro404, "Erro 404!");
        
    }
    
    
    
}