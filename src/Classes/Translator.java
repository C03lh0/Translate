package Classes;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> translations = new HashMap<>();

    public boolean isEmpity() {
        return translations.isEmpty();
    }

    public void AddTranslation(String world, String translation) {
        if(translations.containsKey(world))
            translation = translate(world) + ", "+ translation;
        this.translations.put(world, translation);
    }

    public Object translate(String string) {
        return translations.get(string);
    }

    public Object translatePhrase(String phrase) {
        String [] worlds = phrase.split(" ");
        String phraseTranslate = "";
        for (String world : worlds) {
            phraseTranslate += " "+translate(world);
        }
        //Corta os espaços nas pontas das strings
        return phraseTranslate.trim();
    }

}
