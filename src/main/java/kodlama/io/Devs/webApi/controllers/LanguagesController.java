package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.ILanguageService;
import kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private ILanguageService languageService;
    @Autowired
    public LanguagesController(ILanguageService languageService){
        super();
        this.languageService=languageService;
    }
    @GetMapping("/getall")
    public List<Language> getAll(){
        return languageService.getAll();
    }
    @GetMapping("/findbyid")
    public Language findById(int id) throws Exception {
        return languageService.findById(id);
    }
    @GetMapping("/findbyname")
    public Language findByName(String updatedName) {
        return languageService.findByLangName(updatedName);
    }
    @GetMapping("/issamenameexist")
    public boolean sameNameIsExist(String langName) throws Exception {
        return languageService.IsSameNameExist(langName);
    }
    @PostMapping("/addcourse")
    public List<Language> addCourse(Language course) throws Exception{
        return languageService.addLanguage(course);

    }
    @DeleteMapping("/deletebyid")
    public List<Language> deleteById(int id) throws Exception{
        return languageService.deleteById(id);
    }
    @PutMapping("/updatebyname")
    public List<Language> updateById(int id, String langName) throws Exception {
        return languageService.updateById(id, langName);
    }
}
