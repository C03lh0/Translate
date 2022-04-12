package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Classes.Translator;

public class TranslateTests {

    private Translator t;
    @Before
    public void createTranslator(){
        t = new Translator();
    }

    @Test
    public void translateWithoutWorld(){
        assertTrue(t.isEmpity()); 
    }

    @Test
    public void oneTranslate(){
       
        t.AddTranslation("bom", "good");
        assertFalse(t.isEmpity());
        assertEquals("good", t.translate("bom")); 
    }

    @Test
    public void twoTranslate(){
     
        t.AddTranslation("bom", "good");
        t.AddTranslation("mau", "bad");
        assertEquals("good", t.translate("bom")); 
        assertEquals("bad", t.translate("mau"));
    }

    
    @Test
    public void twoTranslateSameWorld(){
     
        t.AddTranslation("bom", "good");
        t.AddTranslation("bom", "nice");
        assertEquals("good, nice", t.translate("bom")); 
        
    }

    @Test
    public void translatPhrase(){
     
        t.AddTranslation("guerra", "war");
        t.AddTranslation("é", "is");
        t.AddTranslation("ruim", "bad");
        assertEquals("war is bad", t.translatePhrase("guerra é ruim")); 
    }

    @Test
    public void  translatePhraseWithTwoTranslationsSameWorld(){
     
        t.AddTranslation("paz", "peace");
        t.AddTranslation("é", "is");
        t.AddTranslation("bom", "good");
        t.AddTranslation("bom", "nice");
        assertEquals("peace is good", t.translatePhrase("paz é bom")); 
    }
}
