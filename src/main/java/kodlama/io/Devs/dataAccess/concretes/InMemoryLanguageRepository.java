package kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements ILanguageRepository {
    private List<Language> languages;//List of languages ,List is interface and array list is class(concrete)

    @Autowired
    public InMemoryLanguageRepository(){
        languages = new ArrayList<Language>(); // initialize the list of languages with new ArrayList object
        languages.add(new Language(1, "C#")); // add new language to the list
        languages.add(new Language(2, "Go-lang"));
        languages.add(new Language(3, "Python"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public List<Language> add(Language language) {
        languages.add(language);
        return languages;
    }

    @Override
    public List<Language> update(int id, String updatedName) {
        for (Language language:languages){
            if (language.getId()==id){
                language.setName(updatedName);
                break;
            }
        }
        return languages;
    }

    @Override
    public List<Language> delete(int id) {

        for (Language language : languages) {
            if (language.getId() == id) {
                languages.remove(id - 1);
                break;
            }
        }
        return languages;
    }

    @Override
    public Language findById(int id) {
        for(Language language:languages){
          if(language.getId()==id){
              return language;
          }
        }
        return null;
    }

    @Override
    public Language findByName(String langName) {
        for(Language language:languages) {
            if (langName.toLowerCase().equals(language.getName().toLowerCase())) {
                return language;
            }
        }
        return null;
    }

}
