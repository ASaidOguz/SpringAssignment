package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ILanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageManager implements ILanguageService {
   private ILanguageRepository languageRepository;

   public LanguageManager(ILanguageRepository languageRepository){
       super();
       this.languageRepository=languageRepository;
   }
    @Override
    public List<Language> getAll() {
        return this.languageRepository.getAll();
    }

    @Override
    public List<Language> add(Language language) {
        return languageRepository.add(language);
    }

    @Override
    public List<Language> deleteById(int id) throws Exception {
        findById(id);// throws exception so its form of validation...does it exist in repo ?
        return languageRepository.delete(id);
    }

    @Override
    public List<Language> updateById(int id, String updatedName) throws Exception {
        findById(id);
        IsSameNameExist(updatedName);
        return languageRepository.update(id, updatedName);
    }

    @Override
    public Language findById(int id) throws Exception {
        Language isExist=languageRepository.findById(id);
        if (isExist!=null){
              return isExist;
        }else{
           throw new Exception(id+" Kimlik No'lu dil bulunmaktadır!");
        }
    }

    @Override
    public Language findByLangName(String LangName) {
        Language isExist=languageRepository.findByName(LangName);
        if (isExist!=null){
            return isExist;
        }else{
           return null;
        }
    }

    @Override
    public boolean IsSameNameExist(String updatedName)throws Exception {
       //İsim varmı algoritması.
       Language isExist=languageRepository.findByName(updatedName);
       if(isExist==null){
           return true;
       }else{
           throw new Exception(updatedName+" isme sahip bir dil bulunmaktadır!");
       }
    }

    @Override
    public boolean IsNameNull(Language language) throws Exception {
       //Kurs ismi boş geçemez algoritması!!
        String isNull=language.getName().replaceAll(" ","");

        if(isNull.equals("")||isNull.equals(null)){
            throw new Exception("Dil ismi boş olamaz!");
        }else{
            language.setName(language.getName().trim());
        }
       return true;
    }

    @Override
    public List<Language> addLanguage(Language language) throws Exception {
        if(IsSameNameExist(language.getName())&&IsNameNull(language)){
            return add(language);
        }else{
            throw new Exception(language.getName()+" bu isimli bir dil bulunmaktadır !");
        }
    }
}
