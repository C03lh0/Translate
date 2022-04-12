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

    public String translate(String string) {
        return translations.get(string);
    }

    public String translatePhrase(String phrase) {
        String [] worlds = phrase.split(" ");
        String phraseTranslate = "";
        for (String world : worlds) {
            String translatedWord = firstTranslation(world);
            phraseTranslate += " "+ translatedWord;
        }
        //Corta os espaços nas pontas das strings
        return phraseTranslate.trim();
    }

    private String firstTranslation(String world) {
        String translatedWord = translate(world);
        if(translatedWord.contains(","))
            translatedWord = translatedWord.substring(0,translatedWord.indexOf(","));
        return translatedWord;
    }

}
