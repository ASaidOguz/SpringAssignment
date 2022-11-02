package kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface ILanguageRepository {
    List<Language> getAll();//gets all languages;

    List<Language> add(Language language);//Add new language and return the updated list...

    List<Language> update(int id, String updatedName);//update the language and return the updated list...

    List<Language> delete(int id);//delete the language and return the updated list...

    Language findById(int id);//find by id and return the Language object...

    Language findByName(String langName);//find by language name

}
