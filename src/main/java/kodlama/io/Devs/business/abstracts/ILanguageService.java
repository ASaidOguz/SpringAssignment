package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> getAll();

    List<Language> add(Language language);

    List<Language> deleteById(int id) throws Exception;

    List<Language> updateById(int id,String updatedName) throws Exception;

    Language findById(int id) throws Exception;

    Language findByLangName(String LangName);

    boolean IsSameNameExist(String updatedName)throws Exception;

    boolean IsNameNull(Language language)throws Exception;

    List<Language> addLanguage(Language language) throws Exception;


}
